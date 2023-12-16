package com.carlosmillan.springbootform.models.domain;

import com.carlosmillan.springbootform.validators.IdentificadorRegex;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Usuario {

    private String identificador;
    @NotEmpty(message = "El campo Nombre es requerido")
    private String nombre;
    @NotEmpty(message = "El campo Apellido es requerido")
    private String apellido;
    @NotEmpty(message = "El campo username es requerido")
    @Size(min = 3, max = 8)
    private String username;
    //@NotEmpty
    private String password;
    private String email;
    @IdentificadorRegex
    private String phone;

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
