package com.giga.service;

import com.giga.entity.BlogEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogEntry> display(Pageable pageable);

    Page<BlogEntry> display(Pageable pageable, String keyword);

    Page<BlogEntry> display(Pageable pageable, Integer category);

    List<BlogEntry> display();

    List<BlogEntry> findByCategoryId(Integer id);

    void delete(Integer id);

    BlogEntry getEntry(Integer id);

    void update(BlogEntry blogEntry);

    void create(BlogEntry blogEntry);
}
