package com.reagan.wxpt.service.impl.business;

import com.reagan.util.PageBean;
import com.reagan.wxpt.dao.business.ITransactionDao;
import com.reagan.wxpt.pojo.business.BusinessTransaction;
import com.reagan.wxpt.service.business.ITransactionService;
import com.reagan.wxpt.vo.business.TransactionVO;

public class TransactonServiceImpl implements ITransactionService {

	private ITransactionDao transactionDao;
	
	public void addTransaction(TransactionVO transactionVO) throws Exception {
		transactionDao.save(transactionVO.getTransaction());
	}
	
	public TransactionVO viewTransactionDetail(TransactionVO transactionVO) {
		BusinessTransaction transaction = transactionDao.query(transactionVO.getTransaction());
		transactionVO.setTransaction(transaction);
		return transactionVO;
	}
	
	public PageBean<BusinessTransaction> queryTransactionList(TransactionVO transactionVO) {
		return transactionDao.queryForPage(transactionVO.getTransaction(), transactionVO.getPageNO(), transactionVO.getPageRows());
	}
}
