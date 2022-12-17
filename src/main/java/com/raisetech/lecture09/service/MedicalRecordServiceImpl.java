package com.raisetech.lecture09.service;

import com.raisetech.lecture09.controller.DiseaseResponse;
import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.mapper.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements com.raisetech.lecture09.service.MedicalRecordService {
	private final MedicalRecordService medicalRecordMapper;
	public MedicalRecordServiceImpl(MedicalRecordService medicalRecordMapper) {
		this.medicalRecordMapper = medicalRecordMapper;
	}
	@Override
	public List<MedicalRecord> findAll() {
		return medicalRecordMapper.findAll();
	}
	@Override
	public List<DiseaseResponse> findByDisease(String disease) {
		return this.medicalRecordMapper.findByDisease(disease);
	}
}
