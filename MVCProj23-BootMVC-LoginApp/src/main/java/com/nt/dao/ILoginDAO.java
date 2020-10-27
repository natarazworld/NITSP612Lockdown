package com.nt.dao;

import com.nt.bo.UserBO;

public interface ILoginDAO {
     public  String authenticate(UserBO  bo);
}
