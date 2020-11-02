package br.com.projeto.pag.contasbancarias.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.pag.contasbancarias.repository.ContaRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping
    public String customersPage(@RequestParam(name = "filtro", required = false) String filtro, HttpServletRequest request, Model model) {
        
        int page = 0; 
        int size = 15; 
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(page, size, sort);
        
        
        if (filtro != null) {
        model.addAttribute("contas", contaRepository.findByFiltro(filtro, paginacao));
        } else {
        model.addAttribute("contas", contaRepository.findAll(paginacao));	
        }
        
        return "home";
        
    }
	
}
