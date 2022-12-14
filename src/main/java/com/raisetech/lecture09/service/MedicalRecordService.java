package com.raisetech.lecture09.service;

import com.raisetech.lecture09.controller.DiseaseResponse;
import com.raisetech.lecture09.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
	List<MedicalRecord> findAll();
	List<DiseaseResponse> byDisease();
}
