package com.carlosmillan.springbootform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.carlosmillan.springbootform.models.domain.Usuario;
import com.carlosmillan.springbootform.validators.UserValidator;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UserValidator validador;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}

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
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

		// validador.validate(usuario, result); // Nueva Línea

		if (result.hasErrors()) {
			return "form"; // retorna el formulario si hay error en el mismo
		}

		model.addAttribute("titulo", "Resultado Form");
		model.addAttribute("usuario", usuario);

		status.setComplete();
		return "resultado";
	}
}
