package com.codegym.dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String name;
    private Collection<? extends GrantedAuthority> roles;
    private int statusUs;

    public JwtResponse(Long id, String token,  String username, String name, Collection<? extends GrantedAuthority> roles, int statusUs) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.name = name;
        this.roles = roles;
        this.statusUs = statusUs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public int getStatusUs() {
        return statusUs;
    }

    public void setStatusUs(int statusUs) {
        this.statusUs = statusUs;
    }
}
