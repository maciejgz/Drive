package pl.mg.tr.m2m;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeId implements Serializable {

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "person_id")
    private String personId;



}
