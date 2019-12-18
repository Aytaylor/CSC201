
import java.io.File;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage; 

/*
 * GUI Setup
 */

public class ToDoGui extends Application {
	private final ObservableList<Item> itemData = FXCollections.observableArrayList();
	TableView<Item> table = new TableView<>();
	Label label1 = new Label("No Items");
	Stage mainStage;
	File file;
	
	public void start(Stage mainStage) {
				
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		
		// create a tile pane 
        TilePane tilePane = new TilePane(); 
		
		//tableview Properties
		TableColumn todoColumn = new TableColumn("To-Do");
		TableColumn dateColumn = new TableColumn("Date Created");
		
		//ToDo Column Properties
		table.setItems(itemData);
		todoColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
		todoColumn.setVisible(true);
		
		table.setPlaceholder(new Label ("No Items To Display"));
		todoColumn.prefWidthProperty().bind(table.widthProperty().multiply(.5));;
		
		//Date Column Properties
		dateColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
		dateColumn.setVisible(true);
		dateColumn.prefWidthProperty().bind(table.widthProperty().multiply(.5));
		
		//add columns
		table.getColumns().addAll(todoColumn, dateColumn);
		// create a textfield 
        TextField field1 = new TextField("Enter item"); 
        
        
        //add buttons to remove items
        Button clearListButton = new Button("Clear Entire List");
        Button clearItemButton = new Button("Clear Item");
        Button saveListButton = new Button("Save List");
        clearListButton.setOnAction(e -> clearList());
        clearItemButton.setOnAction(e -> clearItem());
        saveListButton.setOnAction(e -> save());
        
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                itemData.add(new Item(field1.getText()));
            	label1.setText("Number of Items: " + String.valueOf(itemData.size()));
            	field1.clear();
            } 
        };
  
        // when enter is pressed 
        field1.setOnAction(event); 
  
        // add textfield 
        tilePane.getChildren().add(field1); 
        tilePane.getChildren().add(label1); 
        tilePane.getChildren().addAll(clearItemButton, clearListButton, saveListButton);
        // create a scene 
        Scene scene1 = new Scene(vbox); 
        
        // stage properties
        vbox.getChildren().addAll(table, tilePane);
        mainStage.setScene(scene1); 
        mainStage.setTitle("To-Do List");
        mainStage.show(); 
    } 
	
	//clears entire list
	private void clearList() {
		itemData.clear();
		label1.setText("No Items");
	}
	
	//clears selected item
	private void clearItem() {
			table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
			label1.setText("Number of Items: " + String.valueOf(itemData.size())); 
	}
	
	//opens file explorer (Windows OS) and allows you to save a text file.
	private void save() {
		FileChooser explorer = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
		explorer.getExtensionFilters().add(extFilter);
        explorer.setTitle("Save File");
		try {
			file = explorer.showSaveDialog(mainStage);
			if (file != null) {
				PrintWriter pw = new PrintWriter(file);
				for (Item i: itemData) {
					pw.write(i.toString() + System.lineSeparator());
				}
				pw.close();
			}
		}
		catch (Exception e) {
			System.out.println("Unable to save file");
		}
	}
}
