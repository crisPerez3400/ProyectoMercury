package dad.mercury.controllers;

import dad.mercury.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BandejaEntradaController implements Initializable {
    EnviarCorreoController ec;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ec = new EnviarCorreoController();
    }

    public BandejaEntradaController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bandejaEntradaView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException();
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
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Filtrar Correo");
        dialog.setHeaderText("Ingrese el valor para filtrar y seleccione el criterio");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField textField = new TextField();
        textField.setPromptText("Ingrese remitente o asunto");
        grid.add(new Label("Texto de búsqueda:"), 0, 0);
        grid.add(textField, 1, 0);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioRemitente = new RadioButton("Remitente");
        RadioButton radioAsunto = new RadioButton("Asunto");
        radioRemitente.setToggleGroup(toggleGroup);
        radioAsunto.setToggleGroup(toggleGroup);
        radioRemitente.setSelected(true);  // Por defecto, "Remitente" seleccionado

        grid.add(radioRemitente, 0, 1);
        grid.add(radioAsunto, 1, 1);

        dialog.getDialogPane().setContent(grid);

        ButtonType filtrarButton = new ButtonType("Filtrar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(filtrarButton);

        Optional<Void> result = dialog.showAndWait();

        // Verificar si el usuario ha ingresado texto
        if (!textField.getText().isEmpty()) {
            // Verificar qué opción fue seleccionada
            if (radioRemitente.isSelected()) {
                // Filtrar por remitente utilizando el texto ingresado
                filtrarPorRemitente();
            } else if (radioAsunto.isSelected()) {
                // Filtrar por asunto utilizando el texto ingresado
                filtrarPorAsunto();
            }
        } else {
            // Si no se ingresó texto, mostrar un mensaje de advertencia
            Alert emptyAlert = new Alert(Alert.AlertType.WARNING);
            emptyAlert.setTitle("Advertencia");
            emptyAlert.setHeaderText("No se ha ingresado un valor de filtrado");
            emptyAlert.setContentText("Por favor, ingresa un texto para filtrar.");
            emptyAlert.showAndWait();
        }
    }

    private void filtrarPorRemitente() {
        // Insertar logica
        System.out.println("Filtrando por remitente...");
    }

    private void filtrarPorAsunto() {
        // Insertar logica
        System.out.println("Filtrando por asunto...");
    }

    @FXML
    void onRedactarAction(ActionEvent event) {
        App.getRc().getRoot().setCenter(ec.getRoot());
    }

    @FXML
    void onRefreshAction(ActionEvent event) {

    }

    public BorderPane getRoot() {
        return root;
    }


}
