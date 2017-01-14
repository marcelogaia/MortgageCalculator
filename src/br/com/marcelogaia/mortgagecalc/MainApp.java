package br.com.marcelogaia.mortgagecalc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage stage;

	@Override
	public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/MainWindow.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root,600, 500);
		
		stage.setTitle("Mortage Calculator");
		stage.setScene(scene);
        
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}
}
