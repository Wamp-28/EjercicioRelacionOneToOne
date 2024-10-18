package com.example.Relaciones.Service;

import com.example.Relaciones.Model.Perfil;
import com.example.Relaciones.Repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil savePerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }


}