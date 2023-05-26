package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import com.fpmislata.grup4pawparadise.persistence.PurchaseLineRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCPurchaseLineRepository implements PurchaseLineRepository {

    private ProductRepository productRepository = new JDBCProductRepository();

    private static final String SELECT_PURCHASE_LINES_BY_PURCHASE_ID = "SELECT * FROM shopping_cart WHERE id_purchase = ?";
    private static final String DELETE_PURCHASE_LINE = "DELETE FROM shopping_cart WHERE id_purchase = ? AND id_product = ?";
    private static final String INSERT_PURCHASE_LINE = "INSERT INTO shopping_cart (id_purchase, id_product, quantity)" +
            " VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE quantity = quantity + ?";
    private static final String UPDATE_PURCHASE_LINE = "UPDATE shopping_cart SET quantity = ? WHERE id_purchase = ? " +
            "AND id_product = ?";

    @Override
    public void insert(int idPurchase, int idProduct, int quantity) {
        List<Object> params = List.of(idPurchase, idProduct, quantity, quantity);
        Connection connection = JDBCUtil.open();
        JDBCUtil.insert(connection, INSERT_PURCHASE_LINE, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void update(int idPurchase, int idProduct, int quantity) {
        List<Object> params = List.of(quantity, idPurchase, idProduct);
        Connection connection = JDBCUtil.open();
        JDBCUtil.update(connection, UPDATE_PURCHASE_LINE, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void delete(int idPurchase, int productId) {
        List<Object> params = List.of(idPurchase, productId);
        Connection connection = JDBCUtil.open();
        JDBCUtil.delete(connection, DELETE_PURCHASE_LINE, params);
        JDBCUtil.close(connection);
    }

    @Override
    public List<PurchaseLine> getByPurchaseId(int idPurchase, String language) throws ResourceNotFoundException {
        List<Object> params = List.of(idPurchase);
        List<PurchaseLine> purchaseLines = new ArrayList<>();
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, SELECT_PURCHASE_LINES_BY_PURCHASE_ID, params);
        try {
            while (resultSet.next()){
                purchaseLines.add(new PurchaseLine(resultSet.getInt("id_purchase"),
                        resultSet.getInt("quantity"),
                        productRepository.getById(resultSet.getInt("id_product"), language)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchaseLines;
    }
}
