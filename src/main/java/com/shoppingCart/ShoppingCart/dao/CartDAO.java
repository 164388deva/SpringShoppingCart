package com.shoppingCart.ShoppingCart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.shoppingCart.ShoppingCart.daoInterface.cartDao;
import com.shoppingCart.ShoppingCart.daoSupport.JdbcSupport;
import com.shoppingCart.ShoppingCart.pojo.UserTransaction;

public class CartDAO implements cartDao{
JdbcSupport jdbc_support;


	
	


	@Override
	public UserTransaction get(int pid,int uid) {
		/*
		for(UserTransaction user:getAll()){
			if( user.getProductId()==id){
				user.setTotal(user.getQuantity()*user.getPrice());
				return user;
			}
		}*/
		
		
		
		
		UserTransaction transaction =jdbc_support.getJdbcTemplate().query("select * from cartDetail where productid="+pid+"and userid="+uid,
				new ResultSetExtractor<UserTransaction>() {
					@Override
					public UserTransaction extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						UserTransaction transaction = new UserTransaction();
						while (rs.next()) {
						
							transaction.setUserId(rs.getInt(4));
							transaction.setProductId(rs.getInt(5));
							transaction.setProductName(rs.getString(1));
							transaction.setPrice(rs.getDouble(2));
							transaction.setQuantity(rs.getInt(3));
							
						}
						return transaction;
					}

				});
		
		
		return transaction;
	}

	@Override
	public List<UserTransaction> getAll() {
		List<UserTransaction> AllTransaction=	jdbc_support.getJdbcTemplate().query("select * from cartDetail",
				new ResultSetExtractor<List<UserTransaction>>() {
					@Override
					public List<UserTransaction> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<UserTransaction> list = new ArrayList<UserTransaction>();
						while (rs.next()) {
							UserTransaction userT = new UserTransaction();
							userT.setUserId(rs.getInt(4));
							userT.setProductId(rs.getInt(5));
							userT.setProductName(rs.getString(1));
							userT.setPrice(rs.getDouble(2));
							userT.setQuantity(rs.getInt(3));
							
							list.add(userT);
						}
						return list;
					}

				});
		
		/*List<UserTransaction> a=userTransactionList;
				for(UserTransaction user:a){
					
						user.setTotal(user.getQuantity()*user.getPrice());
						
					}*/
		return AllTransaction;
	}

	@Override
	public int add(UserTransaction userTransaction) {
		String query = "insert into cartDetail values('" + 
				 userTransaction.getProductName() + "','"
				+ userTransaction.getPrice() + "','"
				+ userTransaction.getQuantity() + "','"
			   + userTransaction.getUserId()+ "','"
								+ userTransaction.getProductId()+ "')";
		return jdbc_support.getJdbcTemplate().update(query);
		/*userTransactionList.add(userTransaction);*/
	
		
		
	}

	@Override
	public int remove(int pid,int uid) {
		String query = "delete from cartDetail where productId="
				+pid+ " and userId="+uid;
		return jdbc_support.getJdbcTemplate().update(query);
		/*ListIterator<UserTransaction> it = userTransactionList.listIterator();
		while(it.hasNext())
		{
			UserTransaction ut= (UserTransaction)it.next();
			if(ut.getProductId()==id)
			{
				userTransactionList.remove(ut);
				return 1;
			}
		}
		return 0;*/
	}

	@Override
	public int update(int productid,int userId,int quantity ) {
	      String query= "UPDATE Cartdetail SET quantity ="+ quantity+"   WHERE ID ="+productid+ " and userId="+userId+"' ";
		return jdbc_support.getJdbcTemplate().update(query);

		/*for(UserTransaction user:getAll()){
			if( user.getProductId()==productid){
				user.setQuantity(quantity);
		        user.setTotal(quantity*user.getPrice());
			}
		}
	return 1;	
		*/
		
	}

	@Override
	public boolean contains() {
		// TODO Auto-generated method stub
		List<UserTransaction> tr=getAll();
		if(tr.size()<=0){
		return false;
		}
		return true;
	}

	

	public JdbcSupport getJdbc_support() {
		return jdbc_support;
	}

	public void setJdbc_support(JdbcSupport jdbc_support) {
		this.jdbc_support = jdbc_support;
	}

	public CartDAO() {
		// TODO Auto-generated constructor stub
	}
/*
	@Override
	public String pushIntoDB(List<UserTransaction> list ) {
		String query;
		for(UserTransaction userTransaction:list){
		 query= "insert into cartDetail values('" + 
		 userTransaction.getProductName() + "','"
		+ userTransaction.getPrice() + "','"
		+ userTransaction.getQuantity() + "','"
	   + userTransaction.getUserId()+ "','"
						+ userTransaction.getProductId()+ "')";
jdbc_support.getJdbcTemplate().update(query);
		}
		return "success";
	}*/

	public int removeAll() {
		String query = "delete from cartDetail  ";
		return jdbc_support.getJdbcTemplate().update(query);
	}
	
}
