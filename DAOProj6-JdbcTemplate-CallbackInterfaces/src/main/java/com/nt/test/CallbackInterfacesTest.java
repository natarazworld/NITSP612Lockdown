package com.nt.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentMgmtService;

public class CallbackInterfacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentMgmtService service=null;
		StudentDTO dto=null;
		List<StudentDTO> listDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("studService",StudentMgmtService.class);
		try {
			dto=service.fetchStudentById(8901);
			System.out.println(dto);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("..........................");
		try {
			listDTO=service.fetchStudentByAddrs("hyd");
			/*###forEach
			listDTO.forEach(dto1->{
				System.out.println(dto1);
			}
			
				);*/
			//##stream api
			/*listDTO.stream().forEach(dto1->{
				System.out.println(dto1);
			});
			*/
			
			//## method reference
			//listDTO.forEach(System.out::println);
			 //System.out.println("...............");
			
			//##method refercne
			//listDTO.stream().forEachOrdered(System.out::println);
			
			//## streaming api +collectors
			//System.out.println(listDTO.stream().collect(Collectors.toList()));
			//System.out.println(listDTO);
			//System.out.println("-----------------");
			
			//###collectors to convert list to set
			//Set<StudentDTO> setDTO=listDTO.stream().collect(Collectors.toSet());	
			//System.out.println(setDTO);
	
			//# stream api + filter +method reference
			listDTO.stream().filter((avg)->avg.getAvg()>70).forEach(System.out::println);
			
			
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
