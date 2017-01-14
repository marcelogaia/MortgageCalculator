package br.com.marcelogaia.mortgagecalc.view;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.marcelogaia.mortgagecalc.model.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainWindowController {

	// Input Fields
	@FXML private TextField loanAmountFld;
	@FXML private TextField interestRateFld;
	@FXML private TextField numYearsFld;
	@FXML private TextField numPmtsYearFld;
	@FXML private DatePicker startDateFld;
	
	// Output Fields
	@FXML private TextField scheduledPmtAmount;
	@FXML private TextField totalNumPayments;
	@FXML private TextField totalPayment;
	@FXML private TextField totalInterest;
	@FXML private TextField dateLastPayment;
	
	// The button that makes it work
	@FXML private Button calcBtn;
	
	// The table
	@FXML private TableView<Payment> paymentTable;
	@FXML private TableColumn<Payment, String> pmtNum;
	@FXML private TableColumn<Payment, String> date;
	@FXML private TableColumn<Payment, String> startBalance;
	@FXML private TableColumn<Payment, String> pmtAmount;
	@FXML private TableColumn<Payment, String> capitalPaid;
	@FXML private TableColumn<Payment, String> interestPaid;
	@FXML private TableColumn<Payment, String> remainingBalance;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public MainWindowController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Do all the proper calculations
	 */
	@FXML
	public void handleCalculate() {
		try{
			// Setting the variables and rewriting the proper number in the field.
			double loanAmount = fldToDouble(loanAmountFld);
			loanAmountFld.setText(loanAmount+"");
			
			double interestRate = fldToDouble(interestRateFld) / 100;
			interestRateFld.setText(interestRate*100+"");
			
			int numYears = fldToInt(numYearsFld);
			numYearsFld.setText(numYears+"");
			
			int numPmtsYear = fldToInt(numPmtsYearFld);
			numPmtsYearFld.setText(numPmtsYear+"");
			
			LocalDate startDate = startDateFld.getValue();
			
			// Calculate the field results

			int totalNumPmt = numPmtsYear * numYears;
			totalNumPayments.setText("" + totalNumPmt);
			
			

			double monthlyRate = interestRate / numPmtsYear;
			double scheduledAmt = loanAmount * monthlyRate / (1 - Math.pow(1+monthlyRate, -totalNumPmt) );
			
			scheduledPmtAmount.setText("" + rount2Decimals(scheduledAmt));

			double totalPmt = totalNumPmt * scheduledAmt;
			totalPayment.setText("" + rount2Decimals(totalPmt));
			
			double totalInt = totalPmt - loanAmount;
			totalInterest.setText("" + rount2Decimals(totalInt));
			
			
			LocalDate lastPmt = startDate.plusYears(numYears);
			dateLastPayment.setText("" + lastPmt);
			
			// Filling the table
			fillTable(totalNumPmt);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
	
	private void fillTable(int numPmt) {
		ObservableList<Payment> data = FXCollections.observableArrayList();
		
		// FIXME: Make this work!
		for(int i = 1; i <= numPmt; i++){
			Payment pmt = new Payment(""+i,"1","1","1","1","1","1");
			data.add(pmt);
		}
		
		this.paymentTable.setItems(data);
	}

	private double fldToDouble(TextField fld){
		String fldText = fld.getText();
		if(fldText.equals("")) {
			return 0.0f;
		} else {
			Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?"); // Match int or float
			Matcher matcher = pattern.matcher(fldText);

			if(matcher.find()) {
				return (float) (Math.round(Float.parseFloat(matcher.group()) * 100)) / 100.0f ;
			}
			else {
				return 0.0f;
			}
		}
	}
	
	private double rount2Decimals(double f){
		return (Math.round(f * 100)) / 100.0 ;
	}
	
	private int fldToInt(TextField fld){
		return (int) Math.round(fldToDouble(fld));
	}
	
}
