package com.raisetech.lecture09.mapper;

import com.raisetech.lecture09.entity.MedicalRecord;
import com.raisetech.lecture09.responses.DiseaseResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
	@Select("SELECT * FROM medicalRecords")
	List<MedicalRecord> findAll();

	@Select("SELECT name,disease FROM medicalRecords WHERE disease=#{disease}")
	List<DiseaseResponse> findByDisease(String disease);
}
