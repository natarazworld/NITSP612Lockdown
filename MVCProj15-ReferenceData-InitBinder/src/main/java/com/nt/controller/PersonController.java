package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Person;

@Controller
public class PersonController {
	
	@GetMapping("/person")
	public  String   showFormPage(@ModelAttribute("perFrm") Person person) {
		//return LVN
		return "person_form";
	}
	
	@PostMapping("/person")
	public String  handleForm(Map<String,Object> map,@ModelAttribute("perFrm") Person per) {
		System.out.println("model class obj data"+per);
		return "register_success";
	}
	
	//reference data for radio buttons
	@ModelAttribute("genderList")
	public List<String> populateGenders(){
		System.out.println("PersonController.populateGenders()");
		List<String> genderList=List.of("female","male");  //java 9 feature.
		return genderList;
	}
	
	//reference data for checkboxes
	@ModelAttribute("hobiesList")
	public List<String> populateHobies(){
		System.out.println("PersonController.populateHobies()");
		List<String> hobiesList=List.of("reading","roaming","playing","workouts","sleeping");  //java 9 feature.
		return hobiesList;
	}
	
	//reference data for select box
	@ModelAttribute("qlfyList")
	public List<String> populateQualifications(){
		System.out.println("PersonController.populateQualifications()");
		List<String> qlfyList=List.of("BE","MCA","BCA","M.Tech","M.sc");  //java 9 feature.
		return qlfyList;
	}

	//reference data for ListBox
	@ModelAttribute("colorsList")
	public List<String> populateColors(){
		System.out.println("PersonController.populateColors()");
		List<String> colorsList=List.of("red","white","green","yellow","orange");  //java 9 feature.
		return colorsList;
	}

	/*	@InitBinder
		public   void   myInitBinder(ServletRequestDataBinder binder) {
			System.out.println("PersonController.myInitBinder()");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		}*/
	

}//class
