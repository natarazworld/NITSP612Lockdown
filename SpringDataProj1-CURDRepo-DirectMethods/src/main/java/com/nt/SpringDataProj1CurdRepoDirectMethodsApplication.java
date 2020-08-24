package com.nt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;

@SpringBootApplication
public class SpringDataProj1CurdRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerMgmtService service = null;
		CustomerDTO dto = null, dto1 = null, dto2 = null;
		List<CustomerDTO> listDTO = null;
		// get IOC container
		ctx = SpringApplication.run(SpringDataProj1CurdRepoDirectMethodsApplication.class, args);
		// get Service class obj
		service = ctx.getBean("custService", CustomerMgmtService.class);
		// invoke method
		/*	try {
				dto=new CustomerDTO();
				dto.setCno(4568);
				dto.setCname("rajesh1"); dto.setCadd("hyd1"); dto.setBillAmt(8000);
				System.out.println(service.registerCustomer(dto));
			}//try
			catch(DataAccessException dae){
				dae.printStackTrace();
			}*/

		System.out.println("---------------------------------------------");
		/*dto=new CustomerDTO();
		dto.setCname("rajesh1"); dto.setCadd("hyd1"); dto.setBillAmt(8000);
		dto1=new CustomerDTO();
		dto1.setCname("raj"); dto1.setCadd("hyd"); dto1.setBillAmt(8000);
		dto2=new CustomerDTO();
		dto2.setCname("suresh"); dto2.setCadd("delhi"); dto2.setBillAmt(8000);
		try {
			//System.out.println(service.registerGroupCustomers(Arrays.asList(dto1,dto,dto2)));  //old
			
			System.out.println(service.registerGroupCustomers(List.of(dto,dto1,dto2))); //java 9
		
			listDTO=new ArrayList();
			listDTO.add(dto); 	listDTO.add(dto1); 	listDTO.add(dto2);
			System.out.println(service.registerGroupCustomers(listDTO)); //old
			
			
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		*/
		/*	System.out.println(".........................");
			System.out.println(service.removeCustomerById(31));*/
		/*System.out.println("...............................");
		System.out.println("delete fewcustoemrs ::"+service.removeGivenCustomers(List.of(new CustomerDTO(21),
				                                                                                                                                              new CustomerDTO(32))));
		*/
		
		System.out.println("...........................");
		
	//	System.out.println("Customers count::"+service.fetchCustomerCount());
		
		//System.out.println(service.fetchAllCustomers());  //old  (toString())
		  service.fetchAllCustomers().forEach(System.out::println);  //java8 method reference
		  service.fetchAllCustomers().forEach(dt->{   //java forEach  (java8)
			  System.out.println(dt);
		  });
		  
		

		// close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
