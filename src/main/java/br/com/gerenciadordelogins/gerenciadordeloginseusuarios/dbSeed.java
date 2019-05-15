package br.com.gerenciadordelogins.gerenciadordeloginseusuarios;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Endereco;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Perfil.ADMIN;
import static br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Perfil.USER;

@Component
public class dbSeed implements CommandLineRunner {

    private UserRepository userRepo;

    public dbSeed(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Endereco endereco1 = new Endereco("88117600", "Rua Capitão Pedro Leite", "apto 105 bloco B");
        Endereco endereco2 = new Endereco("88048393", "Servidão Braulina Maria Arcenio", "7 Casa");
        User usuario1 = new User("Matheus",
                "saadrcaa@gmail.com",
                "141295S@ad",
                endereco1,
                "99169117",
                ADMIN);

        User usuario2 = new User("Patricia",
                "patinunessaad@gmail.com",
                "141295S@ad",
                endereco1,
                "99169117",
                USER);

        User usuario3 = new User("Amabile",
                "amabile.amavel@gmail.com",
                "141295S@ad",
                endereco2,
                "99169117",
                ADMIN);

        this.userRepo.deleteAll();

        this.userRepo.save(usuario1);
        this.userRepo.save(usuario2);
        this.userRepo.save(usuario3);

    }
}