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

import com.cotemig.springBoot.model.Funcionario;
import com.cotemig.springBoot.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;	
	

	// INSERT GET
	@RequestMapping(value = "funcionario/insert", method = RequestMethod.GET)
	public ModelAndView insert() {
		
		ModelAndView mav = new ModelAndView("funcionario/insert");
		mav.addObject("funcionario", new Funcionario());		
		return mav;
	}

	// INSERT POST
	@RequestMapping(value = "funcionario/insert", method = RequestMethod.POST)
	public String submitInsert(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.insertFuncionario(funcionario);

		return "redirect:/";
	}

	// DELETE GET
	@RequestMapping(value = "funcionario/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {

		return new ModelAndView("funcionario/delete", "funcionario", funcionarioService.getFuncionarioById(id).get());
	}

	// DELETE POST
	@RequestMapping(value = "funcionario/delete", method = RequestMethod.POST)
	public String submitDelete(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.deleteFuncionarioById(funcionario.getId());

		return "redirect:/";
	}

	// UPDATE GET
	@RequestMapping(value = "funcionario/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

		return new ModelAndView("funcionario/update", "funcionario", funcionarioService.getFuncionarioById(id).get());
	}

	// UPDATE POST
	@RequestMapping(value = "funcionario/update", method = RequestMethod.POST)
	public String submitUpdate(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.updateFuncionario(funcionario);

		return "redirect:/";
	}

	// READ GET
	@RequestMapping(value = "funcionario/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("funcionario/read");
		mav.addObject("funcionarios", funcionarioService.getAllFuncionario());
		return mav;

	}

	
}
