package com.example.demo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
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
@JsonView(AdminUserInfo.class)
public class AdminUserInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;
	
	@Column
	private String userName; 
	
	@Column
	private String authorityCode;
	
	public AdminUserInfo(String userName, String authorityCode) {
		this.userName = userName;
		this.authorityCode = authorityCode;
	}
	
}
