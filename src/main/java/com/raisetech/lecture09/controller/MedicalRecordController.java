package com.raisetech.lecture09.controller;

import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.mapper.MedicalRecordMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MedicalRecordController {
	private final MedicalRecordMapper medicalRecordMapper;
	public MedicalRecordController(MedicalRecordMapper medicalRecordMapper) {
		this.medicalRecordMapper = medicalRecordMapper;
	}
	@GetMapping("/medicalRecord")
	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecordMapper.findAll();
	}
	@GetMapping("/patients")
	public List<String> getPatients(@RequestParam(value="disease") String disease) {
		List<DiseaseResponse> diseaseResponses = new ArrayList<>(medicalRecordMapper.findByDisease(disease));
		return diseaseResponses.stream().map(DiseaseResponse::name).collect(Collectors.toList());
	}
}
