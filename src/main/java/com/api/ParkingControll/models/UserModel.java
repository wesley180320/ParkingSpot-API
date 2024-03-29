package com.api.ParkingControll.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel implements UserDetails, Serializable {
    private static final long serialVersionUID = -2574966836113177299L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(unique = true)
    private String password;

    @Email
    @Column(nullable = false, unique = false)
    private String emailUser;

    public UserModel(){}

    public UserModel(String username, String password, String emailUser) {
        this.username = username;
        this.password = password;
        this.emailUser = emailUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return emailUser;
    }

    public void setEmail(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public String toString() {
        String texto = " Cadastro PARKING SPOT dados de login";

        texto += System.lineSeparator() + " USUARIO = " + username;
        texto += System.lineSeparator() + " SENHA = " + password;
        texto += System.lineSeparator() + " EMAIL = " + emailUser;

        return texto;
    }
}
