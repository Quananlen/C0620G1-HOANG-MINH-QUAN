package com.giga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Permission {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "permissionSet")
    private Set<User> userSet;
}
