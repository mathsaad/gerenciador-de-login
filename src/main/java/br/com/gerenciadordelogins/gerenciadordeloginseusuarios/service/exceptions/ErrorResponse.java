package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions;

public class ErrorResponse {

    private int status;
    private String codigo;
    private String mensagem;

    public ErrorResponse(int status, String statusDescription, String errorMessage) {
        this.status = status;
        this.codigo = statusDescription;
        this.mensagem = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}