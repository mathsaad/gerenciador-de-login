package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.impl;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository.UserRepository;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.UserService;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions.PerfilIncorretoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User usuario) throws PerfilIncorretoException {
        if (usuario.getPerfil().equals("ADMIN")|| usuario.getPerfil().equals("USER")){
            return userRepository.save(usuario);
        }
        throw new PerfilIncorretoException();
    }

    @Override
    public User editUser(User usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public ResponseEntity deleteUser(String id) {
        Optional<User> OptionalUser = userRepository.findById(id);
        userRepository.delete(OptionalUser.get());
        return ResponseEntity.ok(OptionalUser);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
