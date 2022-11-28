package ar.edu.utn.frc.tup.ps.psappbe.entities.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonFieldsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
