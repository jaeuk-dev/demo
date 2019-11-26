package com.example.demo.access.repository;

import javax.persistence.EntityManager;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.access.entity.Access;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long>{

}
