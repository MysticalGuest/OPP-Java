package com.main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.text.*;

// event 15.1
public class HandleEvent extends Application {
	private Button btTest1;
	private Button btTest2;
	private TextField tfReaction;
	
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20));
		pane.setHgap(5);
		pane.setVgap(5);
		btTest1 = new Button("Hungry!!");
		BabySitter teacher = new BabySitter();
		btTest1.setOnAction(teacher);
		btTest2 = new Button("Cry!!");
		btTest2.setOnAction(teacher);
		
		tfReaction = new TextField();
		
		pane.getChildren().addAll(btTest1,btTest2,tfReaction);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Kindergarten");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

	class BabySitter implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			//Button  bt = (Button)e.getSource();
			if(e.getSource()==btTest1)
				tfReaction.setText("Baby does not cry!!!");
			if(e.getSource()==btTest2)
				tfReaction.setText("Feed food!!!");
		}
	}

}
