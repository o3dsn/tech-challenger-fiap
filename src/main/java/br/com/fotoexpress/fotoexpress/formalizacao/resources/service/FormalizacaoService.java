package br.com.fotoexpress.fotoexpress.formalizacao.resources.service;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.entity.Formalizacao;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.dto.FormalizacaoDTO;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.dto.FormalizacaoRequestDTO;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.repository.FormalizacaoRepository;
import com.docusign.esign.client.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class FormalizacaoService {
    @Autowired
    private FormalizacaoRepository formalizacaoRepository;

    @Autowired
    private DocuSignService docuSignService;

    @Autowired
    private ContratoPDFService contratoPDFService;

    public FormalizacaoDTO save(FormalizacaoRequestDTO formalizacaoRequestDTO) throws IOException, ApiException {
        // verificar se o produtoId existe
        Formalizacao formalizacao = new Formalizacao();

        byte[] contrato = contratoPDFService.get();

        String resul = docuSignService.sendEnvelope("edson_a@outlook.com", "edson", contrato);
        System.out.println(resul);

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
