package com.welfare.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_PACIENTES")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String cns;
    private String prontuario;
    @Column(length = 150)
    private String nome;
    @Column(length = 150)
    private String nomeSocial;
    private String apelido;
    @Column(length = 9,unique = true)
    private String cpf;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataNascimento;

    private String naturalidade;
    private String nomePai;
    private String nomeMae;

    @Column(length = 3)
    private String dddFixo;
    @Column(length = 10)
    private String telefoneFixo;
    @Column(length = 3)
    private String dddCelular;
    @Column(length = 10)
    private String telegoneCelular;

    @Column(nullable = false,unique = true)
    private String userName;

    private Boolean vreBacteria;

    @Column(length = 500)
    private String observacao;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<EnderecoModel> enderecos;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<RgModel> rgs;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfModel ufNaturalidadeModel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CorPeleModel corPeleModel;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SexoModel sexoModel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NacionalidadeModel nacionalidadeModel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PaisModel paisModel;

    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @Column(nullable = false,columnDefinition = "true")
    private boolean ativo;


}
