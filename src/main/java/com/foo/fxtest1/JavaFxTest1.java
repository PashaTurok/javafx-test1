

package com.foo.fxtest1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Pavel
 */
public class JavaFxTest1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var tabPane = new TabPane();
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        primaryStage.setTitle("Hello World!");
        Button button = new Button();
        button.setText("NewTab");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Tab tab = new Tab("New tab");
                var content = new VBox();
                tab.setContent(content);
                var splitPane = new SplitPane();
                VBox.setVgrow(splitPane, Priority.ALWAYS);
                content.getChildren().add(splitPane);
                splitPane.getItems().addAll(new TextArea("One two three"), new TextArea("One two three"));
                tabPane.getTabs().add(tab);
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(tabPane, button);
        var css= this.getClass().getResource("test1.css").toExternalForm();
        var scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
