package com.usa.divinacomedia.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Jaime Alonso Castillo Marin
 */

@Data //para generar los getters and setters
@NoArgsConstructor //paraa generar constructor vacio
@AllArgsConstructor //para generar constructor con todos sus parametros
@Entity
@Table(name = "user")
public class User implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para generar los numeros autoincremental
    private Integer id;

    /**
     * Email
     */
    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;

    /**
     * Password
     */
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;

    /**
     * Name
     */
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;
}
