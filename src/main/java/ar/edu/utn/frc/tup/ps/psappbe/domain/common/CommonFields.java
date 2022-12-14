package ar.edu.utn.frc.tup.ps.psappbe.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class CommonFields {
    
    private Long id;
    private String objectType;
    private LocalDateTime createdDate;
    private String createdUser;
    private LocalDateTime lastUpdatedDate;
    private String lastUpdatedUser;
    private LocalDateTime deletedDate;
    private String deletedUser;
    private String recordStatus;

    @JsonIgnore
    public abstract String getObjectTypeName();

    @JsonIgnore
    public Boolean isDeleted() {
        return this.getRecordStatus() == "DELETED";
    }
}
