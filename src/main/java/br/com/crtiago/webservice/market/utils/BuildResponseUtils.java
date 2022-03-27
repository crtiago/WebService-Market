package br.com.crtiago.webservice.market.utils;

import br.com.crtiago.webservice.market.enums.ResponseRequestEnum;
import br.com.crtiago.webservice.market.models.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildResponseUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(BuildResponseUtils.class);

    public static ResponseModel buildResponse(Object object, ResponseRequestEnum responseRequestEnum) {
        if (object == null) {
            LOGGER.info("Requisicao realizada com falha!");
            return new ResponseModel(responseRequestEnum.getCode(), responseRequestEnum.getDescription(), null);
        }
        ResponseModel responseModel = new ResponseModel(ResponseRequestEnum.SUCCESS.getCode(), ResponseRequestEnum.SUCCESS.getDescription(), object);
        LOGGER.info("Requisicao realizada com sucesso!");
        LOGGER.info("Response: {}", responseModel);
        return responseModel;
    }
}
