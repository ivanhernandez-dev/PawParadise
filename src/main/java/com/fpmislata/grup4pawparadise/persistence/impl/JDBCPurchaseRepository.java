package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.Purchase;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.PurchaseRepository;
import com.fpmislata.grup4pawparadise.persistence.PurchaseLineRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCPurchaseRepository implements PurchaseRepository {

    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Purchase not for: ";

    private final PurchaseLineRepository shoppingRepository = new JDBCPurchaseLineRepository();

    @Override
    public Purchase getByUserIdWhereStatusActive(int idCustomer, String language) throws ResourceNotFoundException {
        final String SQL = "SELECT * FROM purchase WHERE id_customer = ? AND status_purchase = 0 LIMIT 1";
        List<Object> params = List.of(idCustomer);
        Purchase purchase;
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, SQL, params);
        try {
            if (resultSet.next()) {
                purchase = new Purchase(resultSet.getInt("id_purchase"),
                        resultSet.getDate("date_purchase"),
                        resultSet.getInt("status_purchase"),
                        resultSet.getInt("id_customer"),
                        shoppingRepository.getByPurchaseId(resultSet.getInt("id_purchase"), language));
            } else {
                throw new ResourceNotFoundException(PRODUCT_NOT_FOUND_MESSAGE + "Customer ID:" + idCustomer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(SQL_EXCEPTION_MESSAGE + e.getMessage(), e);
        } finally {
            JDBCUtil.close(connection);
        }
        return purchase;
    }

    @Override
    public void insertWithStatusActive(int idCustomer) {
        final String SQL = "INSERT INTO purchase (status_purchase, id_customer) VALUES (0, ?)";
        List<Object> params = List.of(idCustomer);
        Connection connection = JDBCUtil.open();
        JDBCUtil.insert(connection, SQL, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void updatePurchaseStatus(int idPurchase, int status) {
        final String SQL = "UPDATE purchase SET status_purchase = ? WHERE id_purchase = ?";
        List<Object> params = List.of(status, idPurchase);
        Connection connection = JDBCUtil.open();
        JDBCUtil.update(connection, SQL, params);
        JDBCUtil.close(connection);
    }
}
