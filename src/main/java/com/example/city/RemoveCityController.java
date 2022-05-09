package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.city.CitiesStorage.getInstance;

public class RemoveCityController implements Initializable {

    @FXML
    private Spinner<Integer> index;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        index.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, getInstance().size(), 0));
    }

    @FXML
    private void submit() {
        getInstance().remove(index.getValue() -1);

        getStage().close();
    }

    @FXML
    private void cancel() {
        getStage().close();
    }

    private Stage getStage() {
        return (Stage) index.getScene().getWindow();
    }
}
