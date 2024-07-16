package com.alura.forohub.controllers;

import com.alura.forohub.dto.topicos.TopicoDTO;
import com.alura.forohub.services.ServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@AllArgsConstructor
public class TopicosController {

    private ServiceI serviceI;

    @GetMapping
    public ResponseEntity<?> getTopicos() {
        return ResponseEntity.ok(serviceI.listarTopicos());
    }

    @PostMapping
    public ResponseEntity<?> addTopico(@RequestBody TopicoDTO topico) {
        return ResponseEntity.ok(serviceI.guardarTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTopico(@PathVariable Long id, @RequestBody TopicoDTO topico) {
        return ResponseEntity.ok(serviceI.updateTopico(id, topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopico(@PathVariable Long id) {
        serviceI.borrarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
