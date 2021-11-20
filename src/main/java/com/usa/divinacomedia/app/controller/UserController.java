package com.usa.divinacomedia.app.controller;


import com.usa.divinacomedia.app.model.User;
import com.usa.divinacomedia.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jaime Alonso Castillo Marin
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")//habilita acceso desde cualquier ordenador
public class UserController {
    /**
     * Inyectar instancias
     */
    @Autowired //inyectar instancias
    private UserService service;

    /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<User> getUsers(){
        return service.getAll();
    }

    /**
     * Metodo POST
     * @param user
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    /**
     * Metodo GET entrada Email
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    /**
     * Metodo GET entrada Email y Password
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
