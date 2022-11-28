package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.comunication.Comment;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.communication.CommentEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.CommentRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommentServiceImpl extends BaseModelServiceImpl<Comment, CommentEntity> implements CommentService {

    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return commentRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

}
