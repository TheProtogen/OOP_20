package telapatrica;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tela extends Application {

    public void start(Stage stage) throws Exception {
        Label label = new Label("Meow : ");
        DatePicker dt = new DatePicker(LocalDate.now());
        Label label2 = new Label("Label2 : ");



        Button btn = new Button("Teste");
        btn.addEventFilter(ActionEvent.ANY,
        e -> {
            print();
        });

        dt.relocate(40, 0);
        label.relocate(0, 20);
        btn.relocate(0, 50);

        Pane root = new Pane();
        root.getChildren().addAll(label,label2,btn,dt);

        Scene scene = new Scene(root,400,400);

        stage.setScene(scene);
        stage.show();

    }

    public void print(){
        System.out.println("Meow");
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
