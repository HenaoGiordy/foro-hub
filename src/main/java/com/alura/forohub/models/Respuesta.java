package com.alura.forohub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario usuario;

    private Integer solucion;

    private LocalDateTime fechaCreacion;
}
