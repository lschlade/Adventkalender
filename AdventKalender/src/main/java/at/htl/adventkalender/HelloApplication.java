package at.htl.adventkalender;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelloApplication extends Application {
    private final Map<Integer, String> challenges = new HashMap<>();
    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Initialize challenges (questions and image paths)
        initializeChallenges();

        // Create the advent calendar grid
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create 24 buttons (1 for each day)
        for (int day = 1; day <= 24; day++) {
            Button doorButton = new Button("Tag " + day);
            doorButton.setPrefSize(100, 100);

            final int dayFinal = day;
            doorButton.setOnAction(e -> openDoor(dayFinal, doorButton));

            // Add buttons to the grid
            gridPane.add(doorButton, (day - 1) % 6, (day - 1) / 6);
        }

        // Create the scene and show it
        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setTitle("Adventkalender");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openDoor(int day, Button doorButton) {
        if (challenges.containsKey(day)) {
            String content = challenges.get(day);

            if (content.endsWith(".png") || content.endsWith(".jpg")) {
                // Show image
                ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(content)));
                imageView.setFitWidth(400);
                imageView.setFitHeight(300);
                imageView.setPreserveRatio(true);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Bild des Tages");
                alert.setHeaderText("Tag " + day);
                alert.getDialogPane().setContent(imageView);
                alert.showAndWait();
            } else {
                // Show riddle
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("IT Rätsel");
                alert.setHeaderText("Tag " + day);
                alert.setContentText(content);
                alert.showAndWait();
            }

            // Disable button after use
            doorButton.setDisable(true);
        }
    }

    private void initializeChallenges() {
        // Add IT riddles
        challenges.put(1, "Was ist das Resultat von 1 + 1 in der IT?");
        challenges.put(2, "Wie viele Bits hat ein Byte?");
        challenges.put(3, "Was bedeutet 'null' in Java?");
        challenges.put(4, "Was ist die Hauptaufgabe einer CPU?");
        challenges.put(5, "Erkläre den Unterschied zwischen RAM und ROM.");
        challenges.put(6, "Was ist ein Framework?");
        challenges.put(7, "/images/img1.jpg");
        challenges.put(8, "/images/img2.jpg");
        challenges.put(9, "Was macht DHCP?");
        challenges.put(10, "Was ist ein Algorithmus?");
        challenges.put(11, "Was bedeutet HTTP?");
        challenges.put(12, "Was ist der Unterschied zwischen einer Compiler- und einer Interpretersprache?");
        challenges.put(13, "Welche Programmiersprache wird oft für maschinelles Lernen verwendet?");
        challenges.put(14, "Was ist die Funktion einer Datenbank?");
        challenges.put(15, "Was versteht man unter einem 'Stack Overflow'?");
        challenges.put(16, "Was ist die Hauptaufgabe eines Betriebssystems?");
        challenges.put(17, "Was bedeutet 'Open Source'?");
        challenges.put(18, "Was ist ein IP-Adresse?");
        challenges.put(19, "Wie lautet die Basis des binären Systems?");
        challenges.put(20, "Was ist ein 'Bug' in der Programmierung?");
        challenges.put(21, "Wofür steht die Abkürzung 'IDE'?");
        challenges.put(22, "Was ist ein JSON-Objekt?");
        challenges.put(23, "Was ist eine Schleife (Loop) in der Programmierung?");
        challenges.put(24, "Was ist ein 'Git Repository'?");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
