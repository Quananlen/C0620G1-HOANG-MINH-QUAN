package com.giga.entity;

import com.giga.annotation.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @Size(min = 2, max = 45)
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Size(min = 2, max = 45)
    private String lastName;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\d{9,11}", message = "Phone must have 9 to 11 digits")
    private String phone;

    @Column(name = "age")
    @Min(18)
    @NotNull
    private Integer age;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "city")
    @City
    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissionSet;
}
