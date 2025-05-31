package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESGATE")
@Getter
@Setter
public class Resgate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESGATE")
    private int id;

    @NotNull(message = "A data e hora do resgate são obrigatórias.")
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @NotBlank(message = "O status do resgate é obrigatório.")
    @Size(max = 30, message = "O status deve ter no máximo 30 caracteres.")
    @Column(name = "status_atual", nullable = false, length = 30)
    private String statusAtual;

    @Size(max = 500, message = "As observações devem ter no máximo 500 caracteres.")
    @Column(length = 500)
    private String observacoes;

    @NotNull(message = "O animal do resgate é obrigatório.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @NotNull(message = "O responsável pelo resgate é obrigatório.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;
}
