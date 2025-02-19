package calc.calcappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class TaxController {

    @FXML
    private TextField salaryField, deductionsField;
    @FXML
    private Label oldRegimeTaxLabel, newRegimeTaxLabel;
    @FXML
    private Button calculateButton, backButton;

    @FXML
    private void calculateTax() {
        try {
            // Get user input
            double salary = Double.parseDouble(salaryField.getText());
            double deductions = Double.parseDouble(deductionsField.getText());

            // Calculate tax for both regimes
            double oldRegimeTax = calculateOldRegimeTax(salary, deductions);
            double newRegimeTax = calculateNewRegimeTax(salary);

            // Display results
            oldRegimeTaxLabel.setText(String.format("₹ %.2f", oldRegimeTax));
            newRegimeTaxLabel.setText(String.format("₹ %.2f", newRegimeTax));

        } catch (NumberFormatException e) {
            oldRegimeTaxLabel.setText("Invalid input!");
            newRegimeTaxLabel.setText("");
        }
    }

    private double calculateOldRegimeTax(double salary, double deductions) {
        double taxableIncome = salary - deductions;
        return computeOldRegimeTax(taxableIncome);
    }

    private double calculateNewRegimeTax(double salary) {
        return computeNewRegimeTax(salary);
    }

    private double computeOldRegimeTax(double income) {
        if (income <= 250000) return 0;
        else if (income <= 500000) return (income - 250000) * 0.05;
        else if (income <= 1000000) return 12500 + (income - 500000) * 0.2;
        else return 112500 + (income - 1000000) * 0.3;
    }

    private double computeNewRegimeTax(double income) {
        if (income <= 300000) return 0;
        else if (income <= 600000) return (income - 300000) * 0.05;
        else if (income <= 900000) return 15000 + (income - 600000) * 0.1;
        else if (income <= 1200000) return 45000 + (income - 900000) * 0.15;
        else if (income <= 1500000) return 90000 + (income - 1200000) * 0.2;
        else return 150000 + (income - 1500000) * 0.3;
    }

    @FXML
    private void backToMain() throws IOException {
        mainApp.changePage("first-frame.fxml", "Calculators");
    }
}
