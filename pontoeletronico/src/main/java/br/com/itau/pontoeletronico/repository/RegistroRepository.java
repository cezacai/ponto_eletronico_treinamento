package br.com.itau.pontoeletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.itau.pontoeletronico.model.RegistroPonto;

public interface RegistroRepository extends JpaRepository<RegistroPonto, Long> {

	@Query(value = "SELECT * FROM TB_REGISTRO WHERE ID_USUARIO = :id", nativeQuery = true)
	List<RegistroPonto> consultarRegistro(@Param("id") Long id);

}
