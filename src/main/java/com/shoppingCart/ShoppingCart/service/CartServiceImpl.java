package com.shoppingCart.ShoppingCart.service;

import java.util.List;

import com.shoppingCart.ShoppingCart.dao.CartDAO;
import com.shoppingCart.ShoppingCart.pojo.UserTransaction;
import com.shoppingCart.ShoppingCart.serviceInterface.ICartService;

public class CartServiceImpl implements ICartService{

	CartDAO cart_dao;
	
	@Override
	public int addProduct(UserTransaction tr) {
		
		return cart_dao.add(tr);
		
		
		

	}

	@Override
	public List<UserTransaction> showCart() {
		
		return cart_dao.getAll();
	}

	@Override
	public int update(int userId, int productId, int quantity) {
		// TODO Auto-generated method stub
		return cart_dao.update(productId, userId, quantity);
	}

	@Override
	public int removeproductFromCart(int userId, int productID) {
		// TODO Auto-generated method stub
		return cart_dao.remove(productID, userId);
	}

	@Override
	public int removeAll() {
		// TODO Auto-generated method stub
		return cart_dao.removeAll();
	}

}
