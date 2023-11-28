package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection;
        connection = ConnectionDB.openConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
           ResultSet rs =  statement.executeQuery();
           while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                Category category = new CategoryDAOImpl().findById(rs.getInt("category_id"));
                product.setCategory(category);
                products.add(product);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean saveOrUpdate(Product product)  {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        boolean check = false;
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO product(name,price,category_id) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setFloat(2,product.getPrice());
            statement.setInt(3,product.getCategory().getCategoryId());
            int s1 = statement.executeUpdate();
            String sql2 = "UPDATE category SET qty_pro = qty_pro + 1 WHERE id = ?";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1,product.getCategory().getCategoryId());
            int s2 = statement2.executeUpdate();
            if(s1 > 0 && s2 >0)
            {
                check = true;
                connection.commit();
            }
        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }

    @Override
    public Product findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
