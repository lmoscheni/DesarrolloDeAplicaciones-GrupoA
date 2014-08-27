package ar.edu.unq.desapp.grupoa;

import java.util.Date;

public class Proof {

	//private BillType billType;
	private int cuit;
	private int amount;
	private Date dateOfIssue;
	private String businessName;
	private String concept;
	
	//******************************************************************************************************
	//									Getters and Setters
	//******************************************************************************************************
	
//	public BillType getBillType() {
//		return billType;
//	}
//	public void setBillType(BillType billType) {
//		this.billType = billType;
//	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	//******************************************************************************************************
	
	public int finalAmount(){
		return 0;
	}
	
}
