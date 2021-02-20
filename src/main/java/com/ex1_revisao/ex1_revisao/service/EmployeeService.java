package com.ex1_revisao.ex1_revisao.service;

import java.util.ArrayList;
import java.util.List;

import com.ex1_revisao.ex1_revisao.dto.EmployeeDTO;
import com.ex1_revisao.ex1_revisao.entities.Employee;
import com.ex1_revisao.ex1_revisao.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired 
    private EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees(){

        List<Employee> list = repository.getEmployees();
        List<EmployeeDTO> listDTO = new ArrayList<>();

        for(Employee e: list){
            EmployeeDTO dto = new EmployeeDTO(e.getId(), e.getName(), e.getJob());
            listDTO.add(dto);
        }

        return listDTO;
    }
}
