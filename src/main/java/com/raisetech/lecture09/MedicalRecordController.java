package com.raisetech.lecture09;

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
	@GetMapping("/names")
	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecordMapper.findAll();
	}
	@GetMapping("/patients")
	public List<String> patients(@RequestParam(value="disease") String patientDisease) {
		List<Disease> byDisease = new ArrayList<>(medicalRecordMapper.findByDisease(patientDisease));
		return byDisease.stream().map(Disease::name).collect(Collectors.toList());
	}
}
