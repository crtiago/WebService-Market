package br.com.crtiago.webservice.market.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    private String description;
    private float price;

}