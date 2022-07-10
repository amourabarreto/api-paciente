package com.welfare.services.impl;

import com.welfare.models.PacienteModel;
import com.welfare.repositories.PacienteRepository;
import com.welfare.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public PacienteModel save(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    @Override
    public void delete(PacienteModel pacienteModel) {
        pacienteRepository.delete(pacienteModel);
    }

    @Override
    public Optional<PacienteModel> findById(UUID id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<PacienteModel> findAll() {
        return pacienteRepository.findAll();
    }
}
