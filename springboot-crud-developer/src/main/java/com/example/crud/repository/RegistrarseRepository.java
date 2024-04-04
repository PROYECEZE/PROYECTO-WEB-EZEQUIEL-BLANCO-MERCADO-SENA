package com.example.crud.repository;

import com.example.crud.model.Registrarse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrarseRepository extends JpaRepository<Registrarse, Long> {
    Registrarse findByUsuario(String usuario);
}


