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

    public static String getPositiveStockProductQuery() {
        return "SELECT FIRST 10 DISTINCT DESCRICAO, ESTOQUE_PAF FROM SALDOSESTOQUE ORDER BY ESTOQUE_PAF DESC";
    }

    public static String getNegativeStockProductQuery() {
        //FIXME ajustar query
        return "SELECT FIRST 50 DISTINCT DESCRICAO, ESTOQUE_PAF FROM SALDOSESTOQUE  WHERE ESTOQUE_PAF IS NOT NULL AND ESTOQUE_PAF < 0 ORDER BY ESTOQUE_PAF ASC";
    }
}
