package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fresher;

@Repository
public interface FresherRepo extends JpaRepository<Fresher, String> {

}
