package com.nt.service;

public interface IBankService {
	public  float calcSimpleIntrestAmount(float pAmt,float rate,float time);
	public    float calcCompoundIntrestAmount(float pAmt,float rate,float time);
}
