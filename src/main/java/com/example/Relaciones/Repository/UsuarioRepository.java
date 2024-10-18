package com.example.Relaciones.Repository;

import com.example.Relaciones.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Obtener usuario por dirección del perfil
    @Query("SELECT u FROM Usuario u WHERE u.perfil.direccion = :direccion")
    Optional<Usuario> findByPerfilDireccion(@Param("direccion") String direccion);

    // Obtener todos los usuarios por dirección del perfil
    @Query("SELECT u FROM Usuario u WHERE u.perfil.direccion = :direccion")
    List<Usuario> findAllByPerfilDireccion(@Param("direccion") String direccion);


    // Actualizar nombre del usuario por ID
    @Modifying
    @Query("UPDATE Usuario u SET u.nombre = :nombre WHERE u.id = :id")
    void updateUsuarioNombre(@Param("id") Long id, @Param("nombre") String nombre);


    @Query("SELECT u FROM Usuario u INNER JOIN u.perfil p")
    List<Usuario> findUsuariosConPerfil();
}
