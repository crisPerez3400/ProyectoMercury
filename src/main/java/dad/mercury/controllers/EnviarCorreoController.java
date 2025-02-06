package dad.mercury.controllers;

import dad.mercury.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EnviarCorreoController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public EnviarCorreoController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/enviarCorreoView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TextField asuntoTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private BorderPane root;

    @FXML
    void onEnviarAction(ActionEvent event) {

    }

    @FXML
    void onVolverAction(ActionEvent event) {
        App.getRc().getRoot().setCenter(new BandejaEntradaController().getRoot());
    }



    public BorderPane getRoot() {
        return root;
    }
}
