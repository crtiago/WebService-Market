package br.com.crtiago.webservice.market.controller;


import br.com.crtiago.webservice.market.manager.ProductManager;
import br.com.crtiago.webservice.market.models.ProductModel;
import br.com.crtiago.webservice.market.models.ResponseModel;
import br.com.crtiago.webservice.market.utils.BuildResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductManager manager = new ProductManager();

   // @RequestMapping(value = "/product", method = RequestMethod.GET)
    @GetMapping("/product")
    public ResponseEntity<ResponseModel> getProduct(@RequestParam(value = "barcode") String barcode) {
        ProductModel product = manager.getProduct(barcode);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product), HttpStatus.OK);
    }

    @PutMapping("/update-product")
    //@RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateProduct(@RequestBody ProductModel productModel) {
        ProductModel product = manager.updateProduct(productModel);
        return new ResponseEntity<>(BuildResponseUtils.buildResponse(product), HttpStatus.OK);
    }
}