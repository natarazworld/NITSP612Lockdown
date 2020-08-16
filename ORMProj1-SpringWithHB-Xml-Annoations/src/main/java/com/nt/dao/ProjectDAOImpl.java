package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project;

@Repository("projDAO")
public class ProjectDAOImpl implements ProjectDAO {
	 @Autowired
	 private HibernateTemplate   ht;

	@Override
	public Integer insert(Project entity) {
	      Integer idVal=0;
	      //use HiberanteTemplate
		 idVal=(Integer) ht.save(entity);
		return idVal;
	}

}
