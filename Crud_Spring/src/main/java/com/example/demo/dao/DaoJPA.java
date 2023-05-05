package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DaoJPA implements EmployeeDao {

	private EntityManager enmanager;
	
	@Autowired
	public DaoJPA(EntityManager theEntityManager) {
		enmanager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		TypedQuery<Employee> theQuery = enmanager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmployee = enmanager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		Employee dbEmployee = enmanager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Employee theEmployee = enmanager.find(Employee.class, theId);
		enmanager.remove(theEmployee);
	}

	
}
