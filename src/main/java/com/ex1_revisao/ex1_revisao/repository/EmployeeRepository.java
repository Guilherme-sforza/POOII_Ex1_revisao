package com.ex1_revisao.ex1_revisao.repository;

import com.ex1_revisao.ex1_revisao.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    
}
