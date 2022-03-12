package br.com.crtiago.webservice.market.configuration;

public enum PropertiesTagEnum {

    URL("spring.datasource.url"),
    USERNAME("spring.datasource.username"),
    PASSWORD("spring.datasource.password"),
    DRIVER("spring.datasource.driver");

    private String tag;

    PropertiesTagEnum(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
