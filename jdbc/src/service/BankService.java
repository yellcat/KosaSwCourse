package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Account;
import dao.AccountDao;
import dao.ConnectionManager;

public class BankService {
	public void transfer(int from, int to, int amount){
		
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnertion();
			//트랜잭션
			conn.setAutoCommit(false);
			AccountDao accountDao = new AccountDao(conn);
			
			//출금
			Account fromAccount = accountDao.selectByPk(from);
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			accountDao.update(fromAccount);
			//입금
			Account toAccount = accountDao.selectByPk(to);
			toAccount.setBalance(toAccount.getBalance()+amount);
			accountDao.update(toAccount);
			
			conn.commit();
			System.out.println("계좌이체 성공");
		}
		catch (Exception e){
			try {
			conn.rollback();
			System.out.println("계좌이체 실패");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}}
		finally{
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}

}
