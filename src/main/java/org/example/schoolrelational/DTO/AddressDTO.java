package org.example.schoolrelational.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;


    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;
}
