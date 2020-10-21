package com.giga.service;

import com.giga.entity.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Entry> display(Pageable pageable);

    Page<Entry> display(Pageable pageable, String keyword);

    Page<Entry> display(Pageable pageable, Integer category);

    void delete(Integer id);

    Entry getEntry(Integer id);

    void update(Entry entry);

    void create(Entry entry);
}
