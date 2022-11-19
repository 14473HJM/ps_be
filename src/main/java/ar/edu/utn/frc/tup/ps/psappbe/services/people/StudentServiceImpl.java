package ar.edu.utn.frc.tup.ps.psappbe.services.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Identification;
import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Student;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.StudentEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.StudentRepository;
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
public class StudentServiceImpl extends BaseModelServiceImpl<Student, StudentEntity> implements StudentService {

    private final StudentRepository studentRepository;

    private final IdentificationService identificationService;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository<StudentEntity, Long> getJpaRepository() {
        return studentRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Student create(Student student) {
        student.setObjectType(Student.OBJECT_TYPE);
        Identification personIdentification = identificationService.create(student.getPersonIdentification());
        Identification universityIdentification = identificationService.create(student.getUniversityIdentification());
        student.setPersonIdentification(personIdentification);
        student.setUniversityIdentification(universityIdentification);
        return super.create(student);
    }
}

