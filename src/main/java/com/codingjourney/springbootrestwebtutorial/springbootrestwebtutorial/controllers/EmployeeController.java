package com.codingjourney.springbootrestwebtutorial.springbootrestwebtutorial.controllers;

import com.codingjourney.springbootrestwebtutorial.springbootrestwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    //ComponentScan , it will tell the dispatcher servlet that all the mappings define here are the mappings you should the server
//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage() {
//        return "$fswhdgus";
//    }

    @GetMapping(path = "/employees/{employeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeID){
        return new EmployeeDTO(employeeID, "Paras", "parasgupta3062000@gmail.com", 25 , LocalDate.of(2024, 01, 20), true);
    }

}
