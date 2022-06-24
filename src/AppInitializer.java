import Util.FactoryConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/LoginForm.fxml"))));
        stage.show();

    //        bye();
    }

    public String hi(){
        Session session = FactoryConfiguration.getInstance().getSession();

        Query query = session.createQuery("SELECT userId FROM User ORDER BY userId DESC");
        List list = query.list();
      //  System.out.println(list);
        session.close();

        String newVersion;

        String version = list.toString();
        int i = (Integer.parseInt(version.substring(1, version.length()))+1);

        if(!list.isEmpty()){
            if (i==100) {
                newVersion = "U0" +  i;
            }else {
                newVersion = "U00" + i;
            }
            return newVersion;

        }else{
            return "U001";
        }
    }

    public void bye(){
        String hi = hi();
        System.out.println(hi);
    }
}
