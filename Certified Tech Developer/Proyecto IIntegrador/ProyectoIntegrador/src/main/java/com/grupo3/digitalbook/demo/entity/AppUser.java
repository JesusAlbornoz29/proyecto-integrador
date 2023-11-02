package com.grupo3.digitalbook.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Entity
@Getter
@Setter
@Table(name = "USUARIOS") // Establecemos el nombre de la tabla en la BD
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "appUser_sequence", sequenceName = "appUser_sequence", allocationSize = 1) // Generamos el id de forma automáticamente en la BD con un sequence generator de 1 en 1 (allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUser_sequence") // Generamos el id de forma automáticamente en la BD con un sequence generator de 1 en 1 (allocationSize = 1)
    private long id;

    private String name;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    public AppUser(){

    }

    public AppUser(String name, String username, String email, String password, AppUserRole appUserRole) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + appUserRole.name()); // es una clase que nos ayuda a manejar los roles de usuarios
        return Collections.singletonList(grantedAuthority);
    }

    // Métodos que nos obliga a implementar la interfaz UserDetails
    @Override
    public boolean isAccountNonExpired() { // Si la cuenta no ha expirado
        return true; // Devuelve true
    }

    @Override
    public boolean isAccountNonLocked() { // Si la cuenta no está bloqueada
        return true; // Devuelve true
    }

    @Override
    public boolean isCredentialsNonExpired() { // Si las credenciales no han expirado
        return true; // Devuelve true
    }

    @Override
    public boolean isEnabled() { // Si la cuenta está habilitada
        return true; // Devuelve true
    }
}
