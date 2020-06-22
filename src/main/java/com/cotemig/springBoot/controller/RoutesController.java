package com.cotemig.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.springBoot.service.ProdutoService;

@Controller
public class RoutesController {

	@Autowired
	private ProdutoService produtoService;	
	
	@RequestMapping(value = "routes/produtos", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("routes/produtos");
		mav.addObject("produtos", produtoService.getAllProduto());
		return mav;

	}
	
}
