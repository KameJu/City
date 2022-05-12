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

            for (int i = 0; i < quantity.getValue(); i++) {
                list.add(getRandomCity());
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

    private City getRandomCity() {
        ArrayList<City> cities = new ArrayList<>();

        cities.add(new City("Киев", "Украина", 50.4501F, 30.5234F, (byte) 1, 2954564, false, 430, true, "Кличко Віталій Володимирович"));
        cities.add(new City("Буча", "Украина", 50.5533F, 30.2135F, (byte) 3, 36971, false, 	1630, true, "Федорук Анатолій Петрович"));
        cities.add(new City("Ирпень", "Украина", 50.5188F, 30.2398F, (byte) 3,  60084 , false, 	1899, true, "Карплюк Володимир Андрійович"));
        cities.add(new City("Мелитополь", "Украина", 46.8550F, 35.3587F, (byte) 3, 154839, false, 1784, true, "Фёдоров Иван Сергеевич"));
        cities.add(new City("Херосн", "Украина", 46.6354F, 32.6169F, (byte) 2, 289697, false, 1778, true, "Колихаєв Ігор Вікторович"));
        cities.add(new City("Железный Порт", "Украина", 46.1236F, 32.2913F, (byte) 3, 1528, true, 1922, true, "Колихаєв Ігор Вікторович"));

        return cities.get(rnd(cities.size()));
    }

    public static int rnd(final int max)
    {
        return (int) (Math.random() * max);
    }


}
