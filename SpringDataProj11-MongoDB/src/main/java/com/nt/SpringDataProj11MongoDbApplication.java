package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.Employee;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
public class SpringDataProj11MongoDbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		Employee  doc1=null;
		//get Container
       ctx=SpringApplication.run(SpringDataProj11MongoDbApplication.class, args);
       // get SErvice class object
        service=ctx.getBean("empService",EmployeeMgmtService.class);
		/*try {
			doc1=new Employee();
			doc1.setEid(422); doc1.setEname("Rajesh"); doc1.setCompany("vizag");
			doc1.setOldCompanies(new String[] {"HCL","Oracle"});
			System.out.println(service.registerEmployee(doc1));
			
		}
		catch(Exception e) {
			System.out.println("Problem registration");
			e.printStackTrace();
		}
		*/
        //service.findAllEmployees().forEach(System.out::println);
        // System.out.println(service.findEmpById(456));
         // System.out.println(service.updateEmployeeSalary(456,1000));
           System.out.println(service.removeEmployee(456));
      //close  container
  	  ((ConfigurableApplicationContext) ctx).close();

	}

	
}
