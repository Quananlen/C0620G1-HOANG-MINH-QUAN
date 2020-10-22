package com.giga.service;

import com.giga.entity.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();
}
