package com.ex1_revisao.ex1_revisao.dto;

import com.ex1_revisao.ex1_revisao.entities.Employee;

public class EmployeeDTO {
   private Long id;
   private String name;
   private String job;

   public EmployeeDTO(){

   }

   public EmployeeDTO(Long id, String name, String job){
       this.id = id;
       this.name = name;
       this.job = job;
   }

    public EmployeeDTO(Employee em) {
        this.id = em.getId();
        this.name = em.getName();
        this.job = em.getJob();
    }

    public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getJob() {
       return job;
   }

   public void setJob(String job) {
       this.job = job;
   }

}
