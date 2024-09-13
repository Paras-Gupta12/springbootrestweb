package com.codingjourney.springbootrestwebtutorial.springbootrestwebtutorial.controllers;

import com.codingjourney.springbootrestwebtutorial.springbootrestwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")// for parent
public class EmployeeController {

    //ComponentScan , it will tell the dispatcher servlet that all the mappings define here are the mappings you should the server
//    @GetMapping(path = "/getSecretMessage")
//    public String getSecretMessage() {
//        return "$fswhdgus";
//    }

    @GetMapping(path = "/{employeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeID){
        return new EmployeeDTO(employeeID, "Paras", "parasgupta3062000@gmail.com", 25 , LocalDate.of(2024, 01, 20), true);
    }

    @GetMapping
    public String getALLEmployees(@RequestParam(required = false) Long age,
                                  @RequestParam(required = false) String name){
        return "Hi age "+age+" "+name;
    }

}
