package com.welfare.controllers;

import com.welfare.dtos.PacienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600 )
@RequestMapping("/pacientes")
public class PacinenteController {

    @PreAuthorize("hasAnyAuthority('ROLE_ADM-MACHINE-APP_CAD_PACIENTE')")
    @PostMapping
    ResponseEntity<Object> save(@RequestBody @Valid PacienteDTO pacienteDTO){
        return null;
    }
}
