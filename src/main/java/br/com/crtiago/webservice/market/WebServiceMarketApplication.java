package br.com.crtiago.webservice.market;

import br.com.crtiago.webservice.market.dao.FirebirdDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class WebServiceMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceMarketApplication.class, args);
        try {
            Connection connection = FirebirdDao.getInstance().getConnection();
        } catch (Exception e) {
            System.err.println("Nao foi possivel acessar o banco Firebird " + e);
        }

    }

}
