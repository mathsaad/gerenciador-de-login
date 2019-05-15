package br.com.gerenciadordelogins.gerenciadordeloginseusuarios;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Endereco;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.Perfil;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.repository.UserRepository;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.UserService;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.impl.UserServiceImpl;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions.PerfilIncorretoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
    public class UserServiceImplTest {

        @Mock
        private UserRepository userRepository;

        private UserService userService;

        private User user;
        private Endereco endereco;

        private String ID = "IDTESTEUSER";
        private String NAME = "Administrador";
        private String EMAIL = "administracao@admins.com.br";
        private String CEP = "88117600";
        private String ENDERECO = "Rua Capitão Pedro Leite";
        private String COMPLEMENTO = "apto 105 bloco B";
        private String TELEFONE = "999169117";
        private String SENHA = "1234gerenciador";


    @Before
    public void setUp(){
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);

        endereco = new Endereco(CEP,ENDERECO,COMPLEMENTO);

        user = new User();
        user.setId(ID);
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setSenha(SENHA);
        user.setendereco(endereco);
        user.setTelefone(TELEFONE);
        user.setPerfil(Perfil.ADMIN);

        when(userRepository.findById(ID)).thenReturn(Optional.empty());
    }

    @Test
    public void verifica_se_o_save_é_chamado() throws PerfilIncorretoException{
        userService.saveUser(user);
        verify(userRepository).save(user);
    }

    @Test
    public void verifica_se_findAll_é_chamado(){
        userService.findAllUser();
        verify(userRepository).findAll();
    }

    @Test
    public void verifica_se_editar_e_chamado(){
        userService.editUser(user);
        verify(userRepository).save(user);
    }

    @Test
    public void verificar_se_delete_e_chamado() {
        when(userService.findById(ID)).thenReturn(Optional.of(user));
        userService.deleteUser(ID);
        verify(userRepository).delete(user);
    }

    @Test
    public void verifica_se_busca_por_id(){
        when(userService.findById(ID)).thenReturn(Optional.of(user));
        userService.findById(ID);
        verify(userRepository).findById(ID);
    }

    @Test(expected = PerfilIncorretoException.class)
    public void nao_deve_cadastrar_usuario_com_perfil_diferente_de_admin_ou_user() throws PerfilIncorretoException {
        when(userService.findById(ID)).thenReturn(Optional.of(user));
        user.setPerfil(Perfil.TEST);
        userService.saveUser(user);
    }

}
