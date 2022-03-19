package br.com.crtiago.webservice.market.query;

import br.com.crtiago.webservice.market.models.ProductModel;

public class ProductQuery {

    public static String getProductQuery(String barcode) {
        return "SELECT DESCRICAO, VENDA FROM PRODUTOS WHERE CODIGO_BARRAS=".concat(barcode);
    }

    public static String updateProductQuery(ProductModel product) {
        return "UPDATE PRODUTOS SET DESCRICAO = '" + product.getDescription() +
                "',DESCRICAO_NOTA = ?" +
                ",VENDA = " + product.getPrice() +
                " WHERE CODIGO_BARRAS = " + product.getBarcode();
    }

    public static String getStockProductQuery() {
        return "SELECT FIRST 10 DESCRICAO, ESTOQUE_PAF FROM SALDOSESTOQUE ORDER BY ESTOQUE_PAF DESC";//"SELECT DESCRICAO, ESTOQUE FROM PRODUTOS WHERE CODIGO_BARRAS=".concat(barcode);
    }
}
