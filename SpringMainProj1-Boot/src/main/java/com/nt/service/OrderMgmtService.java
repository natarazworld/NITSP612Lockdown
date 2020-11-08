package com.nt.service;

public interface OrderMgmtService {
    public String  purchase(String[] items, float[] prices,String customerEmail,String[] cc,String bcc[]);
}
