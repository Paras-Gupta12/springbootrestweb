package com.techlearning.springbootwebtutorial.springbootwebtutorial.services;

import com.techlearning.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.techlearning.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.techlearning.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
     private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }



    public EmployeeDTO getEmployeeByID(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        return modelMapper.map(employeeEntity , EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity ->  modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee){
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        //return employeeRepository.save(inputEmployee);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
