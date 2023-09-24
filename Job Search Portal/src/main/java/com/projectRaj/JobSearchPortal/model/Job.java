package com.projectRaj.JobSearchPortal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    private Long id;

    @NotBlank(message = "Title shouldn't be blank")
    private String title;

    @NotBlank(message = "Must provide some description")
    private String description;

    @NotBlank(message = "Location can't be blank")
    private String location;

    @Min(value = 20000, message = "Salary must be greater than or equal to Rs 20000")
    private Double salary;

    @Email(message = "Invalid email. Please enter a valid email")
    private String companyEmail;

    @NotBlank(message = "Company name can't be empty")
    private String companyName;

    @NotBlank(message = "Employer name is mandatory")
    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;

    // Assuming appliedDate is a string because of the pattern validation
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must match yyyy-MM-dd format")
    private String appliedDate;
}
