package ar.edu.utn.frc.tup.ps.psappbe.repository;

import ar.edu.utn.frc.tup.ps.psappbe.entities.project.IssueTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueTrackerRepository extends JpaRepository<IssueTrackerEntity, Long> {
}
