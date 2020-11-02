package br.com.projeto.pag.contasbancarias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.pag.contasbancarias.model.Conta;
import br.com.projeto.pag.contasbancarias.repository.ContaRepository;

@Controller
@RequestMapping("/editar")
public class EditarController {

	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/{contaId}")
	public String formularioEditar(@PathVariable("contaId") Integer contaId, Model model) {
		
		Conta conta = contaRepository.findById(contaId).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
		model.addAttribute("conta", conta);
		
		
		return "conta/editar";
	}
	
	@PostMapping("update/{contaId}")
	public String updateConta(@PathVariable("contaId") Integer contaId, @Valid Conta conta, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        conta.setId(contaId);
	        return "conta/editar"; 
	    }
	    conta.setId(contaId);    
	    contaRepository.save(conta);
	    return "redirect:/home";
	}
	
}
