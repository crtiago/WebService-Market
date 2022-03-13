package br.com.crtiago.webservice.market.enums;

import lombok.Getter;

@Getter
public enum PropertiesTagEnum {

    URL("spring.datasource.url"),
    USERNAME("spring.datasource.username"),
    PASSWORD("spring.datasource.password"),
    DRIVER("spring.datasource.driver");

    private String tag;

    PropertiesTagEnum(String tag) {
        this.tag = tag;
    }
}
