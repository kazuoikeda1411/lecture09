package com.raisetech.lecture09.controller;

import com.raisetech.lecture09.ResourceNotFoundException;
import com.raisetech.lecture09.mapper.MedicalRecordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	public List<String> getPatients(@RequestParam(value="disease") String disease) {
		if (medicalRecordService.findByDisease(disease).isEmpty()) {
			throw new ResourceNotFoundException("resource not found");
		} else {
			List<DiseaseResponse> diseaseResponses = new ArrayList<>(medicalRecordService.findByDisease(disease));
			return diseaseResponses.stream().map(DiseaseResponse::name).collect(Collectors.toList());
		}
	}
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNoResourceFound(
		ResourceNotFoundException e, HttpServletRequest request
	) {
		Map<String, String> body = Map.of("timestamp", ZonedDateTime.now().toString(), "status", String.valueOf(HttpStatus.NOT_FOUND.value()), "error", HttpStatus.NOT_FOUND.getReasonPhrase(), "message", e.getMessage(), "path", request.getRequestURI());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
