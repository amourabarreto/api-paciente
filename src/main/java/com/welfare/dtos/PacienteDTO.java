package com.welfare.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import com.welfare.models.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class PacienteDTO {
    public interface PacienteView {
        public static interface AnonimoPost {
        }
    }
    private UUID id;


    private String cns;
    private String prontuario;
    @NotBlank(groups = PacienteView.AnonimoPost.class)
    @Size(min = 4, max = 50, groups = PacienteView.AnonimoPost.class)
    @JsonView(PacienteView.AnonimoPost.class)
    private String nome;
    private String nomeSocial;
    private String apelido;
    private String cpf;
    private String dataNascimento;
    private String naturalidade;
    private String nomePai;
    private String nomeMae;
    private String dddFixo;
    private String telefoneFixo;
    private String dddCelular;
    private String telegoneCelular;
    private String userName;
    private Boolean vreBacteria;
    private String observacao;

    private Set<EnderecoModel> enderecos;

    private Set<RgModel> rgs;

    private UfModel ufNaturalidadeModel;

    private CorPeleModel corPeleModel;


    private SexoModel sexoModel;


    private NacionalidadeModel nacionalidadeModel;

    private PaisModel paisModel;


}
