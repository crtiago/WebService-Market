package br.com.crtiago.webservice.market.controller;


import br.com.crtiago.webservice.market.manager.ProductManager;
import br.com.crtiago.webservice.market.models.ProductModel;
import br.com.crtiago.webservice.market.models.ResponseModel;
import br.com.crtiago.webservice.market.models.StockProductModel;
import br.com.crtiago.webservice.market.utils.BuildResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductManager manager = new ProductManager();

    @GetMapping("/product")
    public ResponseEntity<ResponseModel> getProduct(@RequestParam(value = "barcode") String barcode) {
        ProductModel product = manager.getProduct(barcode);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product), HttpStatus.OK);
    }

    @GetMapping("/stock-product")
    public ResponseEntity<ResponseModel> getStockProduct() {
        List<StockProductModel> products = manager.getStockProduct();
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(products), HttpStatus.OK);
    }

    @PutMapping("/update-product")
    public ResponseEntity<ResponseModel> updateProduct(@RequestBody ProductModel productModel) {
        ProductModel product = manager.updateProduct(productModel);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product), HttpStatus.OK);
    }
}