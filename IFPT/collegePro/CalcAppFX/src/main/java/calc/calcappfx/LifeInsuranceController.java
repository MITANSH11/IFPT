package calc.calcappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LifeInsuranceController {
//    @FXML
//    private Button backbutton;

    @FXML
    private TextField ageField;

    @FXML
    private TextField coverageField;

    @FXML
    private TextField termField;

    @FXML
    private Label premiumResultLabel;

    @FXML
    private void calculatePremium(ActionEvent event) {
        try {
            // Get user inputs
            int age = Integer.parseInt(ageField.getText());
            double coverageAmount = Double.parseDouble(coverageField.getText());
            int term = Integer.parseInt(termField.getText());

            // Calculate premium
            double premium = calculatePremium(age, coverageAmount, term);

            // Show result
            premiumResultLabel.setText(String.format("%.2f", premium));
        } catch (NumberFormatException e) {
            premiumResultLabel.setText("Invalid input!");
        }
    }

    @FXML
    private void backtomainpage(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("first-frame.fxml"));
//        Stage stage = mainApp.getMainStage();
//        stage.setScene(new Scene(root));

        mainApp.changePage("first-frame.fxml","Home Page");
    }

    private double calculatePremium(int age, double coverageAmount, int term) {
        double baseRate = 0.05;
        if (age > 50) {
            baseRate += 0.02;
        }
        return (coverageAmount * baseRate) / (term * 12);
    }
}

