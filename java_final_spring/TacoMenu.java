package java_final_spring;

import java.util.ArrayList;
import java.util.List;

import java_final_spring.TacoImpl.Protien;

public class TacoMenu {
	public TacoMenu() {
		menu = new ArrayList<>();
	}
	private List<MenuItem> menu;
	public void addToMenu(int ID, Protien name, double price, boolean special) {
		menu.add(new MenuItem(ID, name, price, special));
	}
	public List<MenuItem> getMenu(){
		return menu;
	}
	public MenuItem getMenuItem(int ID){
		return menu.get(ID);
		
	}
}
