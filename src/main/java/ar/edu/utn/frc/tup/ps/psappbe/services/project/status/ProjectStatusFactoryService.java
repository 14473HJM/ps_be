package ar.edu.utn.frc.tup.ps.psappbe.services.project.status;

import ar.edu.utn.frc.tup.ps.psappbe.domain.project.Project;
import ar.edu.utn.frc.tup.ps.psappbe.domain.project.ProjectStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProjectStatusFactoryService {

    private final ProjectStatusServiceCreated projectStatusServiceCreated;
    private final ProjectStatusServiceUnderPropReview projectStatusServiceUnderPropReview;
    private final ProjectStatusServicePropAccepted projectStatusServicePropAccepted;
    private final ProjectStatusServiceWip projectStatusServiceWip;
    private final ProjectStatusServiceUnderFinalReview projectStatusServiceUnderFinalReview;
    private final ProjectStatusServiceReadyToDeliver projectStatusServiceReadyToDeliver;
    private final ProjectStatusServiceDelivered projectStatusServiceDelivered;
    private final ProjectStatusServiceFinished projectStatusServiceFinished;
    private final ProjectStatusServiceCancelled projectStatusServiceCancelled;

    public ProjectStatusService getProjectStatusService(Project project) {
        switch (project.getProjectStatus()) {
            case CREATED:
                return projectStatusServiceCreated;
            case UNDER_PROP_REVIEW:
                return projectStatusServiceUnderPropReview;
            case PROP_ACCEPTED:
                return projectStatusServicePropAccepted;
            case WIP:
                return projectStatusServiceWip;
            case UNDER_FINAL_REVIEW:
                return projectStatusServiceUnderFinalReview;
            case READY_TO_DELIVER:
                return projectStatusServiceReadyToDeliver;
            case DELIVERED:
                return projectStatusServiceDelivered;
            case FINISHED:
                return projectStatusServiceFinished;
            case CANCELED:
                return projectStatusServiceCancelled;
            default:
                throw new IllegalArgumentException("El proyecto no tiene un estado correcto. por favor contactar con " +
                        "el tutor de la PS o con el administrador del sistema.");
        }
    }
}
