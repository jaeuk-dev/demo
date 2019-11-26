package com.example.demo.code.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
@JsonView(CommonCodeSub.class)
public class CommonCodeSub {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idx;
	
	@Column
	private String parentCodeNumber;
	
	@Column
	private String codeNumber;

	@Column
	private String codeName;
	
	@Column
	private String codeValue1;
	
	@Column
	private String codeValue2;
	
	@Column
	private String codeValue3;
	
	@Column
	private String codeBigo;
	
	//@MapsId
	//@ManyToOne
	//private CommonCode commonCode;
	
	public CommonCodeSub(String parentCodeNumber, String codeNumber, String codeName, String codeValue1, String codeValue2, String codeValue3, String codeBigo) {
		this.parentCodeNumber = parentCodeNumber;
		this.codeNumber = codeNumber;
		this.codeName = codeName;
		this.codeValue1 = codeValue1;
		this.codeValue2 = codeValue2;
		this.codeValue3 = codeValue3;
		this.codeBigo = codeBigo;
	}
}
