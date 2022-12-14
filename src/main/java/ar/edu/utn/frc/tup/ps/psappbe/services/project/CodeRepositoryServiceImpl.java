package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.CodeRepository;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.issue.IssueTracker;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.CodeRepositoryEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.issue.IssueTrackerEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.CodeRepositoryRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.IssueTrackerRepository;
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
public class CodeRepositoryServiceImpl extends BaseModelServiceImpl<CodeRepository, CodeRepositoryEntity> implements CodeRepositoryService {

    private final CodeRepositoryRepository codeRepositoryRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return codeRepositoryRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}
