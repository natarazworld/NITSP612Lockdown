package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.JtaTransactionAnnotationParser;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {
	
	@Bean("dTxService")
	public  UserTransactionImp  createDTxService() throws Exception{
		UserTransactionImp  txService=null;
		txService=new UserTransactionImp();
		txService.setTransactionTimeout(90);
		return txService;
	}
	
	@Bean("dTxMgmr")
	public  UserTransactionManager  createDTxMgmr()throws Exception{
		UserTransactionManager manager=null;
		manager=new UserTransactionManager();
		manager.setForceShutdown(true);
		return manager;
	}
	
	@Bean(name="jtaTxMgmr")
	public  JtaTransactionManager  createJtaTxMgmr() throws Exception{
		JtaTransactionManager manager=null;
		manager=new JtaTransactionManager();
		manager.setUserTransaction(createDTxService());
		manager.setTransactionManager(createDTxMgmr());
		return manager;
		
	}

}
