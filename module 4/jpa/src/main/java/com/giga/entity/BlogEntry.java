package com.giga.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="date_created")
    private String date;
    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn (name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;
}
