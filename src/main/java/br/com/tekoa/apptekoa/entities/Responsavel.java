package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESPONSAVEL")
@Getter
@Setter
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESPONSAVEL")
    private int id;

    @NotBlank(message = "O nome do responsável é obrigatório.")
    @Size(max = 100, message = "O nome do responsável deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O tipo de responsável é obrigatório.")
    @Size(max = 30, message = "O tipo de responsável deve ter no máximo 30 caracteres.")
    @Column(nullable = false, length = 30)
    private String tipo; // Ex: brigadista, voluntário, fazendeiro...

    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres.")
    @Column(length = 20)
    private String telefone;

    @Email(message = "O e-mail informado não é válido.")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
    @Column(length = 100)
    private String email;

    @Size(max = 100, message = "O nome da organização deve ter no máximo 100 caracteres.")
    @Column(length = 100)
    private String organizacao; // ONG, prefeitura, etc.
}
