package com.welfare.services;

import com.welfare.models.PacienteModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteService {

     PacienteModel save(PacienteModel pacienteModel);
     void delete(PacienteModel pacienteModel);
     Optional<PacienteModel> findById(UUID id);
     List<PacienteModel> findAll();
}
