package com.fpmislata.grup4pawparadise.persistence;

import com.fpmislata.grup4pawparadise.business.entity.ProductFeature;

import java.util.List;

public interface ProductFeatureRepository {

    List<ProductFeature> getByProductIdAndLanguage(int idProduct, String language);
}
