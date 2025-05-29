package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ANIMAL")
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANIMAL")
    private int id;

    @NotBlank(message = "A espécie do animal é obrigatória.")
    @Size(max = 100, message = "A espécie deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String especie;

    @NotBlank(message = "O grupo do animal é obrigatório.")
    @Size(max = 50, message = "O grupo do animal deve ter no máximo 50 caracteres.")
    @Column(name = "grupo_animal", nullable = false, length = 50)
    private String grupoAnimal; // Ex: "mamífero", "ave", "réptil"

    @NotBlank(message = "O porte do animal é obrigatório.")
    @Size(max = 20, message = "O porte deve ter no máximo 20 caracteres.")
    @Column(nullable = false, length = 20)
    private String porte;

    @Size(max = 20, message = "O sexo deve ter no máximo 20 caracteres.")
    @Column(length = 20)
    private String sexo;

    @Size(max = 50, message = "A cor predominante deve ter no máximo 50 caracteres.")
    @Column(name = "cor_predominante", length = 50)
    private String corPredominante;

    @NotBlank(message = "O nível de gravidade é obrigatório.")
    @Size(max = 20, message = "A gravidade deve ter no máximo 20 caracteres.")
    @Column(nullable = false, length = 20)
    private String gravidade;

    @Size(max = 255, message = "A URL da foto deve ter no máximo 255 caracteres.")
    @Column(name = "foto_url", length = 255)
    private String fotoUrl;

}
