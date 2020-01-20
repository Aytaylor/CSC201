import javafx.application.Application;
/*
 * /*
 * CSC201: Final Project - Fall 2019
 * Title: To Do List App
 * Author: Alex Taylor
 * 
 * Description: Simple To-Do list application where you can add individual text items. 
 * Feature List:
 * 	Enter items at text field and date created is added automatically
 * 	Clear selected row button
 * 	Clear entire list button
 * 	Save/Export to text file button. Opens a Windows Explorer window to choose a location
 * 
 * 	Files:
 * 		Item.java
 * 			Contains properties for To-Do list objects and methods
 * 		ToDoGUi
 * 			Contains GUI properties and methods
 * 		ToDoMain.java
 * 			Runs the app
 */
public class ToDoMain {

	public static void main(String[] args) {
		Application.launch(ToDoGui.class, args);
	}

}
