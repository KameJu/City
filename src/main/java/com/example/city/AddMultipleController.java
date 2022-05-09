package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.city.CitiesStorage.getInstance;

public class AddMultipleController implements Initializable {

    @FXML
    private Spinner<Integer> quantity;
    @FXML
    private Spinner<Integer> onPosition;
    @FXML
    private RadioButton start;
    @FXML
    private RadioButton position;
    @FXML
    private RadioButton end;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 0));
        onPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, getInstance().size(), 0));
    }

    @FXML
    private void submit() {
        if (start.isSelected() || position.isSelected() || end.isSelected()) {
            var list = new ArrayList<City>();

            //TODO add random cities
            for (int i = 0; i < quantity.getValue(); i++) {
                list.add(new City("Киев", "Украина", 1F, 1F, (byte) 1, 200, true, 1950, false, "Пупкин Иван Васильевич"));
            }

            int index = defineIndex();

            getInstance().addAll(index, list);

            getStage().close();
        }
    }

    @FXML
    private void cancel() {
        getStage().close();
    }


    @FXML
    private void startAction() {
        position.setSelected(false);
        end.setSelected(false);
        setOnPositionActivator();
    }

    @FXML
    private void positionAction() {
        start.setSelected(false);
        end.setSelected(false);
        setOnPositionActivator();
    }

    @FXML
    private void endAction() {
        start.setSelected(false);
        position.setSelected(false);
        setOnPositionActivator();
    }

    private void setOnPositionActivator() {
        onPosition.setDisable(!position.isSelected());
    }

    private Stage getStage() {
        return (Stage) quantity.getScene().getWindow();
    }

    private int defineIndex() {
        if (start.isSelected()) {
            return 0;
        }
        if (position.isSelected()) {
            return onPosition.getValue();
        }
        return getInstance().size();
    }


}
