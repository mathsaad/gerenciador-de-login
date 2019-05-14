package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.controller;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.IUserService;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions.PerfilIncorretoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listAllUsers(){
        return userService.findAllUser();
    }

    @PostMapping
    public Response insertUser(@Valid @RequestBody User user) {
        try{
            return Response.ok().entity(userService.saveUser(user)).build();
        }catch (PerfilIncorretoException e){
            return Response.status(e.getErrorResponse().getStatus()).type(MediaType.APPLICATION_JSON).entity(e.getErrorResponse()).build();
        }
    }

    @PutMapping("/{id}")
    public User alterUser(@PathVariable("id") String id,@Valid @RequestBody User user){
        user.setId(id);
        return userService.editUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findUser(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        return userService.deleteUser(id);
    }

}
