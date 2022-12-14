package com.raisetech.lecture09;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
	@Select("SELECT * FROM medicalRecords")
	List<MedicalRecord> findAll();

	@Select("SELECT name,disease FROM medicalRecords WHERE disease=#{disease}")
	List<Disease> findByDisease(String disease);
}
