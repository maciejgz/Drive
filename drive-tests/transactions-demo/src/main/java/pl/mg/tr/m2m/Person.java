package pl.mg.tr.m2m;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString.Exclude;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@EqualsAndHashCode
@Data
public class Person {

    @Id
    private String username;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Exclude
    private List<Employee> employees = new ArrayList<>();

}
