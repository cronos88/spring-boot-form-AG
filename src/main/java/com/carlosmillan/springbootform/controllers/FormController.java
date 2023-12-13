package com.carlosmillan.springbootform.controllers;

import com.carlosmillan.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
    public String procesar(@Valid /*@ModelAttribute("user")*/ Usuario usuario, BindingResult result, Model model){
//                           @RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String email) {

//        Usuario usuario = new Usuario();
//        usuario.setUsername(username);
//        usuario.setPassword(password);
//        usuario.setEmail(email);

        model.addAttribute("titulo", "Resultado Form");

        if(result.hasErrors()) {
            /*Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo "
                        .concat(err.getField()).concat(" ")
                        .concat(Optional.ofNullable(err.getDefaultMessage()).orElse("")));
            });
            model.addAttribute("error", errores);*/

            return "form"; //retorna el formulario si hay error en el mismo
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
