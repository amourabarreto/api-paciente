package com.welfare.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_ENDERECOS")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String endereco;
    @Column(nullable = false, length = 150)
    private String complemento;
    @Column(nullable = false, length = 150)
    private String bairro;
    @Column(nullable = false, length = 150)
    private String cidade;
    @Column(nullable = false,length = 9)
    private String cep;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private MunicipioModel municipio;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private PacienteModel paciente;
}
