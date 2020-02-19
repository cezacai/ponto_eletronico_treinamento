package br.com.itau.pontoeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.itau.pontoeletronico.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
