package org.yearup.data;

import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{

    ShoppingCart getByUserId(int userId);
    ShoppingCart addItem(int userId, int productId);
    // add additional method signatures here
}
