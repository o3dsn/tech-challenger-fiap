package br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.entity;

import br.com.fotoexpress.fotoexpress.formalizacao.resources.domain.enums.StatusFormalizacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="for_formaliazao")
public class Formalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID pedidoId;
    private LocalDateTime dataFormalizacao;
    private byte[] contrato;
    private StatusFormalizacao statusFormalizacao;

    public Formalizacao() {}

    public Formalizacao(UUID id, UUID pedidoId, LocalDateTime dataFormalizacao, byte[] contrato, StatusFormalizacao statusFormalizacao) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.dataFormalizacao = dataFormalizacao;
        this.contrato = contrato;
        this.statusFormalizacao = statusFormalizacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDateTime getDataFormalizacao() {
        return dataFormalizacao;
    }

    public void setDataFormalizacao(LocalDateTime dataFormalizacao) {
        this.dataFormalizacao = dataFormalizacao;
    }

    public byte[] getContrato() {
        return contrato;
    }

    public void setContrato(byte[] contrato) {
        this.contrato = contrato;
    }

    public StatusFormalizacao getStatusFormalizacao() {
        return statusFormalizacao;
    }

    public void setStatusFormalizacao(StatusFormalizacao statusFormalizacao) {
        this.statusFormalizacao = statusFormalizacao;
    }

    public void formalizar() {
        this.statusFormalizacao = StatusFormalizacao.FORMALIZADO;
        this.dataFormalizacao = LocalDateTime.now();
    }

    public boolean assinarContrato() {
        if (this.statusFormalizacao == StatusFormalizacao.FORMALIZADO) {
            this.statusFormalizacao = StatusFormalizacao.ASSINADO;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formalizacao that = (Formalizacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Formalizacao{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", dataFormalizacao=" + dataFormalizacao +
                ", contrato=" + Arrays.toString(contrato) +
                ", statusFormalizacao=" + statusFormalizacao +
                '}';
    }
}
