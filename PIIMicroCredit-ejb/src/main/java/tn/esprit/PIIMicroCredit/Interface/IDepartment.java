package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Department;

@Remote
public interface IDepartment {
	public int addDepartment(Department D);
	public void removeDepartment(int id);
	public void updateDepartment(Department D);
	public Department findDepartmentById(int id);
	public List<Department> findAllDepartments();
	public List <Department> getAllDepartmentsByName(String name);
}
