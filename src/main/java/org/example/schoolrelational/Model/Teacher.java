package org.example.schoolrelational.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "cant be null")
    private String name;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer salary;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


  @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;

}
