package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Usuario;
import com.example.Relaciones.Repository.UsuarioRepository;
import com.example.Relaciones.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    // Obtener todos los usuarios
    @GetMapping("/todos")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // 1
    // Obtener usuario por dirección del perfil
    @GetMapping("/perfil/direccion/{direccion}")
    public Optional<Usuario> getUsuarioByPerfilDireccion(@PathVariable String direccion) {
        return usuarioService.getUsuarioByPerfilDireccion(direccion);
    }

    // 2
    // Obtener todos los usuarios por dirección del perfil
    @GetMapping("/perfil/direccion/all/{direccion}")
    public List<Usuario> getUsuariosByPerfilDireccion(@PathVariable String direccion) {
        return usuarioService.getUsuariosByPerfilDireccion(direccion);
    }

/*
    // Crear  un usuario
    @PostMapping("/guardar")
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }
  */
    // Permite personalizar tanto el cuerpo de la respuesta como el código de estado HTTP.
    // Crear un usuario
    @PostMapping("/guardar")
    public ResponseEntity<String> saveUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado con éxito. ID: " + savedUsuario.getId());
    }

    // 3
    // Actualizar nombre del usuario por ID
    @PutMapping("/{id}/actualizarNombre")
    public void updateUsuarioNombre(@PathVariable Long id, @RequestParam String nombre) {
        usuarioService.updateUsuarioNombre(id, nombre);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    // Obtener usuarios con perfil
    @GetMapping("/con-perfil")
    public ResponseEntity<List<Usuario>> getUsuariosConPerfil() {
        List<Usuario> usuarios = usuarioService.getUsuariosConPerfil();
        return ResponseEntity.ok(usuarios);
    }
}




