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

    private static final String SELECT_PURCHASE_BY_USER_ID_WHERE_STATUS_ACTIVE = "SELECT * FROM purchase WHERE " +
            "id_customer = ? AND status_purchase = 0 LIMIT 1";
    private static final String UPDATE_PURCHASE_STATUS = "UPDATE purchase SET status_purchase = ? WHERE id_purchase = ?";
    private static final String INSERT_PURCHASE_WITH_STATUS_ACTIVE = "INSERT INTO purchase (status_purchase, id_customer) VALUES (0, ?)";

    private static final String SQL_EXCEPTION_MESSAGE = "SQL error occurred: ";
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Purchase not for: ";

    private final PurchaseLineRepository shoppingRepository = new JDBCPurchaseLineRepository();


    @Override
    public Purchase getByUserIdWhereStatusActive(int idCustomer, String language) throws ResourceNotFoundException {
        List<Object> params = List.of(idCustomer);
        Purchase purchase;
        Connection connection = JDBCUtil.open();
        ResultSet resultSet = JDBCUtil.select(connection, SELECT_PURCHASE_BY_USER_ID_WHERE_STATUS_ACTIVE, params);
        try {
            if (resultSet.next()) {
                purchase = new Purchase(resultSet.getInt("id_purchase"),
                        resultSet.getDate("date_purchase"),
                        resultSet.getInt("status_purchase"),
                        resultSet.getInt("id_customer"),
                        shoppingRepository.getByPurchaseId(resultSet.getInt("id_purchase"), language));
            } else {
                throw new ResourceNotFoundException(PRODUCT_NOT_FOUND_MESSAGE + "Customer ID:"+ idCustomer);
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
        List<Object> params = List.of(idCustomer);
        Connection connection = JDBCUtil.open();
        JDBCUtil.insert(connection, INSERT_PURCHASE_WITH_STATUS_ACTIVE, params);
        JDBCUtil.close(connection);
    }

    @Override
    public void updatePurchaseStatus(int idPurchase, int status) {
        List<Object> params = List.of(status, idPurchase);
        Connection connection = JDBCUtil.open();
        JDBCUtil.update(connection, UPDATE_PURCHASE_STATUS, params);
        JDBCUtil.close(connection);
    }
}
