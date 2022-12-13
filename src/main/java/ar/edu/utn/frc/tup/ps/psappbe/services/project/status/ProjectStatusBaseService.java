package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Conversation;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.ProfessorService;
import ar.edu.utn.frc.tup.ps.psappbe.services.people.StudentService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.CommentService;
import ar.edu.utn.frc.tup.ps.psappbe.services.project.ProjectService;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Slf4j
public abstract class ProjectStatusBaseService implements ProjectStatusService {

    private final CommentService commentService;

    protected final ProfessorService professorService;

    protected final UserService userService;

    protected final StudentService studentService;

    abstract ProjectStatus previous();
    abstract ProjectStatus current();
    abstract ProjectStatus next();

    abstract void validateMoveOn(Project project);

    abstract void validateMoveBack(Project project);

    abstract void validateCancel(Project project);

    @Override
    public Project moveOn(Project project, Comment comment) {
        validateComment(comment);
        validateCommentator(comment);
        validateOwnership(project, comment);
        if(project.getProjectStatus() != this.current()) {
            throw new IllegalArgumentException("Transición no permitida de " + project.getProjectStatus().name()
                    + " a " + next());
        }
        validateMoveOn(project);

        Conversation conversation = project.getConversation();
        comment.setConversationId(conversation.getId());
        comment = commentService.create(comment);
        project.setProjectStatus(next());

        return project;
    }

    @Override
    public Project moveBack(Project project, Comment comment) {
        validateComment(comment);
        validateCommentator(comment);
        validateOwnership(project, comment);
        validateProfessorRequest(comment);
        if(project.getProjectStatus() != this.current()) {
            throw new IllegalArgumentException("Transición no permitida de " + project.getProjectStatus().name()
                    + " a " + this.previous());
        }
        validateMoveBack(project);
        Conversation conversation = project.getConversation();
        comment.setConversationId(conversation.getId());
        comment = commentService.create(comment);
        project.setProjectStatus(this.previous());
        return project;
    }

    @Override
    public Project cancel(Project project, Comment comment) {
        validateComment(comment);
        validateCommentator(comment);
        validateOwnership(project, comment);
        validateProfessorRequest(comment);
        validateCancel(project);
        Conversation conversation = project.getConversation();
        comment.setConversationId(conversation.getId());
        comment = commentService.create(comment);
        project.setProjectStatus(ProjectStatus.CANCELED);
        return project;
    }

    protected void validateComment(Comment comment) {
        if(comment == null || comment.getComment() == null || comment.getComment().isBlank()) {
            throw new IllegalArgumentException("Es obligatorio dejar un comentario para mover el projecto de estados.");
        }
    }

    protected void validateCommentator(Comment comment) {
        if(comment != null && comment.getCommentator() == null || comment.getCommentator().getId() == null) {
            throw new IllegalArgumentException("Es obligatorio indicar quien hace el comentario.");
        }
    }

    protected void validateProfessorRequest(Comment comment) {
        if(comment == null ||
                comment.getCommentator() == null ||
                comment.getCommentator().getObjectType() != Professor.OBJECT_TYPE) {
            throw new IllegalArgumentException("Esta transición solo esta permitida para profesores. " +
                    "Por favor ponerse en contacto con su tutor de la PS.");
        }
    }

    protected void validateOwnership(Project project, Comment comment) {
        if(comment != null &&
                comment.getCommentator() != null &&
                comment.getCommentator().getId() != null &&
                comment.getCommentator().getObjectType() != null) {
            if(comment.getCommentator().getObjectType() == Professor.OBJECT_TYPE) {
                Professor professor = professorService.getById(comment.getCommentator().getId());
                if(!isOwner(project, professor) ||
                        !userService.isAdmin(professor.getUser())) {
                    throw new IllegalArgumentException("Esta transición solo esta permitida para el profesor " +
                            "asignado como tutor de la PS o un Usuario administrador.");
                }
            } else {
                Student student = studentService.getById(comment.getCommentator().getId());
                if(!isOwner(project, student) ||
                        !userService.isAdmin(student.getUser())) {
                    throw new IllegalArgumentException("Esta transición solo esta permitida para alumnos " +
                            "que participan del proyecto o un Usuario administrador.");
                }
            }
        }
    }

    protected Boolean isNull(Object object) {
        return object == null;
    }

    private Boolean isOwner(Project project, Professor professor) {
        return project.getTutor().getId() == project.getId();
    }
    private Boolean isOwner(Project project, Student student) {
        return project.getTutor().getId() == project.getId();
    }
}
