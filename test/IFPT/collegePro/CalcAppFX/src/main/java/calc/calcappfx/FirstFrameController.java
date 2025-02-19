package calc.calcappfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstFrameController {

    @FXML
    private Button calbtn1, calbtn2;

    @FXML
    private Button lifeinsurancebtn;
    public void loadSIPCalculator() {
        try {
            mainApp.changePage("sip-calculator.fxml", "SIP Calculator");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadTaxCalculator() {
        try {
            mainApp.changePage("tax-calculator.fxml", "Income Tax Calculator");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // This method will be triggered when the button is clicked
    public void loadinsurance() {
        try {

            mainApp.changePage("lifeInsurance.fxml","Life Insurance Calculator");
//            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadsip(){
        try{
           // mainApp.changePage("Sip.fxml","Life Insurance Calculator");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void openAssetAllocation() throws IOException {
        mainApp.changePage("asset-allocation-view.fxml", "Asset Allocation");
    }

    public void loadmutual(){
        try{
            mainApp.changePage("Sip.fxml","Life Insurance Calculator");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}