package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions.PerfilIncorretoException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User usuario) throws PerfilIncorretoException;

    User editUser(User usuario);

    ResponseEntity deleteUser(String id);

    Optional<User> findById(String id);

    List<User> findAllUser();
}
