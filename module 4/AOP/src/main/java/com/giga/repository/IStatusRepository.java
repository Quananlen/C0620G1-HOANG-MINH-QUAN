package com.giga.repository;

import com.giga.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status, Integer> {
}
