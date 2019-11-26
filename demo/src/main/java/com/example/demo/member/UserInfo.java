package com.example.demo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView(UserInfo.class)
@Builder
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;
	
	@Column
	private String userName; 
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String phoneNumber;
	
	public UserInfo(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	public UserInfo(String username, String password,String name, String phoneNumber) {
		this.userName = username;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

}
