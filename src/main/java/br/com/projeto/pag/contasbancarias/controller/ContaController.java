package br.com.projeto.pag.contasbancarias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.pag.contasbancarias.dto.RequisicaoNovaConta;
import br.com.projeto.pag.contasbancarias.model.Conta;
import br.com.projeto.pag.contasbancarias.repository.ContaRepository;

@Controller
@RequestMapping("conta")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovaConta requisicao) {
		return "conta/formulario";
	}
	
	@PostMapping("nova")
	public String nova(@Valid RequisicaoNovaConta requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "conta/formulario";
		}
		
		Conta conta = requisicao.toConta();
		contaRepository.save(conta);
		return "redirect:/home";
	}
}
