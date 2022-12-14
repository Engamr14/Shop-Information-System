package it.polito.ezshop.model;

import it.polito.ezshop.data.TicketEntry;

public class ReturnSaleTransaction extends SaleTransaction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2697175701011876018L;
	public it.polito.ezshop.model.SaleTransaction returnOfSaleTransaction;
	boolean committed;

	public ReturnSaleTransaction(Integer ticketNumber, it.polito.ezshop.model.SaleTransaction saleTransaction) {
		super(ticketNumber);
		this.returnOfSaleTransaction=saleTransaction;
	    committed=false;
	}
	
	
	/* INTEGRATION TO TEST */
	
	public boolean addReturnProduct(TicketEntry te, Integer amount) {


		if(amount<=0)
			return false;
	
			it.polito.ezshop.model.TicketEntry entry = new it.polito.ezshop.model.TicketEntry(te.getBarCode(),
					te.getProductDescription(), te.getPricePerUnit(), amount, te.getDiscountRate() );
			double money=te.getPricePerUnit()*amount*(1-te.getDiscountRate())*(1-discountRate);
			
            
			products.put(te.getBarCode(), entry);
			return true;
		
	}

	/* TO TEST */
	
	public boolean isCommitted() {
		return committed;
	}

	public void setCommitted(boolean committed) {
		this.committed = committed;
		
	}

	public SaleTransaction getReturnOfSaleTransaction() {
		return returnOfSaleTransaction;
	}
	
	

	

}
