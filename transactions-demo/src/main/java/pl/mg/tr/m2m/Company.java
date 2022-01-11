package pl.mg.tr.m2m;

import lombok.Data;
import lombok.ToString.Exclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @Exclude
    private List<Employee> employees;

    public void addEmployee(Person person) {
        Employee employee = new Employee(this, person, "emp");
        this.employees.add(employee);
        person.getEmployees().add(employee);
    }

}
