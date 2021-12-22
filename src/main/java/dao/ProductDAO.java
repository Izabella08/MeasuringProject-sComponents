package dao;

import dbConnection.ConnectionFactory;
import model.ProductDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends AbstractDAO<ProductDB>{

    protected final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertProduct = "INSERT INTO products (id_product, name, price)" + "VALUES (?,?,?)";

    /**
     * Method to add a new product into the database
     * @param p - product to insert
     * @return
     * @throws SQLException
     */
    public int insertProduct(ProductDB p) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertProduct, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, p.getProductId());
        statement.setString(2, p.getProductName());
        statement.setInt(3, p.getProductPrice());
        statement.executeUpdate();
        ConnectionFactory.close(connection);
        return 1;
    }

    /**
     * Method to read from database a list of products
     * @return
     */
    public List<ProductDB> listAllProducts(){
        List<ProductDB> productsList = new ArrayList<ProductDB>();
        ProductDB p = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM products");
            result = statement.executeQuery();
            while (result.next()) {
                int idProduct = result.getInt("id_product");
                String productName = result.getString("name");
                int price = result.getInt("price");
                p = new ProductDB(productName, price);
                p.setProductId(idProduct);
                productsList.add(p);
            }
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING,"CLIENT_DATABASE_OPERATIONS:LISTALL " + e.getMessage());
        }
        ConnectionFactory.close(result);
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
        return productsList;
    }

}
