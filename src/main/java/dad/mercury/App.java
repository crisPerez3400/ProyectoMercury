package dad.mercury;

import dad.mercury.controllers.BandejaEntradaController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    private static BandejaEntradaController rc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rc = new BandejaEntradaController();

        Scene scene = new Scene(rc.getRoot());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestión correo");
        primaryStage.show();
    }

    public static BandejaEntradaController getRc() {
        return rc;
    }
}
