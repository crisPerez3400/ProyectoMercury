package dad.mercury.controllers;

import dad.mercury.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BandejaEntradaController implements Initializable {
    EnviarCorreoController ec;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ec = new EnviarCorreoController();
    }

    public BandejaEntradaController() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bandejaEntradaView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e){
            throw  new RuntimeException();
        }
    }


    @FXML
    private TableColumn<?, ?> asuntoColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableView<?> emailsTable;

    @FXML
    private TableColumn<?, ?> remitenteColumn;


    @FXML
    private BorderPane root;

    @FXML
    void onFiltrarAction(ActionEvent event) {

    }

    @FXML
    void onRedactarAction(ActionEvent event)  {
        App.getRc().getRoot().setCenter(ec.getRoot());
    }

    @FXML
    void onRefreshAction(ActionEvent event) {

    }

    public BorderPane getRoot() {
        return root;
    }


}
