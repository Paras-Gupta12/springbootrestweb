package com.techlearning.springbootwebtutorial.springbootwebtutorial.controllers;


import com.techlearning.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.techlearning.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.techlearning.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import com.techlearning.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path ="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "bednkuriu";
//    }

//    @GetMapping(path = "/{employeeID}")
//    public EmployeeDTO getEmployeeByID(@PathVariable(name="employeeID") Long id){
//        return new EmployeeDTO(id, "Paras", "parasgupta3062000@gmail.com", 24, LocalDate.of(2000, 6 ,30), true);
//    }

    @GetMapping(path = "/{employeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable(name="employeeID") Long id){
        return employeeService.getEmployeeByID(id);
    }

//    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false) Integer age,
//                                  @RequestParam(required = false) String sortBy){
//        return "Hi age " +age + " "+sortBy;
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

//    @PostMapping
//    public String createNewEmployee(){
//        return "Hello from POST";
//    }

//    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from Put";
    }
}
