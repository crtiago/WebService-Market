package br.com.crtiago.webservice.market.utils;

import br.com.crtiago.webservice.market.enums.ResponseRequestEnum;
import br.com.crtiago.webservice.market.models.ResponseModel;

public class BuildResponseUtils {

    public static ResponseModel buildResponse(Object object, ResponseRequestEnum responseRequestEnum) {
        if (object == null) {
            return new ResponseModel(responseRequestEnum.getCode(), responseRequestEnum.getDescription(), null);
        }
        return new ResponseModel(ResponseRequestEnum.SUCCESS.getCode(), ResponseRequestEnum.SUCCESS.getDescription(), object);
    }
}
