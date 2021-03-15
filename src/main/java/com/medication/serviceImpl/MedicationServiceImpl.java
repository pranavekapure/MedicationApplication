package com.medication.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.connection.pojo.Medicine;
import com.connection.pojo.Patient;
import com.connection.service.IMedicationService;
import com.medication.pojo.MedicineDto;

@EnableJpaRepositories(basePackages = { "com.connection.service" })
@Service
public class MedicationServiceImpl {

	@Autowired
	private IMedicationService medicationService;

	public MedicineDto getMedicationList() {
		MedicineDto medicineDto = new MedicineDto();
		List<Medicine> medicationList = medicationService.findAll();
		medicineDto.setListOfMedicine(medicationList);
		return medicineDto;
	}

	public Medicine saveAndUpdateMedicine(Medicine medicine) {
		Medicine savedMedicine = medicationService.save(medicine);
		return savedMedicine;
	}

	public MedicineDto getMedicineListForPatient(Integer patientId) {
		
		Map<Patient, List<Medicine>> MapOfListOfMedicine=getMapOfListOfMedicine();
		System.out.println(MapOfListOfMedicine);
		Patient patient=MapOfListOfMedicine.keySet().stream().filter(key->key.getPatientId().equals(patientId)).findFirst().get();
		/*.stream().filter(keyValue->keyValue.getKey().equals(patientId)).map(keyValue->keyValue.getKey()).findAny().get();*/
		List<Medicine> medicineList=MapOfListOfMedicine.get(patient);
		MedicineDto medicineDto = new MedicineDto();
		medicineDto.setListOfMedicine(medicineList);
		
		return medicineDto;
	}

	private Map<Patient, List<Medicine>> getMapOfListOfMedicine() {
		MedicineDto medicineDto = getMedicationList();
		return medicineDto.getListOfMedicine().stream().collect(Collectors.groupingBy(Medicine::getPatient));
	}

}
