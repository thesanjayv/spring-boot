package com.example.demo;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.example.demo.entity.Address;
// import com.example.demo.entity.Student;
// import com.example.demo.repo.AddressRepo;
// import com.example.demo.repo.StudentRepo;

@SpringBootApplication
public class DatabaseConnectionApplication{

	// @Autowired
	// private StudentRepo studentRepo;

	// @Autowired
	// private AddressRepo addressRepo;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseConnectionApplication.class, args);
		System.out.println("Working!!");
	}

	// @Override
	// public void run(String... args){
	// 	System.out.println("Command line runner!!!");

	// 	Address address1 = new Address("Trivandrumn", "India");
	// 	Address address2 = new Address("Vellore", "India");
	// 	Student student1 = new Student("Sanju", "60000", address1);
	// 	Student student2 = new Student("Raju", "30000", address2);

	
	// 	studentRepo.save(student1);
	// 	studentRepo.save(student2);

	
		// System.out.println(addressRepo.save(address1));
		// System.out.println(studentRepo.save(student1));
		// System.out.println(addressRepo.save(address2));
		// System.out.println(studentRepo.save(student2));

		// Student studentRet = studentRepo.findById(1453).get();
		// System.out.println(studentRet);

		// Address addressRet = studentRet.getAddress();
		// System.out.println(addressRet);
	// }
}
