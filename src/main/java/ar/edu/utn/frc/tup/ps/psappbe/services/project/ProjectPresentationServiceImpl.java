package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectPresentation;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectPresentationEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectPresentationRepository;
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
public class ProjectPresentationServiceImpl extends BaseModelServiceImpl<ProjectPresentation, ProjectPresentationEntity> implements ProjectPresentationService {

    private final ProjectPresentationRepository projectPresentationRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return projectPresentationRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

}

