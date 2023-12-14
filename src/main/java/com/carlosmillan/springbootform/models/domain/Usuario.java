package com.carlosmillan.springbootform.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {

    private String identificador;
    @NotEmpty(message = "El nombre no puede ser vacío")
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty(message = "Debes de colocar un username")
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty(message = "Correo con formato incorrecto")
    @Email(message = "error mal correo")
    private String email;
    @NotEmpty
    @Pattern(regexp = "60[1-9]{1}-[0-9]{7}")
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
