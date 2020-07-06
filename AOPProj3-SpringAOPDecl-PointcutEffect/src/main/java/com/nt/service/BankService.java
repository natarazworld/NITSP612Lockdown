package com.nt.service;

public  class BankService {
	
	// ptr/100
	public  float calcSimpleIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcSimpleIntrestAmount() Target Method1 "+pAmt+" "+rate+"  "+time);
		return (pAmt*rate*time)/100.0f;
	}//method
	
	
	//p(1+(r/100)^n -p
	public    float calcCompoundIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcSimpleIntrestAmount() Target Method1 "+pAmt+" "+rate+"  "+time);
		return (float) ((pAmt*Math.pow((1+rate/100),time)))-pAmt;
	}//method

}//class
