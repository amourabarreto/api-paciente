package com.welfare.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_SEXOS")
public class SexoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,length = 300)
    private String sexo;
    @Column(nullable = false,length = 3)
    private String sigla;
    @Column(nullable = false,length = 5)
    private String codSus;
}
