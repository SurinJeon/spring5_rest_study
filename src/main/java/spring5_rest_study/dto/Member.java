package spring5_rest_study.dto;

import java.time.LocalDateTime;

import spring5_rest_study.exception.WrongIdPasswordException;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regdate;
	
	public Member() {
	}

	public Member(Long id) {
		this.id = id;
	}

	public Member(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Member(String email, String password, String name, LocalDateTime regdate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) { 
			throw new WrongIdPasswordException();
		}
		this.password = newPassword; 
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Member [email=%s, password=%s, name=%s]", email, password,
				name);
	}

}
