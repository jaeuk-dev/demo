package com.example.demo.code.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

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
@JsonView(CommonCode.class)
public class CommonCode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;
	
	@Column
	private String codeNumber;

	@Column
	private String codeName;
	
	@Column
	private String codeValue;
	
	@Column
	private String codeBigo;
	
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = false)
	@JoinColumn(name = "parentCodeNumber")
	private Collection<CommonCodeSub> commonCodeSub;

	public CommonCode(String codeNumber, String codeName, String codeValue, String codeBigo) {
		this.codeNumber = codeNumber;
		this.codeName = codeName;
		this.codeValue = codeValue;
		this.codeBigo = codeBigo;
	}
}
