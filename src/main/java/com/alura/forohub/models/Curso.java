package com.alura.forohub.models;

import com.alura.forohub.dto.curso.CursoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(CursoDTO cuso){
        this.nombre = cuso.nombre();
        this.categoria = cuso.categoria();
    }
}
