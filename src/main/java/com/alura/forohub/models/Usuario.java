package com.alura.forohub.models;

import com.alura.forohub.dto.autor.AutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String correoElectronico;
    private String contrasenia;

    @OneToOne
    private Perfil perfil;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    public Usuario(AutorDTO autor) {
        this.nombre = autor.nombre();
        this.correoElectronico = autor.correoElectronico();
    }
}
