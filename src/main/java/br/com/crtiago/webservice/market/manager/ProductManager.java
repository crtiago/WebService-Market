package br.com.crtiago.webservice.market.manager;

import br.com.crtiago.webservice.market.dao.FirebirdDao;
import br.com.crtiago.webservice.market.models.ProductIncorrectPriceModel;
import br.com.crtiago.webservice.market.models.ProductModel;
import br.com.crtiago.webservice.market.models.StockProductModel;
import br.com.crtiago.webservice.market.query.ProductQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);
    private Connection connection;

    public ProductManager() {
        try {
            connection = FirebirdDao.getInstance().getConnection();
        } catch (Exception e) {
            LOGGER.error("Nao foi possivel acessar o banco Firebird: {}", e);
        }
    }

    public ProductModel getProduct(String barcode) {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(ProductQuery.getProductQuery(barcode));
            if (rs.next()) {
                return new ProductModel(barcode, rs.getString("DESCRICAO"), rs.getFloat("VENDA"));
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar a consulta do produto: {}", e);
        }
        return null;
    }

    public List<StockProductModel> getPositiveStockProduct() {
        List<StockProductModel> listProducts = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(ProductQuery.getPositiveStockProductQuery());
            while (rs.next()) {
                listProducts.add(new StockProductModel(rs.getString("DESCRICAO"), rs.getInt("ESTOQUE_PAF")));
            }
            return listProducts;
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar a busca de estoque positivo dos produtos: {}", e);
        }
        return null;
    }

    public List<StockProductModel> getNegativeStockProduct() {
        List<StockProductModel> listProducts = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(ProductQuery.getNegativeStockProductQuery());
            while (rs.next()) {
                listProducts.add(new StockProductModel(rs.getString("DESCRICAO"), rs.getFloat("ESTOQUE_PAF")));
            }
            return listProducts;
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar a busca de estoque negativo dos produtos: {}", e);
        }
        return null;
    }

    public ProductModel updateProduct(ProductModel product) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(ProductQuery.updateProductQuery(product))) {
            prepareStatement.setBytes(1, product.getDescription().getBytes(StandardCharsets.UTF_8));
            prepareStatement.execute();
            return getProduct(product.getBarcode());
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar a atualizacao do produto: {}", e);
        }
        return null;
    }

    public List<ProductIncorrectPriceModel> getProductsWithIncorrectPrice() {
        List<ProductIncorrectPriceModel> listProducts = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(ProductQuery.getProductWithIncorrectPrice());
            while (rs.next()) {
                listProducts.add(new ProductIncorrectPriceModel(rs.getString("CODIGO_BARRAS"), rs.getString("DESCRICAO"), rs.getFloat("CUSTO"), rs.getFloat("VENDA")));
            }
            return listProducts;
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar a busca de estoque negativo dos produtos: {}", e);
        }
        return null;
    }
}
