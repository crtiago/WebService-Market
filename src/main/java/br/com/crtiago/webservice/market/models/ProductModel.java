package br.com.crtiago.webservice.market.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private String barcode;
    private String description;
    private float price;

    @Override
    public String toString() {
        return "ProductModel{" +
                "barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}