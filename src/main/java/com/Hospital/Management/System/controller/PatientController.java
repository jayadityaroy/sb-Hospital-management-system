package com.Hospital.Management.System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping()
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	@GetMapping()
	public List<Patient> getAllPatient(){
		return patientRepository.findAll();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient with Id "+id+" not found"));
		patientRepository.delete(patient);
		Map<String,Boolean>response = new HashMap<String,Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient p) throws AttributeNotFoundException{
		Patient temp = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient with Id "+id+" not found"));
		temp.setAge(p.getAge());
		temp.setBlood(p.getBlood());
		temp.setDosage(p.getDosage());
		temp.setFees(p.getFees());
		temp.setName(p.getName());
		temp.setPrescription(p.getPrescription());
		temp.setUrgency(p.getUrgency());
		
		return ResponseEntity.ok(patientRepository.save(temp));
	}
	@GetMapping("{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException {
		Patient p = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient with Id "+id+" not found"));
		return ResponseEntity.ok(p);
	}
}
