package com.cotemig.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
import com.cotemig.springBoot.service.UsuarioServiceImpl;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
 
	/**
	 * REALIZA AS CONFIGURAÇÕES DE ACESSO
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 		
		http.authorizeRequests()
		.antMatchers("/cliente/insert", "/funcionario/insert").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CADASTROUSUARIO')")
		.antMatchers("/cliente/delete", "/funcionario/delete", "/produto/delete").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/index", "/css/**", "/fonts/**", "/images/**", "/js/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/").defaultSuccessUrl("/home",true).permitAll()
        .and()
        .logout().logoutSuccessUrl("/").logoutUrl("/logout").permitAll();

	}
 
 
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        /*INFORMA A CRIPTOGRAFIA QUE DEVE SER USADA PARA A SENHA DO USUÁRIO*/				
		auth.userDetailsService(usuarioServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
 
    }
	
}