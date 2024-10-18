package com.example.Relaciones.Controller;

import com.example.Relaciones.Model.Perfil;
import com.example.Relaciones.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    // Crear un nuevo perfil
    @PostMapping("/guardar")
    public ResponseEntity<String> savePerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.savePerfil(perfil);
        return ResponseEntity.ok("Perfil registrado con éxito. ID: " + nuevoPerfil.getId());
    }
}
