package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.CohortStatus;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.ProjectEntity;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort.CohortEntity;
import ar.edu.utn.frc.tup.ps.psappbe.repository.CohortRepository;
import ar.edu.utn.frc.tup.ps.psappbe.repository.ProjectRepository;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CohortServiceImpl extends BaseModelServiceImpl<Cohort, CohortEntity> implements CohortService {

    private final CohortRepository cohortRepository;
    private final ModelMapper modelMapper;
    @Override
    protected JpaRepository getJpaRepository() {
        return cohortRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Cohort getActiveCohort() {
        Integer year = LocalDate.now().getYear();
        Integer month = LocalDate.now().getMonthValue();
        List<CohortEntity> cohortEntity = cohortRepository.getAllByCohortStatus(CohortStatus.OPEN);
        // Se asume que siempre hay uno y solo un cohort activo
        return map(cohortEntity.get(0));
    }

}
