package com.ex1_revisao.ex1_revisao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ex1_revisao.ex1_revisao.dto.EmployeeDTO;
import com.ex1_revisao.ex1_revisao.dto.EmployeeInsertDTO;
import com.ex1_revisao.ex1_revisao.dto.EmployeeUpdateDTO;
import com.ex1_revisao.ex1_revisao.entities.Employee;
import com.ex1_revisao.ex1_revisao.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {
    
    @Autowired 
    private EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees(){

        List<Employee> list = repository.findAll();
        return toDTOList(list);
       
    }

    private List<EmployeeDTO> toDTOList(List<Employee> list) {
        List<EmployeeDTO> listDTO = new ArrayList<>();

        for(Employee e: list){
            EmployeeDTO dto = new EmployeeDTO(e.getId(), e.getName(), e.getJob());
            listDTO.add(dto);
        }
    
        return listDTO;
    }

    public EmployeeDTO getEmployeeById(Long Id) {

        Optional<Employee> op = repository.findById(Id);

        Employee em = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));

        return new EmployeeDTO(em);
    }

    public EmployeeDTO insert (EmployeeInsertDTO dto){
        Employee entity = new Employee(dto);
        entity = repository.save(entity);
        return new EmployeeDTO(entity);
    }

    public void delete (Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    public EmployeeDTO update(Long id, EmployeeUpdateDTO dto){
        try{
            Employee entity = repository.getOne(id);
            entity.setName(dto.getName());
            entity.setJob(dto.getJob());
            entity = repository.save(entity);
            return new EmployeeDTO(entity);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
}
