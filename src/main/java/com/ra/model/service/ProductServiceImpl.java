package com.ra.model.service;

import com.ra.model.dao.ProductDAO;
import com.ra.model.dao.ProductDAOImpl;
import com.ra.model.entity.Product;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public List<Product> findAll() {

        return productDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Product product){
        return productDAO.saveOrUpdate(product);
    }

    @Override
    public Product findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
