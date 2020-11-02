package br.com.projeto.pag.contasbancarias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.projeto.pag.contasbancarias.model.Conta;
import br.com.projeto.pag.contasbancarias.repository.ContaRepository;

@Controller
public class DeleteController {

	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/delete/{contaId}")
	public String deleteConta(@PathVariable("contaId") Integer contaId, Model model) {
	    Conta conta = contaRepository.findById(contaId).orElseThrow(() -> new IllegalArgumentException("Id inválido"));
	    contaRepository.delete(conta);
	    
	    model.addAttribute("conta", contaRepository.findAll());
	    
	    return "redirect:/home";
	}
}
