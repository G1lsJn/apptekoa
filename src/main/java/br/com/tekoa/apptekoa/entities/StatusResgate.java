package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "STATUS_RESGATE")
@Getter
@Setter
public class StatusResgate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS")
    private int id;

    @NotNull(message = "O resgate relacionado é obrigatório.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "resgate_id", nullable = false)
    private Resgate resgate;

    @NotBlank(message = "A etapa do status é obrigatória.")
    @Column(nullable = false, length = 30)
    private String etapa; // Ex: Aguardando, Em deslocamento, etc.

    @NotNull(message = "A data e hora do status são obrigatórias.")
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Size(max = 100, message = "O campo 'responsável pela atualização' deve ter no máximo 100 caracteres.")
    @Column(name = "responsavel_atualizacao", length = 100)
    private String responsavelAtualizacao;

}
