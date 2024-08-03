package br.com.fotoexpress.fotoexpress.formalizacao.resources.dto;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.enums.StatusFormalizacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record FormalizacaoDTO(
        UUID id,
        UUID pedidoId,
        LocalDateTime dataFormalizacao,
        byte[] contrato,
        StatusFormalizacao statusFormalizacao
) {
}
