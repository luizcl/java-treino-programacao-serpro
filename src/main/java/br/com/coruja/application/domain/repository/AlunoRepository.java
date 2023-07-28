package br.com.coruja.application.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coruja.application.domain.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{
}
