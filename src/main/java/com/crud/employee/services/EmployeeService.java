package com.crud.employee.services;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.employee.model.EmployeeModel;
import com.crud.employee.repositories.EmployeeRepository;


@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    public ArrayList<EmployeeModel> getEmployee(){
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel saveEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }
    
    public Optional<EmployeeModel> findEmployeeById(Long id){
        return employeeRepository.findById(id);
    }


    public boolean deleteEmployee(Long id) {
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}

