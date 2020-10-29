package com.giga.service;

import com.giga.entity.BlogEntry;
import com.giga.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<BlogEntry> display(Pageable pageable) {
        return blogRepository.findByOrderByDateDesc(pageable);
    }

    @Override
    public Page<BlogEntry> display(Pageable pageable, String keyword) {
        return blogRepository.findByTitleContainingOrderByDateDesc(pageable, keyword);
    }

    @Override
    public Page<BlogEntry> display(Pageable pageable, Integer category) {
        return blogRepository.findByCategory_IdOrderByDateDesc(pageable, category);
    }

    @Override
    public List<BlogEntry> display() {
        return blogRepository.findByOrderByDateDesc();
    }

    @Override
    public List<BlogEntry> findByCategoryId(Integer id) {
        return blogRepository.findEntriesByCategory_Id(id);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public BlogEntry getEntry(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(BlogEntry blogEntry) {
        blogRepository.save(blogEntry);
    }

    @Override
    public void create(BlogEntry blogEntry) {
        blogEntry.setDate(String.valueOf(java.time.LocalDate.now()));
        blogRepository.save(blogEntry);
    }
}
