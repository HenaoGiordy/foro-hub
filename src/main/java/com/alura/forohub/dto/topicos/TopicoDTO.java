package com.alura.forohub.dto.topicos;

import com.alura.forohub.dto.autor.AutorDTO;
import com.alura.forohub.dto.curso.CursoDTO;

public record TopicoDTO(String titulo, String mensaje, AutorDTO autor, CursoDTO curso) {
}
