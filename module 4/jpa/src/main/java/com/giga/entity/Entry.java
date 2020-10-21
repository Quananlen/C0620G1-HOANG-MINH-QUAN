package com.giga.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Entry {
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
    private Category category;
}
