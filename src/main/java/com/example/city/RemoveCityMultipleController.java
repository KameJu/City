package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.city.CitiesStorage.getInstance;

public class RemoveCityMultipleController implements Initializable {

    @FXML
    private Spinner<Integer> from;
    @FXML
    private Spinner<Integer> to;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        from.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, getInstance().size(), 1));
        to.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, getInstance().size(), 2));
    }

    @FXML
    private void submit() {
        getInstance().remove(from.getValue() - 1, to.getValue());

        getStage().close();
    }

    @FXML
    private void cancel() {
        getStage().close();
    }

    private Stage getStage() {
        return (Stage) from.getScene().getWindow();
    }
}
