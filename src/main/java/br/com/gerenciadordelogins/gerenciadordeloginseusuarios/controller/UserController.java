package br.com.gerenciadordelogins.gerenciadordeloginseusuarios.controller;

import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.documents.User;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.UserService;
import br.com.gerenciadordelogins.gerenciadordeloginseusuarios.service.exceptions.PerfilIncorretoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<User> listAllUsers(@QueryParam("page") Optional<Integer> page, @QueryParam("size") Optional<Integer> size, @QueryParam("directionSort") String direction, @QueryParam("sortBy") Optional<String> sortBy){

        return userService.findAllUser(PageRequest.of(page.orElse(0), size.orElse(3), Sort.Direction.ASC, sortBy.orElse("name")));
    }

    @PostMapping
    public Response insertUser(@Valid @RequestBody User user) {
        try{
            return Response.ok().entity(userService.saveUser(user)).build();
        }catch (PerfilIncorretoException e){
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(e).build();
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
