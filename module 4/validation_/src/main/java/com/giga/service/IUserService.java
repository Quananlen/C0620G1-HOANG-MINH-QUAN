package com.giga.service;

import com.giga.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    Page<User> findAll(Pageable pageable);
}
