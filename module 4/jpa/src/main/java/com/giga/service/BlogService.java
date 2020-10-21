package com.giga.service;

import com.giga.entity.Entry;
import com.giga.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Entry> display(Pageable pageable) {
        return blogRepository.findByOrderByDateDesc(pageable);
    }

    @Override
    public Page<Entry> display(Pageable pageable, String keyword) {
        return blogRepository.findByTitleContainingOrderByDateDesc(pageable, keyword);
    }

    @Override
    public Page<Entry> display(Pageable pageable, Integer category) {
        return blogRepository.findByCategory_IdOrderByDateDesc(pageable, category);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Entry getEntry(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Entry entry) {
        blogRepository.save(entry);
    }

    @Override
    public void create(Entry entry) {
        blogRepository.save(entry);
    }
}
