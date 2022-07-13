package com.welfare.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.welfare.dtos.PacienteDTO;
import com.welfare.models.PacienteModel;
import com.welfare.services.PacienteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@CrossOrigin(origins = "*",maxAge = 3600 )
@RequestMapping("/pacientes")
public class PacinenteController {

    @Autowired
    PacienteService pacienteService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADM-MACHINE-APP_CAD_PACIENTE')")
    @PostMapping("/anonimo")
    ResponseEntity<Object> savePacienteAnonimo(@RequestBody
                                               @Validated(PacienteDTO.PacienteView.AnonimoPost.class)
                                               @JsonView(PacienteDTO.PacienteView.AnonimoPost.class)
                                               PacienteDTO pacienteDTO){
        log.debug("POST saveCourse CourseDTO RECEIVED {} ", pacienteDTO.toString());
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDTO,pacienteModel);
        pacienteService.save(pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteModel);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADM-MACHINE-APP_CAD_PACIENTE')")
    @PostMapping
    ResponseEntity<Object> save(@RequestBody @Valid PacienteDTO pacienteDTO){
        log.debug("POST saveCourse CourseDTO RECEIVED {} ", pacienteDTO.toString());
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDTO,pacienteModel);
        pacienteService.save(pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteModel);
    }
}
