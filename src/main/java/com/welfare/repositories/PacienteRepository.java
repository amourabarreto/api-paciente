package com.welfare.repositories;

import com.welfare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<PacienteModel, UUID>, JpaSpecificationExecutor<PacienteModel> {
}
