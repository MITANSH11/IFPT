package calc.calcappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class TaxController {

    @FXML
    private TextField incomeField, deductionField;
    @FXML
    private ComboBox<String> ageCategory;
    @FXML
    private Label taxResultLabel;
    @FXML
    private Button calculateButton, backButton;

    @FXML
    private void calculateTax() {
        try {
// Get input values
            double income = Double.parseDouble(incomeField.getText());
            double deductions = deductionField.getText().isEmpty() ? 0 : Double.parseDouble(deductionField.getText());
            String ageGroup = ageCategory.getValue();

            // Ensure age group is selected
            if (ageGroup == null) {
                taxResultLabel.setText("Select age group!");
                return;
            }

            // Calculate taxable income
            double taxableIncome = income - deductions;
            double tax = 0;

            // Adjust exemption limit based on age group
            double exemptionLimit = 250000; // Default exemption limit
            if (ageGroup.equals("60-80")) {
                exemptionLimit = 300000; // Senior citizens
            } else if (ageGroup.equals("Above 80")) {
                exemptionLimit = 500000; // Super senior citizens
            }

            // Tax calculation based on income after deductions and exemption limit
            if (taxableIncome <= exemptionLimit) {
                tax = 0; // No tax if income is within exemption limit
            } else if (taxableIncome <= 400000) {
                tax = (taxableIncome - exemptionLimit) * 0.05;
            } else if (taxableIncome <= 800000) {
                tax = (400000 * 0.05) + (taxableIncome - 400000) * 0.1;
            } else if (taxableIncome <= 1200000) {
                tax = (400000 * 0.05) + (400000 * 0.1) + (taxableIncome - 800000) * 0.2;
            } else if (taxableIncome <= 1600000) {
                tax = (400000 * 0.05) + (400000 * 0.1) + (400000 * 0.2) + (taxableIncome - 1200000) * 0.3;
            } else {
                tax = (400000 * 0.05) + (400000 * 0.1) + (400000 * 0.2) + (400000 * 0.3) + (taxableIncome - 1600000) * 0.3;
            }

            // Adjust for senior citizen tax benefits (if applicable)
            if (ageGroup.equals("60-80")) {
                if (taxableIncome > 300000) tax -= 5000; // Additional exemption for senior citizens
            } else if (ageGroup.equals("Above 80")) {
                if (taxableIncome > 500000) tax -= 10000; // Additional exemption for super senior citizens
            }

            // Ensure tax is non-negative
            tax = Math.max(tax, 0);

            // Display result
            taxResultLabel.setText(String.format("₹ %.2f", tax));

        } catch (NumberFormatException e) {
            taxResultLabel.setText("Invalid input!");
        }
    }

    @FXML
    private void backToMain() throws IOException {
        mainApp.changePage("first-frame.fxml", "Calculators");
    }
}
