package com.example.week3_task.repository;

import com.example.week3_task.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Organisation,Long> {
}
