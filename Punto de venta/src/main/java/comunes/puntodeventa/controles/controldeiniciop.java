import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controldeiniciop extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/sample.fxml"));
        Scene scene = new Scene(loader.load());

        // Cargar la imagen en el ImageView
        ImageView imageView = (ImageView) scene.lookup("#posImage");
        imageView.setImage(new Image("../Punto de venta/Recursos/imagenes/tl.webp"));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Punto de Venta");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
