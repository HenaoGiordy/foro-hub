package com.alura.forohub.services;

import com.alura.forohub.dto.autor.AutorDTO;
import com.alura.forohub.dto.curso.CursoDTO;
import com.alura.forohub.dto.topicos.TopicoDTO;
import com.alura.forohub.models.Topico;

import java.util.List;

public interface ServiceI {

    Topico guardarTopico(TopicoDTO topicoDTO);
    List<Topico> listarTopicos();
    Topico buscarTopico(Long id);
    Topico updateTopico(Long id ,TopicoDTO topico);
    void borrarTopico(Long id);
}
