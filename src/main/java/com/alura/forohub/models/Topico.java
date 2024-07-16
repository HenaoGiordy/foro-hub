package com.alura.forohub.models;

import com.alura.forohub.dto.autor.AutorDTO;
import com.alura.forohub.dto.curso.CursoDTO;
import com.alura.forohub.dto.topicos.TopicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name="autor")
    private Usuario autor;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    public Topico(TopicoDTO dto) {
        this.titulo = dto.titulo();
        this.mensaje = dto.mensaje();
        this.autor = new Usuario(dto.autor());
        this.curso = new Curso(dto.curso());
        this.fechaCreacion = LocalDateTime.now();
    }
}
