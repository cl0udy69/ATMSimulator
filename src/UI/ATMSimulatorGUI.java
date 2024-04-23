import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ATMSimulatorGUI extends Application {

    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        // Set up the root pane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Create the output area
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setStyle("-fx-control-inner-background: #2b2b2b; -fx-text-fill: white;");
        outputArea.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        root.setCenter(outputArea);

        // Create the button panel
        HBox buttonPanel = new HBox(10);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(10));
        buttonPanel.setStyle("-fx-background-color: #2b2b2b;");

        // Create buttons for actions
        Button withdrawButton = createButton("Withdraw");
        withdrawButton.setOnAction(e -> handleWithdraw());
        Button depositButton = createButton("Deposit");
        depositButton.setOnAction(e -> handleDeposit());
        Button viewBalanceButton = createButton("View Balance");
        viewBalanceButton.setOnAction(e -> handleViewBalance());

        // Add buttons to the button panel
        buttonPanel.getChildren().addAll(withdrawButton, depositButton, viewBalanceButton);
        root.setBottom(buttonPanel);

        // Set up the scene and stage
        Scene scene = new Scene(root, 400, 300);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ATM Simulator");
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: #3b5998; -fx-border-color: #3b5998;");
        return button;
    }

    private void handleWithdraw() {
        outputArea.appendText("Withdraw selected\n");
        // Call your withdraw function here
    }

    private void handleDeposit() {
        outputArea.appendText("Deposit selected\n");
        // Call your deposit function here
    }

    private void handleViewBalance() {
        outputArea.appendText("View balance selected\n");
        // Call your view balance function here
    }

    public static void main(String[] args) {
        launch(args);
    }
}
