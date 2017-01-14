package br.com.marcelogaia.mortgagecalc.model;

import javafx.beans.property.SimpleStringProperty;

public class Payment {
	private final SimpleStringProperty pmtNum = new SimpleStringProperty("");
	private final SimpleStringProperty date = new SimpleStringProperty("");
	private final SimpleStringProperty startBalance = new SimpleStringProperty("");
	private final SimpleStringProperty pmtAmount = new SimpleStringProperty("");
	private final SimpleStringProperty capitalPaid = new SimpleStringProperty("");
	private final SimpleStringProperty interestPaid = new SimpleStringProperty("");
	private final SimpleStringProperty remainingBalance = new SimpleStringProperty("");
	
	public Payment(String pmtNum, String date, String startBalance, String pmtAmount, 
			String capitalPaid, String interestPaid, String remainingBalance){
		setPmtNum(pmtNum);
		setDate(date);
		setStartBalance(startBalance);
		setPmtAmount(pmtAmount);
		setCapitalPaid(capitalPaid);
		setInterestPaid(interestPaid);
		setRemainingBalance(remainingBalance);
	}
	
	public final SimpleStringProperty pmtNumProperty() {
		return this.pmtNum;
	}
	
	public final String getPmtNum() {
		return this.pmtNumProperty().get();
	}
	
	public final void setPmtNum(final String pmtNum) {
		this.pmtNumProperty().set(pmtNum);
	}
	
	public final SimpleStringProperty dateProperty() {
		return this.date;
	}
	
	public final String getDate() {
		return this.dateProperty().get();
	}
	
	public final void setDate(final String date) {
		this.dateProperty().set(date);
	}
	
	public final SimpleStringProperty startBalanceProperty() {
		return this.startBalance;
	}
	
	public final String getStartBalance() {
		return this.startBalanceProperty().get();
	}
	
	public final void setStartBalance(final String startBalance) {
		this.startBalanceProperty().set(startBalance);
	}
	
	public final SimpleStringProperty pmtAmountProperty() {
		return this.pmtAmount;
	}
	
	public final String getPmtAmount() {
		return this.pmtAmountProperty().get();
	}
	
	public final void setPmtAmount(final String pmtAmount) {
		this.pmtAmountProperty().set(pmtAmount);
	}
	
	public final SimpleStringProperty capitalPaidProperty() {
		return this.capitalPaid;
	}
	
	public final String getCapitalPaid() {
		return this.capitalPaidProperty().get();
	}
	
	public final void setCapitalPaid(final String capitalPaid) {
		this.capitalPaidProperty().set(capitalPaid);
	}
	
	public final SimpleStringProperty interestPaidProperty() {
		return this.interestPaid;
	}
	
	public final String getInterestPaid() {
		return this.interestPaidProperty().get();
	}
	
	public final void setInterestPaid(final String interestPaid) {
		this.interestPaidProperty().set(interestPaid);
	}
	
	public final SimpleStringProperty remainingBalanceProperty() {
		return this.remainingBalance;
	}
	
	public final String getRemainingBalance() {
		return this.remainingBalanceProperty().get();
	}
	
	public final void setRemainingBalance(final String remainingBalance) {
		this.remainingBalanceProperty().set(remainingBalance);
	}
	
	
}
