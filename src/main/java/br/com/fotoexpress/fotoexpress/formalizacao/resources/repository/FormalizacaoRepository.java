package br.com.fotoexpress.fotoexpress.formalizacao.resources.repository;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.entity.Formalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormalizacaoRepository extends JpaRepository<Formalizacao, UUID> {
}
