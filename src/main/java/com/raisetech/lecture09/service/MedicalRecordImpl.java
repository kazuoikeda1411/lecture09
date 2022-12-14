package com.raisetech.lecture09.service;

import com.raisetech.lecture09.controller.DiseaseResponse;
import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.mapper.MedicalRecordMapper;

import java.util.List;

public class MedicalRecordImpl implements MedicalRecordService {
	private final MedicalRecordMapper medicalRecordMapper;
	public MedicalRecordImpl(MedicalRecordMapper medicalRecordMapper) {
		this.medicalRecordMapper = medicalRecordMapper;
	}
	@Override
	public List<MedicalRecord> findAll() {
		return medicalRecordMapper.findAll();
	}
	@Override
	public List<DiseaseResponse> byDisease() {
		return null;
	}
}
