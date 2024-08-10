package br.com.fotoexpress.fotoexpress.formalizacao.resources.dto;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.enums.StatusFormalizacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record FormalizacaoDTO(
        Long id,
        Long pedidoId,
        String nomeCliente,
        String emailCliente,
        LocalDateTime dataFormalizacao,
        String contratoEnviadoId,
        StatusFormalizacao statusFormalizacao
) {
}
