import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Items for the To-Do list
 */
public class Item {
	private StringProperty name;
	private Date date;
	String pattern = "MM-dd--yyyy";
	SimpleDateFormat format = new SimpleDateFormat(pattern);
	
	public Item(String name) {
		this.name = new SimpleStringProperty(name);
		this.date = new Date();
	}
	
	public String getItem() {
		return name.get();
	}
	
	public void setItem(String newName) {
		name.set(newName);
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public String getDate() {
		String d = format.format(this.date);
		return d;
	}
	
	public String toString() {
		String s = this.getItem() + " " + this.getDate();
		return s;
	}
}
