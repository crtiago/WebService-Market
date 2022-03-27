package br.com.crtiago.webservice.market.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductIncorrectPriceModel {

    private String barcode;
    private String description;
    private float costOfSale;
    private float salePrice;

    @Override
    public String toString() {
        return "ProductIncorrectPriceModel{" +
                "barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", costOfSale=" + costOfSale +
                ", salePrice=" + salePrice +
                '}';
    }
}
