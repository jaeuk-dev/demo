package com.example.demo.access.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonView;
import com.querydsl.core.annotations.QueryProjection;

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
@JsonView(Access.class)
public class Access {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;
	
	@Column
	private String ip;
	
	@Column
	private String sessionId;
	
	@Column
	private String requestUri;
	
	@Column
	private String user;
	
	private int cnt = 1;
	
	@Column
	@CreationTimestamp
	private LocalDateTime accessTime;
	
	@Column
	@CreationTimestamp
	private LocalDate accessDate;
	
	public Access(String ip, String sessionId, String requestUri, String user) {
		this.ip = ip;
		this.sessionId = sessionId;
		this.requestUri = requestUri;
		this.user = user;
	}

}
