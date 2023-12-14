package com.carlosmillan.springbootform.controllers;

import com.carlosmillan.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setIdentificador("123.456.789-K");
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        model.addAttribute("titulo", "Formulario Usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){
        model.addAttribute("titulo", "Resultado Form");

        if(result.hasErrors()) {
            return "form"; //retorna el formulario si hay error en el mismo
        }

        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
