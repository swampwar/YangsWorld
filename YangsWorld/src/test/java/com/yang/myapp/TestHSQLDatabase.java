package com.yang.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/config-context.xml")
public class TestHSQLDatabase {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void test() {
		System.out.println("test() start");
		
		
		System.out.println("test() end");
	}
}