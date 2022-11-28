package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectScope;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectScopeEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectScopeRepository;
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
public class ProjectScopeServiceImpl extends BaseModelServiceImpl<ProjectScope, ProjectScopeEntity> implements ProjectScopeService {

    private final ProjectScopeRepository projectScopeRepository;

    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return projectScopeRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

}
