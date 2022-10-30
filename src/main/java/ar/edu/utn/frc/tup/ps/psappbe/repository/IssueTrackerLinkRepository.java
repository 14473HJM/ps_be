package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.IssueTrackerLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueTrackerLinkRepository extends JpaRepository<IssueTrackerLinkEntity, Long> {
}
