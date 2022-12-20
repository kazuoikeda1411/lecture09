package com.raisetech.lecture09.controller;

import com.raisetech.lecture09.request.DiseaseRequest;
import com.raisetech.lecture09.responses.DiseaseResponse;
import com.raisetech.lecture09.responses.MedicalRecordResponse;
import com.raisetech.lecture09.service.MedicalRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MedicalRecordController {
	private final MedicalRecordService medicalRecordService;
	public MedicalRecordController(MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}
	@GetMapping("/medicalRecord")
	public List<MedicalRecordResponse> getMedicalRecords() {
		return medicalRecordService.findAll().stream().map(MedicalRecordResponse::new).toList();
	}
	@GetMapping("/patients")
	public List<String> getPatients(DiseaseRequest disease) {
		return medicalRecordService.findByDisease(disease).stream().map(DiseaseResponse::name).collect(Collectors.toList());
	}
}
