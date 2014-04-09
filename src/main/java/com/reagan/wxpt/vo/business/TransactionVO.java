package com.reagan.wxpt.vo.business;

import java.util.ArrayList;
import java.util.List;

import com.reagan.wxpt.pojo.business.BusinessTransaction;
import com.reagan.wxpt.vo.BaseVO;

public class TransactionVO extends BaseVO {
	
	private BusinessTransaction transaction;

	private List<BusinessTransaction> transactionList;
	
	public TransactionVO() {
		transaction = new BusinessTransaction();
		transactionList = new ArrayList<BusinessTransaction>();
	}

	public BusinessTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(BusinessTransaction transaction) {
		this.transaction = transaction;
	}

	public List<BusinessTransaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<BusinessTransaction> transactionList) {
		this.transactionList = transactionList;
	}
	
}
