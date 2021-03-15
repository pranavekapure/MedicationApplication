package com.medication.pojo;

import java.util.List;

import com.connection.pojo.Medicine;

public class MedicineDto {

	private List<Medicine> listOfMedicine;

	public List<Medicine> getListOfMedicine() {
		return listOfMedicine;
	}

	public void setListOfMedicine(List<Medicine> listOfMedicine) {
		this.listOfMedicine = listOfMedicine;
	}

	public MedicineDto() {
		super();
	}

}
