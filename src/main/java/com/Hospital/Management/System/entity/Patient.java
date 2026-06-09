package com.Hospital.Management.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="blood_group")
	private String blood;
	
	@Column(name="prescription")
	private String prescription;
	
	@Column(name="dosage")
	private String dosage;
	
	@Column(name="urgency")
	private String urgency;
	
	@Column(name="fees", columnDefinition = "double default 500.00")
	private double fees;
//	public String getName() {
//	    return name;
//	}   
}
