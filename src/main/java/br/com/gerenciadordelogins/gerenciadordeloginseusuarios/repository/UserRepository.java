package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Override
    Page<User> findAll(Pageable pageable);
}
