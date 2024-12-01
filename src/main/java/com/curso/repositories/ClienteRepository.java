package com.curso.repositories;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {
    Optional<Cliente> findBynome(String nome);
}
