package com.nt.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRenderingController {

		@GetMapping("/welcome")
		 public String     processData(Model model) {
		 System.out.println("DataRenderingController.processData()"+model.getClass());
		 model.addAttribute("msg","welcome").addAttribute("sysDate", new Date());
		
		 return "display";
		 }

	/*@GetMapping("/welcome")
	 public String     processData(Model model) {
	 String names[]=new String[] {"raja","rani","suresh","mahesh"};
	 List<String> fruitsList=List.of("apple","banana","grapes","cherries");  //java 9 .. immutable List 
	 Set<Long> phonesSet=Set.of(999999L,888888L,77777L);  //java 9 .. immutable List 
	 Map<String,Integer> ageMap=Map.of("raja",30,"rani",31,"suresh",40);
	 //add them as model attributes
	 model.addAttribute("namesInfo",names);
	 model.addAttribute("fruitsInfo",fruitsList);
	 model.addAttribute("phonesInfo",phonesSet);
	 model.addAttribute("agesInfo",ageMap);
	 
	 return "display";
	 }*/

	/*@GetMapping("/welcome")
	 public String     processData(Map<String,Object> map) {
	 System.out.println("DataRenderingController.processData()"+map.getClass());
	 System.out.println(map.getClass());
	 map.put(null,"welcome")
	 System.out.println("size::"+map.size());
	 return "display";
	 }
	*/

	/* @GetMapping("/welcome")
	  public String     processData(ModelMap map) {
		 System.out.println("DataRenderingController.processData()"+map.getClass());
		 System.out.println(map.getClass());
		 //map.put("msg","welcome");
		 map.addAttribute("msg","welcome");
		 System.out.println("size::"+map.size());
		 return "display";
	  }*/

	/*@GetMapping("/welcome")
	 public String     processData(Model model) {
		//preare ListDTO
		List<StudentDTO> listDTO=List.of(new StudentDTO(101,"raja","hyd"),
		 		                                                  new StudentDTO(102,"rajesh","vizag"),
		                                                          new StudentDTO(103,"suresh","delhi")
				                                                  );
		//add to mode attribute
		model.addAttribute("studList",listDTO);
	 return "display";
	 }*/

}
