package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {
	private String text = "";

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Label lblText = new Label("Programming is fun");
		pane.getChildren().add(lblText);
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					while(true) {
//						if(lblText.getText().trim().length() == 0)
//							text = "Welcome";
//						else {
//							text = "";
//						}
//						Platform.runLater(new Runnable() {
//							
//							@Override
//							public void run() {
//								lblText.setText(text);
//							}
//						});
//						
//						Thread.sleep(200);
//					}
//				} catch (Exception e) {
//					// handle exception
//				}
//			}
//		}).start();
		
		//兰巴达表达式
		new Thread(() -> { // lambda expression 
			try {
				while (true) {
					if(lblText.getText().trim().length() == 0)
						text = "welcome";
					else
						text = "";
					
					// lambda exp
					Platform.runLater(() -> lblText.setText(text));
					
					Thread.sleep(200);
				}
				
			} catch (Exception e) {
				// handle exception
			}
		}).start();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setTitle("FlashText");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}
