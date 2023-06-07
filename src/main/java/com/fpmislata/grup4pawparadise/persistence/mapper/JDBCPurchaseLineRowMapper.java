package com.fpmislata.grup4pawparadise.persistence.mapper;

import com.fpmislata.grup4pawparadise.business.entity.PurchaseLine;
import com.fpmislata.grup4pawparadise.exception.ResourceNotFoundException;
import com.fpmislata.grup4pawparadise.persistence.ProductRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPurchaseLineRowMapper implements RowMapper<PurchaseLine> {

    private String language;
    private ProductRepository productRepository;

    public JDBCPurchaseLineRowMapper(String language, ProductRepository productRepository) {
        this.language = language;
        this.productRepository = productRepository;
    }

    @Override
    public PurchaseLine mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            return new PurchaseLine(
                    rs.getInt("quantity"),
                    productRepository.getById(rs.getInt("id_product"), language));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
