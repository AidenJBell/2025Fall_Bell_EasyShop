package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao
{
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart addItem(int userId, int productId)
    {

        String sql = "INSERT INTO shopping_cart(user_id, product_id, quantity) " +
                " VALUES (?, ?, ?);";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.setInt(3, 1);

            int rowsAffected = statement.executeUpdate();

            return getByUserId(userId);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ShoppingCart getByUserId(int userId) {
        return null;
    }
}
