package br.com.dh.desafiovespertino.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email, senha, habilitado from funcionario "+ 
				"where email = ?")
		.authoritiesByUsernameQuery("select email, autoridade from autorizacao "+
				"where email = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/funcionario").hasAnyRole("GERENTE")
		.antMatchers("/cliente").hasAnyRole("GERENTE","FUNCIONARIO")
		.antMatchers(HttpMethod.GET,"/funcionario").hasRole("FUNCIONARIO")
		.antMatchers("/funcionario").hasAnyRole("GERENTE")
		.antMatchers(HttpMethod.GET,"/funcionario").hasRole("FUNCIONARIO")
		.antMatchers("/pedido").hasAnyRole("GERENTE","FUNCIONARIO")
		.antMatchers(HttpMethod.GET,"/pedido").hasRole("CLIENTE")
		.antMatchers("/").permitAll()
		.and().httpBasic();;
		
	}
		

}
