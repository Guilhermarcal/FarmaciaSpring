package com.cotemig.springBoot.form;

import com.cotemig.springBoot.entity.Account;
 
public class FuncionarioForm {
	
    private String user_name;
    private String encrytedPassword;
    private boolean active;
    private String userRole;
 
    public FuncionarioForm() {
    	
    }
 
    public FuncionarioForm(Account funcionario) {
        this.user_name = funcionario.getUserName();
        this.encrytedPassword = funcionario.getEncrytedPassword();
        this.active = funcionario.isActive();
        this.userRole = funcionario.getUserRole();
    }

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
 
}
