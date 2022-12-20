package com.raisetech.lecture09.service;

import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.request.DiseaseRequest;
import com.raisetech.lecture09.responses.DiseaseResponse;

import java.util.List;

public interface MedicalRecordService {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> findByDisease(DiseaseRequest disease);
}
