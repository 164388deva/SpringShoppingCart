package com.shoppingCart.ShoppingCart.serviceInterface;

import java.util.List;

import com.shoppingCart.ShoppingCart.pojo.UserTransaction;

public interface ICartService {
 public int addProduct(UserTransaction tr);
 public List<UserTransaction> showCart();
 public int update(int UserId,int ProductId,int quantity);
 public int removeproductFromCart(int userId,int productID);
 public int removeAll();
 
}
