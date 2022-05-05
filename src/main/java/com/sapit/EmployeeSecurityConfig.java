package com.sapit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sapit.model.MyUserDeatilsService;

@EnableWebSecurity
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDeatilsService myUserDeatilsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(auth);
		auth.userDetailsService(myUserDeatilsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncodeer() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
