package com.example.demo.entity;

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
@JsonView(DemoBoard.class)
public class DemoBoard {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idx;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	public DemoBoard(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

