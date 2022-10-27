package com.example.productManager.web.controllers;


import com.example.productManager.data.models.Product;
import com.example.productManager.payloads.ProductDto;
import com.example.productManager.service.ProductService;
import com.example.productManager.web.exceptions.ProductNotFoundException;
import com.example.productManager.web.exceptions.RunTimeExceptionPlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDto product) throws RunTimeExceptionPlaceHolder, ProductNotFoundException {
        productService.saveProduct(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.findProductById(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) throws ProductNotFoundException {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
