package calc.calcappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class SipController {

    @FXML
    private TextField monthlyInvestmentField, returnRateField, investmentPeriodField;
    @FXML
    private Label totalInvestmentLabel, estimatedReturnsLabel, totalValueLabel;
    @FXML
    private Button calculateButton, backButton;

    @FXML
    private void calculateSIP() {
        try {
            // Get input values
            double monthlyInvestment = Double.parseDouble(monthlyInvestmentField.getText());
            double annualReturnRate = Double.parseDouble(returnRateField.getText()) / 100; // Convert % to decimal
            double monthlyReturnRate = annualReturnRate / 12;
            int investmentPeriodYears = Integer.parseInt(investmentPeriodField.getText());
            int months = investmentPeriodYears * 12;

            // Total Investment
            double totalInvestment = monthlyInvestment * months;

            // SIP Formula: FV = P × [(1 + r)^n - 1] × (1 + r) / r
            double futureValue = monthlyInvestment * (Math.pow(1 + monthlyReturnRate, months) - 1) * (1 + monthlyReturnRate) / monthlyReturnRate;
            double estimatedReturns = futureValue - totalInvestment;

            // Display results
            totalInvestmentLabel.setText(String.format("₹ %.2f", totalInvestment));
            estimatedReturnsLabel.setText(String.format("₹ %.2f", estimatedReturns));
            totalValueLabel.setText(String.format("₹ %.2f", futureValue));

        } catch (NumberFormatException e) {
            totalInvestmentLabel.setText("Invalid input!");
            estimatedReturnsLabel.setText("");
            totalValueLabel.setText("");
        }
    }

    @FXML
    private void backToMain() throws IOException {
        mainApp.changePage("first-frame.fxml", "Calculators");
    }
}
