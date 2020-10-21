package com.giga.repository;

import com.giga.entity.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Entry, Integer> {
    Page<Entry> findByOrderByDateDesc(Pageable pageable);

    Page<Entry> findByTitleContainingOrderByDateDesc(Pageable pageable, String keyword);

    Page<Entry> findByCategory_IdOrderByDateDesc(Pageable pageable, Integer category);

}
