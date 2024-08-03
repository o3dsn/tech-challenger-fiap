package br.com.fotoexpress.fotoexpress.formalizacao.resources.controller;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.dto.FormalizacaoDTO;
import br.com.fotoexpress.fotoexpress.formalizacao.resources.service.FormalizacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/formalizacao")
public class FormalizacaoController {
    @Autowired
    private FormalizacaoService formalizacaoService;

    @GetMapping
    public String get() {
        return "OK podemos comecar as formalizacoes 2";
    }

    @PostMapping("/{id}")
    @Operation(summary = "Cria uma nova formalização para o pedido", description = "Cria nova formalização para o pedido",
            responses = @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(schema = @Schema(implementation = String.class))}))
    public ResponseEntity<FormalizacaoDTO> save(@PathVariable UUID id, @RequestBody FormalizacaoDTO formalizacaoDTO) {
        formalizacaoDTO = formalizacaoService.save(id, formalizacaoDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(formalizacaoDTO);
    }
}
