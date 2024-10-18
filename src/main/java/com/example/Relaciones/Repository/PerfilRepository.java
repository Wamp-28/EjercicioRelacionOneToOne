package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Perfil;
import com.example.Relaciones.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {


}
