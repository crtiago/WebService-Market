package br.com.crtiago.webservice.market.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseModel {

    private int code;
    private String description;
    private Object object;

    @Override
    public String toString() {
        return "ResponseModel{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", object=" + object +
                '}';
    }
}
