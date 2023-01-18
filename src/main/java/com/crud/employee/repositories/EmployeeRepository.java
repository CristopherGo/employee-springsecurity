package com.crud.employee.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.crud.employee.model.EmployeeModel;


@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {

}
