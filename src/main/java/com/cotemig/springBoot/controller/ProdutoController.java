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

import com.cotemig.springBoot.model.Produto;
import com.cotemig.springBoot.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;	
	

	// INSERT GET
	@RequestMapping(value = "produto/insert", method = RequestMethod.GET)
	public ModelAndView insert() {
		
		ModelAndView mav = new ModelAndView("produto/insert");
		mav.addObject("produto", new Produto());		
		return mav;
	}

	// INSERT POST
	@RequestMapping(value = "produto/insert", method = RequestMethod.POST)
	public String submitInsert(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		produtoService.insertProduto(produto);

		return "redirect:/";
	}

	// DELETE GET
	@RequestMapping(value = "produto/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {

		return new ModelAndView("produto/delete", "produto", produtoService.getProdutoById(id).get());
	}

	// DELETE POST
	@RequestMapping(value = "produto/delete", method = RequestMethod.POST)
	public String submitDelete(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		produtoService.deleteProdutoById(produto.getId());

		return "redirect:/";
	}

	// UPDATE GET
	@RequestMapping(value = "produto/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

		return new ModelAndView("produto/update", "produto", produtoService.getProdutoById(id).get());
	}

	// UPDATE POST
	@RequestMapping(value = "produto/update", method = RequestMethod.POST)
	public String submitUpdate(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		produtoService.updateProduto(produto);

		return "redirect:/";
	}

	// READ GET
	@RequestMapping(value = "produto/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("produto/read");
		mav.addObject("produtos", produtoService.getAllProduto());
		return mav;

	}

}
