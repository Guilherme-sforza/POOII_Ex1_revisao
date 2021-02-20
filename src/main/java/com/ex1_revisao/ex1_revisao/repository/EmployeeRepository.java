package com.ex1_revisao.ex1_revisao.repository;

import java.util.ArrayList;
import java.util.List;

import com.ex1_revisao.ex1_revisao.entities.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    
    public List<Employee> getEmployees(){
        Employee e1 = new Employee();
        e1.setId(21l);
        e1.setName("Jose");
        e1.setAdress("Rua A, 1");
        e1.setJob("Porteiro");

        Employee e2 = new Employee();
        e2.setId(6l);
        e2.setName("Maria");
        e2.setAdress("Rua B, 2");
        e2.setJob("Secretaria");

        List <Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        return list;
    }
}
