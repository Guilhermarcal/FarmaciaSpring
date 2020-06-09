package com.cotemig.springBoot.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.springBoot.model.Venda;
import com.cotemig.springBoot.repository.VendaRepository;
import com.cotemig.springBoot.service.ClienteService;
import com.cotemig.springBoot.service.FuncionarioService;
import com.cotemig.springBoot.service.ProdutoService;
import com.cotemig.springBoot.service.VendaService;

@Controller
public class VendaController {
	
	@Autowired
	private VendaService vendaService;	
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ProdutoService produtoService;

	// INSERT GET
	@RequestMapping(value = "venda/insert", method = RequestMethod.GET)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("venda/insert");
		mav.addObject("venda", new Venda());
		mav.addObject("clientes", clienteService.getAllCliente());
		mav.addObject("funcionarios", funcionarioService.getAllFuncionario());
		mav.addObject("produtos", produtoService.getAllProduto());
		return mav;
	}

	// INSERT POST
	@RequestMapping(value = "venda/insert", method = RequestMethod.POST)
	public String submitInsert(@Valid @ModelAttribute("venda") Venda venda, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}
		
		vendaService.insertVenda(venda);

		return "redirect:/";
	}

	// DELETE GET
	@RequestMapping(value = "venda/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {

		return new ModelAndView("venda/delete", "venda", vendaService.getVendaById(id).get());
	}

	// DELETE POST
	@RequestMapping(value = "venda/delete", method = RequestMethod.POST)
	public String submitDelete(@Valid @ModelAttribute("venda") Venda venda, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		vendaService.deleteVendaById(venda.getId());

		return "redirect:/";
	}

	// UPDATE GET
	@RequestMapping(value = "venda/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {
		
		ModelAndView mav = new ModelAndView("venda/update", "venda", vendaService.getVendaById(id).get());
		mav.addObject("venda", new Venda());
		mav.addObject("clientes", clienteService.getAllCliente());
		mav.addObject("funcionarios", funcionarioService.getAllFuncionario());
		mav.addObject("produtos", produtoService.getAllProduto());

		return mav;
	}

	// UPDATE POST
	@RequestMapping(value = "venda/update", method = RequestMethod.POST)
	public String submitUpdate(@Valid @ModelAttribute("venda") Venda venda, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		vendaService.updateVenda(venda);

		return "redirect:/";
	}

	// READ GET
	@RequestMapping(value = "venda/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("venda/read");
		mav.addObject("venda", vendaService.getAllVenda());
		return mav;

	}

}
