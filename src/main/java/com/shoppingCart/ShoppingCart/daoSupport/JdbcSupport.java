package com.shoppingCart.ShoppingCart.daoSupport;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSupport {
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}  
	
}
