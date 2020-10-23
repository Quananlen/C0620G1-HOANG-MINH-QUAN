package com.giga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_composed")
    private String year;

    @Column(name = "author")
    private String author;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Code> codeSet = new LinkedHashSet<>();

    public void generateCode(Code code) {
        codeSet.add(code);
    }

    public void borrow() {
        if (quantity > 0) quantity--;
    }

    public void returnBook() {
        quantity++;
    }
}
