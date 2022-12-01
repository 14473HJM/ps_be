package ar.edu.utn.frc.tup.ps.psappbe.services.people;

import ar.edu.utn.frc.tup.ps.psappbe.domain.people.Professor;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.ProfessorEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.people.StudentEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProfessorRepository;
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
public class ProfessorServiceImpl extends BaseModelServiceImpl<Professor, ProfessorEntity> implements ProfessorService {

    private final ProfessorRepository studentRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return studentRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
