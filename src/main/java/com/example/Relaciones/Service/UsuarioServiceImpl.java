package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Usuario;
import com.example.Relaciones.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
// 1
    @Override
    public Optional<Usuario> getUsuarioByPerfilDireccion(String direccion) {
        return usuarioRepository.findByPerfilDireccion(direccion);
    }
// 2
    @Override
    public List<Usuario> getUsuariosByPerfilDireccion(String direccion) {
        return usuarioRepository.findAllByPerfilDireccion(direccion);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
// 3
    @Override
    @Transactional
    public void updateUsuarioNombre(Long id, String nombre) {
        usuarioRepository.updateUsuarioNombre(id, nombre);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> getUsuariosConPerfil() {
        return usuarioRepository.findUsuariosConPerfil();
    }
}
