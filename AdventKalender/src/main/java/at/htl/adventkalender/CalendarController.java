package at.htl.adventkalender;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CalendarController {

    @FXML
    private GridPane gridPane;

    private final Map<Integer, String> challenges = new HashMap<>();
    private final Random random = new Random();

    @FXML
    public void initialize() {
        // Herausforderungen initialisieren
        initializeChallenges();

        // Dynamische Erstellung der Buttons für 24 Tage
        for (int day = 1; day <= 24; day++) {
            Button button = new Button("Tag " + day);
            button.setPrefSize(100, 100);

            final int dayFinal = day;
            button.setOnAction(e -> openDoor(dayFinal, button));

            // Button in das GridPane einfügen
            gridPane.add(button, (day - 1) % 6, (day - 1) / 6);
        }
    }

    private void openDoor(int day, Button button) {
        if (challenges.containsKey(day)) {
            String content = challenges.get(day);

            if (content.endsWith(".png") || content.endsWith(".jpg")) {
                // Zeige ein Bild an
                ImageView imageView = new ImageView(new Image(content));
                imageView.setFitWidth(400);
                imageView.setFitHeight(300);
                imageView.setPreserveRatio(true);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bild des Tages");
                alert.setHeaderText("Tag " + day);
                alert.getDialogPane().setContent(imageView);
                alert.showAndWait();
            } else {
                // Zeige ein Rätsel an
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("IT Rätsel");
                alert.setHeaderText("Tag " + day);
                alert.setContentText(content);
                alert.showAndWait();
            }

            // Button deaktivieren
            button.setDisable(true);
        }
    }

    private void initializeChallenges() {
        // IT-Rätsel
        challenges.put(1, "Was ist das Resultat von 1 + 1 in der IT?");
        challenges.put(2, "Wie viele Bits hat ein Byte?");
        challenges.put(3, "Was bedeutet 'null' in Java?");
        challenges.put(4, "Was ist die Hauptaufgabe einer CPU?");
        challenges.put(5, "Erkläre den Unterschied zwischen RAM und ROM.");
        challenges.put(6, "Was ist ein Framework?");

        // Bilder (im Ordner `resources/adventcalendar/images/`)
        challenges.put(7, "/adventcalendar/images/snowflake.png");
        challenges.put(8, "/adventcalendar/images/christmas_tree.png");
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
}
