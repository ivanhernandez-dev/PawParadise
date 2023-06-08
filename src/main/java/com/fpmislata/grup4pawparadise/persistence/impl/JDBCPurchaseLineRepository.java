package com.fpmislata.grup4pawparadise.persistence.impl;

import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.database.JDBCUtil;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import com.fpmislata.grup4pawparadise.persistence.PurchaseLineRepository;
import com.fpmislata.grup4pawparadise.persistence.mapper.JDBCPurchaseLineRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCPurchaseLineRepository implements PurchaseLineRepository {

    private JdbcTemplate jdbcTemplate;
    private ProductRepository productRepository = new JDBCProductRepository();

    public JDBCPurchaseLineRepository() {
        this.jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public void setDatasource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DataSource getDatasource() {
        return jdbcTemplate.getDataSource();
    }

    @Override
    public void insert(int idPurchase, int idProduct, int quantity) {
        final String SQL = "INSERT INTO purchase_line (id_purchase, id_product, quantity) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + ?";
        jdbcTemplate.update(SQL, idPurchase, idProduct, quantity, quantity);
    }

    @Override
    public void update(int idPurchase, int idProduct, int quantity) {
        final String SQL = "UPDATE purchase_line SET quantity = ? WHERE id_purchase = ? AND id_product = ?";
        jdbcTemplate.update(SQL, quantity, idPurchase, idProduct);
    }

    @Override
    public void delete(int idPurchase, int productId) {
        final String SQL = "DELETE FROM purchase_line WHERE id_purchase = ? AND id_product = ?";
        jdbcTemplate.update(SQL, idPurchase, productId);
    }

    @Override
    public List<PurchaseLine> getByPurchaseId(int idPurchase, String language) {
        final String SQL = "SELECT * FROM purchase_line WHERE id_purchase = ?";
        return jdbcTemplate.query(
                SQL,
                new JDBCPurchaseLineRowMapper(language, productRepository),
                idPurchase);
    }
}
