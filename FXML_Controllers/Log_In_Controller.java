package edu.utsa.cs3443.pandtask_ui_maple.FXML_Controllers;

import edu.utsa.cs3443.pandtask_ui_maple.PandTaskApplication;
import edu.utsa.cs3443.pandtask_ui_maple.controller.AuthController;
import edu.utsa.cs3443.pandtask_ui_maple.controller.TaskController;
import edu.utsa.cs3443.pandtask_ui_maple.controller.LabelController;
import edu.utsa.cs3443.pandtask_ui_maple.model.User;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Log_In_Controller{
    // -- UI Components --
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox rememberMeCheck;
    @FXML
    private Button LoginButton;
    @FXML
    private Hyperlink signUpLink;
    @FXML
    private Label messageLabel;

    // Controllers instances
    private AuthController authController;
    private TaskController taskController;
    private LabelController labelController;

    // User instance
    AuthController user;

    public void setUser(AuthController user){
        this.user = user;
    }

    // -- Handles the action when Log In Button is clicked --

    @FXML
    public void handleLogInAction(ActionEvent event){
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean rememberMe = rememberMeCheck.isSelected();

        System.out.println(" --- Log In Attempt---");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("RememberMe: " + rememberMe);

        if(email.isEmpty() || password.isEmpty()){
            System.err.println("Error: Email or Password are empty.");
            messageLabel.setText("Email or Password are empty");
            return;
        }else if(user.findUserByEmailRB(email) && user.findUserByPasswordRB(password)){
            System.out.println(" -- Login Successfully --");
            messageLabel.setText("-- Message Label: Log In Successfully --");
            try{
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
        }else{
            System.err.println("Incorrect Email or Password");
            messageLabel.setText("Incorrect Email or Password");
        }
    }

    // -- Handles action when sign up hyperlink is clicked --
    @FXML
    public void handleSwitchToSignUp(ActionEvent event){
        System.out.println("Switching scene to Sign Up view...");
        try {
            String fxmlPath = "layout/sign-up.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(PandTaskApplication.class.getResource(fxmlPath));
            Parent mainPage = fxmlLoader.load();
            Scene scene = new Scene(mainPage, 1020, 1020);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("PandTask Calender Sign - Up Page");
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

    // -- Handles the action when 'remember me' checkbox is clicked --
    @FXML
    public void handleRememberMe(){
        if (rememberMeCheck.isSelected()) {

        } else {

        }
    }

}
