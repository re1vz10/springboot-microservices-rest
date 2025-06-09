package com.example.practice.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Admission {
	
	private Long id;
	private Date admissionDate;
	private Date dischargeDate;
	private String diagnosis;
	private Long attendingDoctorId;

}
