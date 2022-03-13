package br.com.crtiago.webservice.market.controller;


import br.com.crtiago.webservice.market.manager.ProductManager;
import br.com.crtiago.webservice.market.models.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductManager manager;

    @GetMapping("/product")
    public ProductEntity getProduct(@RequestParam(value = "barcode") String barcode) {
        manager = new ProductManager();
        return manager.getProduct(barcode);
    }
}