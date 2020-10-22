package com.giga.repository;

import com.giga.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissionRepository extends JpaRepository<Permission, Integer> {
}
