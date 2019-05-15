package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Perfil Incorreto, são validos apenas perfís como ADMIN e USER")
public class PerfilIncorretoException extends RuntimeException{
}