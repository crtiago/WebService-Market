package br.com.crtiago.webservice.market.controller;


import br.com.crtiago.webservice.market.enums.ResponseRequestEnum;
import br.com.crtiago.webservice.market.manager.ProductManager;
import br.com.crtiago.webservice.market.models.ProductModel;
import br.com.crtiago.webservice.market.models.ResponseModel;
import br.com.crtiago.webservice.market.models.StockProductModel;
import br.com.crtiago.webservice.market.utils.BuildResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductManager manager = new ProductManager();

    @GetMapping("/product")
    public ResponseEntity<ResponseModel> getProduct(@RequestParam(value = "barcode") String barcode) {
        LOGGER.info("Requisicao para consultar o produto com o codigo de barras: {}", barcode);
        ProductModel product = manager.getProduct(barcode);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product, ResponseRequestEnum.PRODUCT_NOT_FOUND), HttpStatus.OK);
    }

    @GetMapping("/positive-stock-product")
    public ResponseEntity<ResponseModel> getPositiveStockProduct() {
        LOGGER.info("Requisicao para consultar os produtos com o estoque positivo");
        List<StockProductModel> products = manager.getPositiveStockProduct();
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(products, ResponseRequestEnum.STOCK_ERROR), HttpStatus.OK);
    }

    @GetMapping("/negative-stock-product")
    public ResponseEntity<ResponseModel> getNegativeStockProduct() {
        LOGGER.info("Requisicao para consultar os produtos com o estoque negativo");
        List<StockProductModel> products = manager.getNegativeStockProduct();
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(products, ResponseRequestEnum.STOCK_ERROR), HttpStatus.OK);
    }

    @PutMapping("/update-product")
    public ResponseEntity<ResponseModel> updateProduct(@RequestBody ProductModel productModel) {
        LOGGER.info("Requisicao para realizar a atualizacao do produto com os seguintes valores: {}", productModel);
        ProductModel product = manager.updateProduct(productModel);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product, ResponseRequestEnum.UPDATE_ERROR), HttpStatus.OK);
    }

    //TODO Implementar metodo para buscar os produtos com valores incorretos
}