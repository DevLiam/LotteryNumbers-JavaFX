package la.lottery;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import la.lottery.model.LotteryNumbers;
import la.lottery.view.MainViewController;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private AnchorPane mainLayout;
	
	private LotteryNumbers lotteryNumbers = new LotteryNumbers();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Random Lottery Number Generator");
		
		initMainView();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public LotteryNumbers getLotteryNumbers() {
		return this.lotteryNumbers;
	}
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public void initMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
			mainLayout = (AnchorPane) loader.load();
			
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			
			MainViewController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
