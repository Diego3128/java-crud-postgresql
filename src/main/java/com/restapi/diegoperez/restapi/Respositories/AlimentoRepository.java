package com.restapi.diegoperez.restapi.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.diegoperez.restapi.Entities.Alimento;

//extiende JpaRepository<Alimento, Long>. Hereda todas las operaciones CRUD y operaciones comunes de consulta que proporciona JpaRepository.
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}

