import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ATMSimulatorGUI extends Application {
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ATM Simulator");

        // Create output area
        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setStyle("-fx-background-color: #303030; -fx-text-fill: white;");

        // Create button panel
        VBox buttonPanel = new VBox(10);
        buttonPanel.setStyle("-fx-background-color: #303030;");
        buttonPanel.setPadding(new Insets(20));
        Button withdrawButton = new Button("Withdraw");
        Button depositButton = new Button("Deposit");
        Button viewBalanceButton = new Button("View Balance");
        buttonPanel.getChildren().addAll(withdrawButton, depositButton, viewBalanceButton);

        // Set actions for buttons
        withdrawButton.setOnAction(e -> handleWithdraw());
        depositButton.setOnAction(e -> handleDeposit());
        viewBalanceButton.setOnAction(e -> handleViewBalance());

        // Create border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(outputArea);
        borderPane.setBottom(buttonPanel);

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleWithdraw() {
        // Add logic for withdraw functionality
        outputArea.appendText("Withdraw selected\n");
    }

    private void handleDeposit() {
        // Add logic for deposit functionality
        outputArea.appendText("Deposit selected\n");
    }

    private void handleViewBalance() {
        // Add logic for view balance functionality
        outputArea.appendText("View balance selected\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
