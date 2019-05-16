package br.com.gerenciadordelogins.gerenciadordeloginseusuarios;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Endereco;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
                "123456",
                endereco1,
                "99169117",
                "ADMIN");

        User usuario2 = new User("Patricia",
                "patinunessaad@gmail.com",
                "teste",
                endereco1,
                "99999999",
                "USER");

        User usuario3 = new User("Amabile",
                "amabile.amavel@gmail.com",
                "amavel",
                endereco2,
                "888888888",
                "USER");

        User usuario4 = new User("Jean",
                "jean@gmail.com",
                "141295S@ad",
                endereco2,
                "6546432543",
                "USER");

        User usuario5 = new User("Vitor",
                "vifi13l@gmail.com",
                "1412",
                endereco2,
                "23135454",
                "USER");

        User usuario6 = new User("Filipi",
                "vifi13@gmail.com",
                "95S@ad",
                endereco2,
                "45687456",
                "USER");

        User usuario7 = new User("Beatriz",
                "bea.saad@gmail.com",
                "051011",
                endereco2,
                "5465748976",
                "USER");

        this.userRepo.deleteAll();

        this.userRepo.save(usuario1);
        this.userRepo.save(usuario2);
        this.userRepo.save(usuario3);
        this.userRepo.save(usuario4);
        this.userRepo.save(usuario5);
        this.userRepo.save(usuario6);
        this.userRepo.save(usuario7);

    }
}