package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CENTRO")
@Getter
@Setter
public class CentroAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CENTRO")
    private int id;

    @NotBlank(message = "O nome do centro é obrigatório.")
    @Size(max = 100, message = "O nome do centro deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O tipo de atendimento é obrigatório.")
    @Size(max = 100, message = "O tipo de atendimento deve ter no máximo 100 caracteres.")
    @Column(name = "tipo_atendimento", nullable = false, length = 100)
    private String tipoAtendimento; // Ex: aves, mamíferos, répteis...

    @NotNull(message = "A capacidade total é obrigatória.")
    @Min(value = 1, message = "A capacidade total deve ser pelo menos 1.")
    @Column(name = "capacidade_total", nullable = false)
    private Integer capacidadeTotal;

    @NotNull(message = "A capacidade atual é obrigatória.")
    @Min(value = 0, message = "A capacidade atual não pode ser negativa.")
    @Column(name = "capacidade_atual", nullable = false)
    private Integer capacidadeAtual;

    @NotBlank(message = "O nível de estrutura é obrigatório.")
    @Size(max = 50, message = "O nível de estrutura deve ter no máximo 50 caracteres.")
    @Column(name = "nivel_estrutura", nullable = false, length = 50)
    private String nivelEstrutura;

    @NotBlank(message = "O endereço é obrigatório.")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String endereco;

    @Column
    private Double latitude;

    @Column
    private Double longitude;
}
