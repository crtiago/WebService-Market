package br.com.crtiago.webservice.market.enums;

import lombok.Getter;

@Getter
public enum ResponseRequestEnum {

    SUCCESS(200, "Requisição realizada com sucesso!"),
    PRODUCT_NOT_FOUND(404, "Produto não encontrado!");

    private int code;
    private String description;

    ResponseRequestEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
