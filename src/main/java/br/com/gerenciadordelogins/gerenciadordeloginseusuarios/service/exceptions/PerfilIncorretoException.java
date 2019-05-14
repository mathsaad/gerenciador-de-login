package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

public class PerfilIncorretoException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;
    private static ErrorResponse errorResponse = new ErrorResponse(
            Response.Status.BAD_REQUEST.getStatusCode(),
            "usuario.perfil.incorreto",
            "Os perfils válidos são: ADMIN e USER");

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        PerfilIncorretoException.errorResponse = errorResponse;
    }

    public PerfilIncorretoException() {
        this(errorResponse);
    }

    public PerfilIncorretoException(ErrorResponse error) {
        Response.status(error.getStatus()).type(MediaType.APPLICATION_JSON).entity(error.getMensagem() + " " + error.getCodigo()).build();
    }
}