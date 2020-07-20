package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {
	@Query("select prj from Project prj where prj.managerId=?1")
	List<Project> findByManagerId(String managerId);
}
