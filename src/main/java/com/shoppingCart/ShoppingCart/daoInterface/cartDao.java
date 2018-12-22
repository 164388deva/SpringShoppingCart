package com.shoppingCart.ShoppingCart.daoInterface;

import java.util.List;

import com.shoppingCart.ShoppingCart.pojo.UserTransaction;

public interface cartDao {
public UserTransaction get(int productId,int userId);
public List<UserTransaction> getAll();
public int add(UserTransaction userTransaction);
public int remove(int userId,int pid);
public int update(int productId,int userId,int quantity);
public boolean contains();
public int removeAll();
//public String pushIntoDB(List<UserTransaction> list);
}
