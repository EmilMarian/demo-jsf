package org.asanta.demoprimeface.bean;



import org.apache.commons.collections4.IterableUtils;
import org.asanta.demoprimeface.entity.Employee;
import org.asanta.demoprimeface.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ManagedBean
@ViewScoped
public class EmployeeBean {
	private Logger logger= Logger.getLogger(EmployeeBean.class.getName());
	
	
	private EmployeeRepository employeeRepository;
	private List<Employee> allEmployees = null;
	private String firstName;
	private String lastName;
	private long id;
	private boolean canEdit =  false;
	
	@Autowired
	public EmployeeBean(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	public void getEmployeeList () {
		allEmployees = IterableUtils.toList(employeeRepository.findAll());
	}
	
	
	public int getNumberEmployee(){
		return IterableUtils.size(employeeRepository.findAll());
	}
	
	
	
	public String add() {
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employeeRepository.save(employee);
		
		firstName = "";
		lastName = "";
		
		return "success";
	}
	
	public long getId(){
		return id;
	}
	
	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public List<Employee> getAllEmployees(){
		return allEmployees;
	}
}