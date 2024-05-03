package com.example.demo.controller;

import com.example.demo.dto.PatientReqDTO;
import com.example.demo.dto.PatientResDTO;
import com.example.demo.entity.Patient;
import com.example.demo.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientResDTO>> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatientById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<PatientResDTO> savePatient(@RequestBody PatientReqDTO patientReqDTO){
        return new  ResponseEntity<>(patientService.savePatient(patientReqDTO),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientResDTO> updatePatientById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.updatePatientById,HttpStatus.OK);
    }

}
