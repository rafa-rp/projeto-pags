package br.com.projeto.pag.contasbancarias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.pag.contasbancarias.model.Conta;
import br.com.projeto.pag.contasbancarias.repository.ContaRepository;

@Controller
@RequestMapping("/detalhe")
public class DetalhesController {

	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/{contaId}")
	public String detalhe(@PathVariable("contaId") Integer contaId, Model model) throws Exception{
		
		Conta conta = contaRepository.findById(contaId).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
		Double calculo = Double.valueOf(conta.getChequeEspecial()).doubleValue() + (Double.valueOf(conta.getTaxa()).doubleValue())/100*(Double.valueOf(conta.getChequeEspecial()).doubleValue());
		conta.setJuros(Double.toString(calculo));
		
		model.addAttribute("conta", conta);
		return "conta/detalhe";
	}
	
	@PostMapping("/numero")
	public String detalheNumero(@RequestParam(name = "contaNumero") String contaNumero, Model model) {
		
		try {
		Conta conta = contaRepository.findByContaNumero(contaNumero).orElseThrow(() -> new IllegalArgumentException("Número inválido"));
		Double calculo = Double.valueOf(conta.getChequeEspecial()).doubleValue() + (Double.valueOf(conta.getTaxa()).doubleValue())/100*(Double.valueOf(conta.getChequeEspecial()).doubleValue());
		conta.setJuros(Double.toString(calculo));
		
		model.addAttribute("conta",conta);
		return "conta/detalhe";
		
		}catch (IllegalArgumentException e) {
			return "redirect:/home";
		}
	}
}
