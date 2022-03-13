package br.com.crtiago.webservice.market.models;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private String barcode;
    private String description;
    private float price;

}