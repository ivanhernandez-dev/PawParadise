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

    private final ProductRepository productRepository = new JDBCProductRepository();

    @Override
    public void insert(int idPurchase, int idProduct, int quantity) {
        final String SQL = "INSERT INTO purchase_line (id_purchase, id_product, quantity) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + ?";
        List<Object> params = List.of(idPurchase, idProduct, quantity, quantity);
        Connection connection = JDBCUtil.open();
        JDBCUtil.insert(connection, SQL, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void update(int idPurchase, int idProduct, int quantity) {
        final String SQL = "UPDATE purchase_line SET quantity = ? WHERE id_purchase = ? AND id_product = ?";
        List<Object> params = List.of(quantity, idPurchase, idProduct);
        Connection connection = JDBCUtil.open();
        JDBCUtil.update(connection, SQL, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void delete(int idPurchase, int productId) {
        final String SQL = "DELETE FROM purchase_line WHERE id_purchase = ? AND id_product = ?";
        List<Object> params = List.of(idPurchase, productId);
        Connection connection = JDBCUtil.open();
        JDBCUtil.delete(connection, SQL, params);
        JDBCUtil.close(connection);
    }

    @Override
    public List<PurchaseLine> getByPurchaseId(int idPurchase, String language) throws ResourceNotFoundException {
        final String SQL = "SELECT * FROM purchase_line WHERE id_purchase = ?";
        List<Object> params = List.of(idPurchase);
        List<PurchaseLine> purchaseLines = new ArrayList<>();
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, SQL, params);
        try {
            while (resultSet.next()) {
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
