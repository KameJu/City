package com.example.city;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CityCell extends ListCell<City>{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label id;
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

    private FXMLLoader mLLoader;

    public CityCell() {}


    @Override
    protected void updateItem(City city, boolean empty) {
        super.updateItem(city, empty);

        if(empty || city == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("city_item.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            id.setText(city.getId().toString());
            name.setText(city.getName());
            country.setText(city.getCountry());
            latitudeCoordinate.setText(city.getLatitudeCoordinate().toString());
            longitudeCoordinate.setText(city.getLongitudeCoordinate().toString());
            setStatus(city);
            citizenCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, city.getCitizenCount()));
            isSeaside.setSelected(city.isSeaside());
            creationYear.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(200, Integer.MAX_VALUE, city.getCreationYear()));
            isHaveRiver.setSelected(city.isHaveRiver());
            fullNameOfMayor.setText(city.getFullNameOfMayor());

            setGraphic(anchorPane);
        }

    }

    private void setStatus(City city) {
        if (city.getStatus() == 1) {
            capital.setSelected(true);
        } else if (city.getStatus() == 2) {
            regionalCenter.setSelected(true);
        } else if (city.getStatus() == 3) {
            districtCenter.setSelected(true);
        }
    }
}
