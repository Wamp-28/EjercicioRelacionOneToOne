package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getUsuarioById(Long id);

    List<Usuario> getAllUsuarios();

    // 1
    Optional<Usuario> getUsuarioByPerfilDireccion(String direccion);

    // 2
    List<Usuario> getUsuariosByPerfilDireccion(String direccion);

    Usuario saveUsuario(Usuario usuario);
    // 3
    void updateUsuarioNombre(Long id, String nombre);

    void deleteUsuario(Long id);


    List<Usuario> getUsuariosConPerfil();
}
