package la.lottery.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import la.lottery.MainApp;

public class MainViewController {
	
	private MainApp mainApp;
	
	@FXML
	private Spinner<Integer> numberOfPicksSpinner;
	@FXML
	private Spinner<Integer> numberOfGamesSpinner;
	@FXML
	private Spinner<Integer> maxNumberSpinner;
	@FXML
	private Label outputLabel;

	public MainViewController() {
		
	}
	
	@FXML
	private void initialize() {
		outputLabel.setText("");
		
		SpinnerValueFactory<Integer> svfNOP = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 6);
		numberOfPicksSpinner.setValueFactory(svfNOP);
		
		SpinnerValueFactory<Integer> svfNOG = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 12);
		numberOfGamesSpinner.setValueFactory(svfNOG);
		
		SpinnerValueFactory<Integer> svfMN = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 45);
		maxNumberSpinner.setValueFactory(svfMN);
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleClearOutput() {
		this.mainApp.getLotteryNumbers().clearNumberSelectionString();
		outputLabel.setText(this.mainApp.getLotteryNumbers().getNumberSelectionString());
	}
	
	@FXML
	private void handleGenerateNumbers() {
		System.out.println(maxNumberSpinner.valueProperty().getValue());
		if (isValidParameters()) {
			
			this.mainApp.getLotteryNumbers().setMaxNumber(maxNumberSpinner.getValue());
			this.mainApp.getLotteryNumbers().setNumberOfGames(numberOfGamesSpinner.getValue());
			this.mainApp.getLotteryNumbers().setNumberOfPicks(numberOfPicksSpinner.getValue());
			
			this.mainApp.getLotteryNumbers().generateFullRandomTickets();
			outputLabel.setText(this.mainApp.getLotteryNumbers().getNumberSelectionString());
		}
	}
	
	private boolean isValidParameters() {
		String errorMessage = "";
		
		if (numberOfPicksSpinner.getValue() > 1000)
			errorMessage += "The number of picks must be 1000 or less.\n";
		if (numberOfPicksSpinner.getValue() < 1)
			errorMessage += "The number of picks must be 1 or greater.\n";
		if (numberOfGamesSpinner.getValue() > 1000)
			errorMessage += "The number of games must be 1000 or less.\n";
		if (numberOfGamesSpinner.getValue() < 1)
			errorMessage += "The number of games must be 1 or greater.\n";
		if (maxNumberSpinner.getValue() > 1000)
			errorMessage += "The maximum number must be 100 or less.\n";
		if (maxNumberSpinner.getValue() < 1)
			errorMessage += "The maximum number must be 1 or greater.\n";
		
		if (errorMessage.length() == 0)
			return true;
		else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Error");
			alert.setHeaderText("Please fix the following errors with the chosen parameters: ");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}

}
