package com.shoppingCart.ShoppingCart;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingCart.ShoppingCart.dao.CartDAO;
import com.shoppingCart.ShoppingCart.daoInterface.cartDao;
import com.shoppingCart.ShoppingCart.pojo.UserTransaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
    	cartDao  cd= context.getBean("cartDao",CartDAO.class);
    	//UserTransaction u=new UserTransaction(5, 5,	 "Shirt", 400, 4);
    	//System.out.println(cd.add(u));
    	//List<UserTransaction> al=cd.getAll();
    	
   
   // System.out.println(al);
    UserTransaction t=cd.get(4,4);	
    	System.out.println(t);
    cd.remove(1, 1);
    System.out.println(cd.get(1,1));	
    cd.removeAll();
    System.out.println(cd.getAll());
}
}