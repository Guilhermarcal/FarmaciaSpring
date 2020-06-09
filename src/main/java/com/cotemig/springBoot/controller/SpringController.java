package com.cotemig.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.springBoot.service.ClienteService;
import com.cotemig.springBoot.service.FuncionarioService;
import com.cotemig.springBoot.service.ProdutoService;
import com.cotemig.springBoot.service.VendaService;


@Controller
public class SpringController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendaService vendaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("clientes", clienteService.getAllCliente());
		mav.addObject("funcionarios", funcionarioService.getAllFuncionario());
		mav.addObject("produtos", produtoService.getAllProduto());
		mav.addObject("vendas", vendaService.getAllVenda());
		return mav;
	}
	
}
