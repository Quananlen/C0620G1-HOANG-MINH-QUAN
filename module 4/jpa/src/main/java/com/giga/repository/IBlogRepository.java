package com.giga.repository;

import com.giga.entity.BlogEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogEntry, Integer> {
    Page<BlogEntry> findByOrderByDateDesc(Pageable pageable);
    List<BlogEntry> findByOrderByDateDesc();

    Page<BlogEntry> findByTitleContainingOrderByDateDesc(Pageable pageable, String keyword);

    Page<BlogEntry> findByCategory_IdOrderByDateDesc(Pageable pageable, Integer category);

    List<BlogEntry> findEntriesByCategory_Id(Integer id);
}
