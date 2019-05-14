package br.com.gerenciadordelogins.gerenciadordeloginseusuarios;

            import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Endereco;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository.UserRepository;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.IUserService;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.UserService;
import org.junit.Before;
            import org.junit.Test;
            import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

            import java.util.Optional;

            import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
    public class UserServiceTest {

        @Mock
        private UserRepository userRepository;

        private IUserService userService;

        private User user;

        private String ID = "IDTESTEUSER";
        private String ADMIN = "Administrador";
        private String EMAIL = "administracao@admins.com.br";
        private String CEP = "88117600";
        private String ENDERECO = "Rua Capitão Pedro Leite";
        private String COMPLEMENTO = "apto 105 bloco B";
        private String CEP1 = "88117600";
        private String ENDERECO1 = "Rua Capitão Pedro Leite";
        private String COMPLEMENTO1 = "apto 105 bloco B";
        private String TELEFONE = "999169117";
        private String PERFIL = "PERFIL DO COLABORADOR";
        private String SENHA = "1234gerenciador";


    @Before
    public void setUp(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);

        Endereco endereco = new Endereco(CEP,ENDERECO,COMPLEMENTO);

        user = new User();
        user.setId(ID);
        user.setName(ADMIN);
        user.setEmail(EMAIL);
        user.setSenha(SENHA);
        user.setendereco(endereco);
        user.setTelefone(TELEFONE);
        user.setPerfil(PERFIL);

        when(userRepository.findById(ID)).thenReturn(Optional.empty());
    }

    @Test
    public void verifica_se_o_save_é_chamado(){
        userService.saveUser(user);
        verify(userRepository).save(user);
    }

    @Test
    public void verifica_se_findAll_é_chamado(){
        userService.findAllUser();
        verify(userRepository).findAll();
    }

    @Test
    public void nao_deve_salvar_usuario_sem_nome(){
        user.setName(null);

    }

}
