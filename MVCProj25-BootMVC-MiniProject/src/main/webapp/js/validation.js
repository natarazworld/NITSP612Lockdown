
function  validate(frm){
	alert("js");
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let flag=true;
	  
	//empty the error messages
	document.getElementById("enameId").innerHTML="";
	document.getElementById("jobId").innerHTML="";
	document.getElementById("salId").innerHTML="";
	
		  frm.vflag.value="yes";
		  alert(frm.vflag.value);
	
	if(ename==""){
		flag=false;
		document.getElementById("enameId").innerHTML="Employee name is mandatory(js)";
	}
	else if(ename.length<5 || ename.length>10){
		flag=false;
		document.getElementById("enameId").innerHTML="Employee name must have min of 5 chars and max of 10 chars (js)";
	}
	
	if(job==""){
		flag=false;
		document.getElementById("jobId").innerHTML="Employee job is mandatory(js)";
	}
	else if(job.length<5 || job.length>9){
		flag=false;
		document.getElementById("jobId").innerHTML="Employee job must have min of 5 chars and max of 9 chars (js)";
	}
	
	if(sal==""){
		flag=false;
		document.getElementById("salId").innerHTML="Employee sal is mandatory(js)";
	}
	else if(isNaN(sal)){
		flag=false;
		document.getElementById("salId").innerHTML="Employee sal is must be numeric vlaue(js)";
	}
	else if(sal<10000 || sal>100000){
		flag=false;
		document.getElementById("salId").innerHTML="Employee salary must be in the range between 10000 to 100000(js)";
		
	}
	
	return flag;
}