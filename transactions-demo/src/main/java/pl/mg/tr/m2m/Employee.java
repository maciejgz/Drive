package pl.mg.tr.m2m;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "employee")
@Entity(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @EmbeddedId
    private EmployeeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    @Column(name = "position")
    private String position;

    public Employee(Company company, Person person, String position) {
        this.company = company;
        this.person = person;
        this.position = position;
        this.id = new EmployeeId(company.getId(), person.getUsername());
    }
}
