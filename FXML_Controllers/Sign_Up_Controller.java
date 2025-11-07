package edu.utsa.cs3443.pandtask_ui_maple.FXML_Controllers;

import edu.utsa.cs3443.pandtask_ui_maple.PandTaskApplication;
import edu.utsa.cs3443.pandtask_ui_maple.controller.AuthController;
import edu.utsa.cs3443.pandtask_ui_maple.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Sign_Up_Controller{

    // --- FXML UI Component Injections ---

    // TextFields
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    // PasswordFields
    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField repeatPasswordField;

    // Interactive Elements
    @FXML
    private Button signUpButton;

    @FXML
    private Hyperlink logInLink;

    // Status/Error Feedback Label
    @FXML
    private Label messageLabel;

    AuthController user;

    public void setUser(AuthController user){
        this.user = user;
    }

    // --- Event Handler Methods ---

    /**
     * Handles the action when the "SIGN UP" button is clicked.
     */
    @FXML
    private void handleSignUpButtonAction(ActionEvent event) throws IOException {
        // 1. Get input values
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String repeatPassword = repeatPasswordField.getText();


        // 2. Perform basic validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) { // -- Check if either of the fields are empty --
            messageLabel.setText("All fields are required.");
            System.err.println("Sign Up Failed: Missing fields.");
            return;
        } else if (user.singUp(name, email, password) == null) { // -- Check if user already exist in the database --
            System.err.println("Error: User already Exist");
            messageLabel.setText( email + " already Exist");
        } else if (password.equals(repeatPassword)){
            try{
                user.singUp(name, email, password); // add new User to database
                String fxmlPath = "layout/home-page.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(PandTaskApplication.class.getResource(fxmlPath));
                Parent mainPage = fxmlLoader.load();
                Scene scene = new Scene(mainPage, 1020, 1020);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("PandTask Calender_home-page");
                stage.setScene(scene);
                Home_Page_Controller controller = fxmlLoader.getController();
                controller.setUser(user);
                stage.show();
            }catch (IOException e) {
                System.err.println("Failed to load the main application scene. Check MainApp.fxml path.");
                e.printStackTrace();
                if (messageLabel != null) {
                    messageLabel.setText("System Error: Could not load main dashboard.");
                }
            }
        }else {
            System.err.println(password + " and " + repeatPassword + "Does not match");
            messageLabel.setText("Password and Repeated Password does not match");
        }
    }

    /**
     * Handles the action when the "Log in" hyperlink is clicked.
     */
    @FXML
    private void handleLogInLinkClick(ActionEvent event) {
        System.out.println("Switching scene to Log In view...");
        try {
            String fxmlPath = "layout/log-in.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(PandTaskApplication.class.getResource(fxmlPath));
            Parent mainPage = fxmlLoader.load();
            Scene scene = new Scene(mainPage, 1020, 1020);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("PandTask Calender Log - In Page");
            stage.setScene(scene);
            Sign_Up_Controller controller = fxmlLoader.getController();
            controller.setUser(user);
            stage.show();
        }
        catch(Exception e) {
            System.err.println("Unable to load a new scene... " + e.getMessage());
            messageLabel.setText("-- Unable to set Scene --");
        }
    }
}
