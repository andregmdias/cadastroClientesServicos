package br.com.giannatech.apiclientes.br.com.gianntech.apiclientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty( message = "{campo.nome.obrigatorio}" )
    private String nome;

    @Column(nullable = false, length = 11)
    @NotBlank( message = "{campo.cpf.obrigatorio}" )
    @CPF( message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
