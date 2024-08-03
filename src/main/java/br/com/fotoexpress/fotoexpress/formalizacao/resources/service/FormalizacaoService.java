package br.com.fotoexpress.fotoexpress.formalizacao.resources.service;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.entity.Formalizacao;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.dto.FormalizacaoDTO;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.repository.FormalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FormalizacaoService {
    @Autowired
    private FormalizacaoRepository formalizacaoRepository;

    public FormalizacaoDTO save(UUID pedidoId, FormalizacaoDTO formalizacaoDTO) {
        // verificar se o produtoId existe
        Formalizacao formalizacao = new Formalizacao();
        return toFormalizacaoDTO(formalizacao);
    }

    private FormalizacaoDTO toFormalizacaoDTO(Formalizacao formalizacao) {
        return  new FormalizacaoDTO(
              formalizacao.getId(),
                formalizacao.getPedidoId(),
                formalizacao.getDataFormalizacao(),
                formalizacao.getContrato(),
                formalizacao.getStatusFormalizacao()
        );
    }

    private Formalizacao toFormalizacao(FormalizacaoDTO formalizacaoDTO) {
        return  new Formalizacao(
               formalizacaoDTO.id(),
                formalizacaoDTO.pedidoId(),
                formalizacaoDTO.dataFormalizacao(),
                formalizacaoDTO.contrato(),
                formalizacaoDTO.statusFormalizacao()
        );
    }
}
