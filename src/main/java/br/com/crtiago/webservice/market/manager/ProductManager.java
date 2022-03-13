package br.com.crtiago.webservice.market.manager;

import br.com.crtiago.webservice.market.dao.FirebirdDao;
import br.com.crtiago.webservice.market.models.ProductModel;
import br.com.crtiago.webservice.market.query.ProductQuery;

import java.nio.charset.StandardCharsets;
import java.sql.*;

public class ProductManager {

    private Connection connection;

    public ProductManager() {
        try {
            connection = FirebirdDao.getInstance().getConnection();
        } catch (Exception e) {
            System.err.println("Nao foi possivel acessar o banco Firebird " + e);
        }
    }

    public ProductModel getProduct(String barcode) {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(ProductQuery.getProductQuery(barcode));
            if (rs.next()) {
                return new ProductModel(barcode, rs.getString("DESCRICAO"), rs.getFloat("VENDA"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar a consulta do produto:" + e);
        }
        return null;
    }

    public ProductModel updateProduct(ProductModel product) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(ProductQuery.updateProductQuery(product))) {
            prepareStatement.setBytes(1, product.getDescription().getBytes(StandardCharsets.UTF_8));
            prepareStatement.execute();
            return getProduct(product.getBarcode());
        } catch (SQLException e) {
            System.out.println("Erro ao realizar a atualização do produto:" + e);
        }
        return null;
    }
}
