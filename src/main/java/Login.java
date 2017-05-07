import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Olechka on 05.05.2017.
 */
public class Login extends Application {

    public static void main(String[] args) throws Exception{
        launch ( args );
    }
    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/autorization.fxml";
        FXMLLoader loader = new FXMLLoader (  );
        Parent root = (Parent) loader.load (getClass ().getResourceAsStream ( fxmlFile ));
        stage.setTitle("Authorization");
        Scene scene = new Scene ( root );
        scene.getStylesheets ().add ( getClass ().getResource ( "fxml/style.css" ).toExternalForm () );
        stage.setScene(scene);
        stage.show();
//        AnchorPane root =new AnchorPane (  );
//        root.setId ( "pane" );
//        Scene scene = new Scene(root, 300, 250);
//        scene.getStylesheets().addAll(this.getClass().getResource("loginStyle.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();
    }
}
