package com.cotemig.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.springBoot.model.Cliente;
import com.cotemig.springBoot.service.ClienteService;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;	
	

	// INSERT GET
	@RequestMapping(value = "cliente/insert", method = RequestMethod.GET)
	public ModelAndView insert() {
		
		ModelAndView mav = new ModelAndView("cliente/insert");
		mav.addObject("cliente", new Cliente());		
		return mav;
	}

	// INSERT POST
	@RequestMapping(value = "cliente/insert", method = RequestMethod.POST)
	public String submitInsert(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		clienteService.insertCliente(cliente);

		return "redirect:/";
	}

	// DELETE GET
	@RequestMapping(value = "cliente/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {

		return new ModelAndView("cliente/delete", "cliente", clienteService.getClienteById(id).get());
	}

	// DELETE POST
	@RequestMapping(value = "cliente/delete", method = RequestMethod.POST)
	public String submitDelete(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		clienteService.deleteClienteById(cliente.getId());

		return "redirect:/";
	}

	// UPDATE GET
	@RequestMapping(value = "cliente/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

		return new ModelAndView("cliente/update", "cliente", clienteService.getClienteById(id).get());
	}

	// UPDATE POST
	@RequestMapping(value = "cliente/update", method = RequestMethod.POST)
	public String submitUpdate(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		clienteService.updateCliente(cliente);

		return "redirect:/";
	}

	// READ GET
	@RequestMapping(value = "cliente/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("cliente/read");
		mav.addObject("clientes", clienteService.getAllCliente());
		return mav;

	}

}
