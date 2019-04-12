package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.PIIMicroCredit.Interface.IDepartment;
import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.Department;
@Stateless
@Remote
public class DepartmentService implements IDepartment {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addDepartment(Department d) {
		em.persist(d);
		System.out.println("Out of addDepartment" + d.getId());
		return d.getId();
	}

	@Override
	public void removeDepartment(int id) {
		System.out.println("In removeDepartment: ");
		em.remove(em.find(Department.class, id));
		System.out.println("Out of removeDepartment: ");

	}

	@Override
	public void updateDepartment(Department d) {
		System.out.println("In updateDepartment: ");
		Department department = em.find(Department.class, d.getId());
		department.setName(d.getName());
		

	}

	@Override
	public Department findDepartmentById(int id) {
		System.out.println("In findDepartmentById: ");
		Department d = em.find(Department.class, id);
		System.out.println("Out of findDepartmentById: ");
		return d;
	}

	@Override
	public List<Department> findAllDepartments() {
		System.out.println("In findAllDepartments: ");
		List<Department> deps = em.createQuery("from Department", Department.class).getResultList();
		System.out.println("Out of findAllDepartments: ");
		return deps;
	}
	 @Override
	    public List <Department> getAllDepartmentsByName(String name)
	    {
	    	
	    	
	    	String sql = "select i from Department i where i.name like '"+name+"%'";
			List<Department> emp = em.createQuery(sql, Department.class).getResultList();
			return emp;		
	    	
	    }

}
