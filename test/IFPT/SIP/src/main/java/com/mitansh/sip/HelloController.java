package com.mitansh.sip;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private TextField investmentAmount, rateOfInterest, tenure, loanAmount, loanRateOfInterest, loanTenure;

    @FXML
    private Label resultLabel;

    @FXML
    private VBox mutualFundsVBox, loanVBox;

    @FXML
    private RadioButton mutualFundsRadioButton, loanRadioButton;

    @FXML
    public void initialize() {
        // Initially show Mutual Funds
        mutualFundsVBox.setVisible(true);
        loanVBox.setVisible(false);
    }

    // Handle the radio button selection
    @FXML
    public void handleRadioButtonSelection() {
        if (mutualFundsRadioButton.isSelected()) {
            mutualFundsVBox.setVisible(true);
            loanVBox.setVisible(false);
        } else if (loanRadioButton.isSelected()) {
            mutualFundsVBox.setVisible(false);
            loanVBox.setVisible(true);
        }
    }

    // Calculate Mutual Funds
    @FXML
    public void calculateMutualFunds() {
        try {
            double amount = Double.parseDouble(investmentAmount.getText());
            double rate = Double.parseDouble(rateOfInterest.getText());
            int months = Integer.parseInt(tenure.getText());

            // Convert annual rate to monthly rate
            double monthlyRate = rate / 12 / 100;

            // Calculate SIP (Monthly investment)
            double monthlySIP = (amount * (Math.pow(1 + monthlyRate, months) - 1)) / (Math.pow(1 + monthlyRate, months) - 1);

            // Calculate Total Investment
            double totalInvestment = monthlySIP * months;

            // Calculate Total Maturity Amount
            double maturityAmount = monthlySIP * (Math.pow(1 + monthlyRate, months) - 1) / monthlyRate * (1 + monthlyRate);

            resultLabel.setText(String.format("Monthly SIP: %.2f\nTotal Investment: %.2f\nMaturity Amount: %.2f", monthlySIP, totalInvestment, maturityAmount));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers for Mutual Funds!");
        }
    }

    // Calculate Loan EMI
    @FXML
    public void calculateLoan() {
        try {
            double loanAmt = Double.parseDouble(loanAmount.getText());
            double rate = Double.parseDouble(loanRateOfInterest.getText());
            int months = Integer.parseInt(loanTenure.getText());

            // Convert annual rate to monthly rate
            double monthlyRate = rate / 12 / 100;

            // Calculate EMI using the formula
            double emi = (loanAmt * monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1);

            resultLabel.setText(String.format("EMI: %.2f\nTotal Loan Repayment: %.2f", emi, emi * months));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers for Loan!");
        }
    }
}