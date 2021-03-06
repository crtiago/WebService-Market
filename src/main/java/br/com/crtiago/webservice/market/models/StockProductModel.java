package br.com.crtiago.webservice.market.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockProductModel {

    private String description;
    private float stock;

    @Override
    public String toString() {
        return "StockProductModel{" +
                "description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}