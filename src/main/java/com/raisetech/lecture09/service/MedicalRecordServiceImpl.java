package com.raisetech.lecture09.service;

import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.exeption.ResourceNotFoundException;
import com.raisetech.lecture09.mapper.MedicalRecordMapper;
import com.raisetech.lecture09.request.DiseaseRequest;
import com.raisetech.lecture09.responses.DiseaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements com.raisetech.lecture09.service.MedicalRecordService {
	private final MedicalRecordMapper medicalRecordMapper;
	public MedicalRecordServiceImpl(MedicalRecordMapper medicalRecordMapper) {
		this.medicalRecordMapper = medicalRecordMapper;
	}
	@Override
	public List<MedicalRecord> findAll() {
		return medicalRecordMapper.findAll();
	}
	@Override
	public List<DiseaseResponse> findByDisease(DiseaseRequest disease) {
		if (this.medicalRecordMapper.findByDisease(disease.getDisease()).isEmpty()) {
			throw new ResourceNotFoundException("resource not found");
		} else {
			return this.medicalRecordMapper.findByDisease(disease.getDisease());
		}
	}
}
