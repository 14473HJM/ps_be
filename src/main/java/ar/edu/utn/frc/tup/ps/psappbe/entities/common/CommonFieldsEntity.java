package ar.edu.utn.frc.tup.ps.psappbe.entities.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonFieldsEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String objectType;
    private LocalDateTime createdDate;
    private String createdUser;
    private LocalDateTime lastUpdatedDate;
    private String lastUpdatedUser;
    private LocalDateTime deletedDate;
    private String deletedUser;
    private String recordStatus;
}
