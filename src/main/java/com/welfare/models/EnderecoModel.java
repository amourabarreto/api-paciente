package com.welfare.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_ENDERECOS")
public class EnderecoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
