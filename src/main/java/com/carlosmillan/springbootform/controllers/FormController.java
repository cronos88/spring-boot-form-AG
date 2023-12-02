package com.carlosmillan.springbootform.controllers;

import com.carlosmillan.springbootform.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario Usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Model model,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email) {

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);

        model.addAttribute("titulo", "Resultado Form");
        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
