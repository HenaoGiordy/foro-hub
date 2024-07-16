package com.alura.forohub.services;

import com.alura.forohub.dto.autor.AutorDTO;
import com.alura.forohub.dto.curso.CursoDTO;
import com.alura.forohub.dto.topicos.TopicoDTO;
import com.alura.forohub.models.Topico;
import com.alura.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ServiceImpl implements  ServiceI{

    private TopicoRepository topicoRepository;

    @Override
    public Topico guardarTopico(TopicoDTO topicoDTO) {
        return topicoRepository.save(new Topico(topicoDTO));
    }

    @Override
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @Override
    public Topico buscarTopico(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    @Override
    public Topico updateTopico(Long id, TopicoDTO topico) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            Topico topic = new Topico(topico);
            return topicoRepository.save(topic);
        }
        throw new RuntimeException("No se encontro el topico");
    }

    @Override
    public void borrarTopico(Long id) {
        topicoRepository.deleteById(id);
    }

}
