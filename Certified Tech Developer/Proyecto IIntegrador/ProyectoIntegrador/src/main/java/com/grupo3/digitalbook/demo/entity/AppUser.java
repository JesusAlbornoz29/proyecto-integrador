package com.grupo3.digitalbook.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "USUARIOS") // Establecemos el nombre de la tabla en la BD
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "appUser_sequence", sequenceName = "appUser_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUser_sequence")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + appUserRole.name()); // es una clase que nos ayuda a manejar los roles de usuarios
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
