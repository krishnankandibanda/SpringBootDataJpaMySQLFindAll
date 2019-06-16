package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;


@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	public EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(" ....**************---EmployeeRunner---**************....");
		
		//Bulk Insert
		List<Employee> emp = Arrays.asList(	
				new Employee(101,"Krish",9.5),
				new Employee(102,"Latha",6.5),
				new Employee(103,"Devi ",3.5),
				new Employee(104,"PNR  ",4.5),
				new Employee(105,"Navya",3.5),
				new Employee(106,"Navya",2.5),
				new Employee(112,"Mom  ",3.5),
				new Employee(113,"Mani ",9.5),
				new Employee(114,"Srini",10.3)
				);

		repo.saveAll(emp);

		//Fetch All Rows
		List<Employee> listall = repo.findAll();
		listall.forEach(System.out::println);
		
		//Sort class has inner enum Direction having value : ASC,DESC...Default is ASC
		repo.findAll(Sort.by(Direction.DESC, "empSal"))
			.forEach(System.out::println);
		
		//Using  Sort.by() Methods 
		repo.findAll(Sort.by("empName"))
			.forEach(System.out::println);
		
		//fetch data based on Pagination Process ,Pageable is a interface, implementation class is PageRequest
		// Having static Factory method is ---- of(...)
		PageRequest pr = PageRequest.of(1, 3);
			repo.findAll(pr).forEach(System.out::println);
	
	}
}
