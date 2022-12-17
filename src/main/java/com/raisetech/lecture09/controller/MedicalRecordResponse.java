package com.raisetech.lecture09.controller;

import com.raisetech.lecture09.entity.MedicalRecord;

public class MedicalRecordResponse {
	private final int id;
	private final String name;
	private final String disease;

	public MedicalRecordResponse(MedicalRecord medicalRecord) {
		this.id = medicalRecord.id();
		this.name = medicalRecord.name();
		this.disease = medicalRecord.disease();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDisease() {
		return disease;
	}
}
