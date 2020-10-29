package com.giga.controller;

import com.giga.entity.BlogEntry;
import com.giga.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blog/api")
@RestController
@CrossOrigin
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<BlogEntry>> find() {
        return new ResponseEntity<>(blogService.display(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/small-list")
    public ResponseEntity<Page<BlogEntry>> findPage(Pageable pageable) {
        return new ResponseEntity<>(blogService.display(pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findByCategory/{id}")
    public ResponseEntity<List<BlogEntry>> findByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.findByCategoryId(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createEntry(@RequestBody BlogEntry blogEntry) {
        blogService.create(blogEntry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
