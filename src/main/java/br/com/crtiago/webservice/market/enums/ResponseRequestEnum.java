package br.com.crtiago.webservice.market.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseRequestEnum {

    SUCCESS(HttpStatus.OK.value(), "Requisição realizada com sucesso!"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Produto não encontrado!"),
    STOCK_ERROR(HttpStatus.NOT_FOUND.value(), "Não foi possível buscar a lista de estoque dos produtos!"),
    UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Não foi possível realizar a atualização do produto!");

    private int code;
    private String description;

    ResponseRequestEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
