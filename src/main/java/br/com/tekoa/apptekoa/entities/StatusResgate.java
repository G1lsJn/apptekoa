package br.com.tekoa.apptekoa.entities;

import jakarta.persistence.*;
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

    // private Resgate resgate;
    private String etapa;
    private LocalDateTime dataHora;
    private String responsavelAtualizacao;


}
