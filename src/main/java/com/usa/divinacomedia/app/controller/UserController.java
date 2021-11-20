package com.usa.divinacomedia.app.controller;


import com.usa.divinacomedia.app.model.User;
import com.usa.divinacomedia.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")//habilita acceso desde cualquier ordenador
public class UserController {
    @Autowired //inyectar instancias
    private UserService service;

    @GetMapping("/all") //GET
    public List<User> getUsers(){
        return service.getAll();
    }

    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
