package org.asanta.demoprimeface.repository;

import org.asanta.demoprimeface.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	List<Employee> findByLastName(String lastName);
	Employee findById(long id);

}
