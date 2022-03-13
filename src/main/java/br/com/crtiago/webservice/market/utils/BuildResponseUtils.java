package br.com.crtiago.webservice.market.utils;

import br.com.crtiago.webservice.market.enums.ResponseRequestEnum;
import br.com.crtiago.webservice.market.models.ResponseModel;

public class BuildResponseUtils {

    public static ResponseModel buildResponse(Object object) {
        if (object == null) {
            return new ResponseModel(ResponseRequestEnum.PRODUCT_NOT_FOUND.getCode(), ResponseRequestEnum.PRODUCT_NOT_FOUND.getDescription(), null);
        }
        return new ResponseModel(ResponseRequestEnum.SUCCESS.getCode(), ResponseRequestEnum.SUCCESS.getDescription(), object);
    }
}
