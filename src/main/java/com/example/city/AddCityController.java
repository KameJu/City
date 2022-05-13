package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.city.CitiesStorage.getInstance;
import static java.lang.Float.parseFloat;

public class AddCityController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField country;
    @FXML
    private TextField latitudeCoordinate;
    @FXML
    private TextField longitudeCoordinate;
    @FXML
    private CheckBox districtCenter;
    @FXML
    private CheckBox regionalCenter;
    @FXML
    private CheckBox capital;
    @FXML
    private Spinner<Integer> citizenCount;
    @FXML
    private RadioButton isSeaside;
    @FXML
    private Spinner<Integer> creationYear;
    @FXML
    private RadioButton isHaveRiver;
    @FXML
    private TextField fullNameOfMayor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        citizenCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 0));
        creationYear.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(200, Integer.MAX_VALUE, 0));
    }

    @FXML
    private void submit() {
        if (allComplete()) {
            getInstance().add(new City(
                    name.getCharacters().toString(),
                    country.getCharacters().toString(),
                    parseFloat(latitudeCoordinate.getCharacters().toString()),
                    parseFloat(longitudeCoordinate.getCharacters().toString()),
                    getStatus(),
                    citizenCount.getValue(),
                    isSeaside.isSelected(),
                    creationYear.getValue(),
                    isHaveRiver.isSelected(),
                    fullNameOfMayor.getCharacters().toString()
            ));
            getStage().close();
        }
    }

    @FXML
    private void cancel() {
        getStage().close();
    }

    //проверка на то все ли поля заполнены
    private boolean allComplete() {
        if (name == null || name.getCharacters().isEmpty()) {
            return false;
        }
        if (country == null || country.getCharacters().isEmpty()) {
            return false;
        }
        if (latitudeCoordinate == null ||
                latitudeCoordinate.getCharacters().isEmpty() ||
                !latitudeCoordinate.getCharacters().toString().matches("\\d+")
        ) {
            return false;
        }
        if (longitudeCoordinate == null ||
                longitudeCoordinate.getCharacters().isEmpty() ||
                !longitudeCoordinate.getCharacters().toString().matches("\\d+")
        ) {
            return false;
        }
        if (!districtCenter.isSelected() && !capital.isSelected() && !regionalCenter.isSelected()) {
            return false;
        }
        return fullNameOfMayor != null && !fullNameOfMayor.getCharacters().isEmpty();
    }

    private Stage getStage() {
        return (Stage) capital.getScene().getWindow();
    }

    private byte getStatus() {
        if(capital.isSelected())
            return 1;
        if(regionalCenter.isSelected())
            return 2;
        return 3;
    }

    @FXML
    private void districtAction() {
        regionalCenter.setSelected(false);
        capital.setSelected(false);
    }

    @FXML
    private void regionalAction() {
        districtCenter.setSelected(false);
        capital.setSelected(false);
    }

    @FXML
    private void capitalAction() {
        districtCenter.setSelected(false);
        regionalCenter.setSelected(false);
    }


}
