package br.com.crtiago.webservice.market.manager;

import br.com.crtiago.webservice.market.dao.FirebirdDao;
import br.com.crtiago.webservice.market.models.ProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager {

    private Connection connection;

    public ProductManager() {
        try {
            connection = FirebirdDao.getInstance().getConnection();
        } catch (Exception e) {
            System.err.println("Nao foi possivel acessar o banco Firebird " + e);
        }
    }

    public ProductEntity getProduct(String barcode) {
        ProductEntity entity = new ProductEntity();
        String query = "Select DESCRICAO, VENDA from Produtos where CODIGO_BARRAS=".concat(barcode);
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                entity.setDescription(rs.getString("DESCRICAO"));
                entity.setPrice(rs.getFloat("VENDA"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar a consulta do produto");
        }
        return entity;
    }
}
