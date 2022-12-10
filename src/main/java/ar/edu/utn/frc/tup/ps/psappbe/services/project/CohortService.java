package ar.edu.utn.frc.tup.ps.psappbe.services.project;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.cohort.Cohort;
import ar.edu.utn.frc.tup.ps.psappbe.entities.project.cohort.CohortEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.BaseModelService;

public interface CohortService extends BaseModelService<Cohort, CohortEntity> {

    Cohort getActiveCohort();
}
