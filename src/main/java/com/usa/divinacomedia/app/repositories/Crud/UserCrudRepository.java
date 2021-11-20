package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    /**
     * Encontrar por nombre
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);

    /**
     * Encontrar por nombre o email
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     * Encontrar por email
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);

    /**
     * Encontrar por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
