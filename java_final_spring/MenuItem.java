package java_final_spring;

import java_final_spring.TacoImpl.Protien;

public class MenuItem {
	//Menu item indications by number, name, price, and if it is the special
	public MenuItem(int iD, Protien name, double price, boolean special) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.special = special;
	}
	private int ID;
	private Protien name;
	private double price;
	private boolean special;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Protien getName() {
		return name;
	}
	public void setName(Protien name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (special ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (ID != other.ID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (special != other.special)
			return false;
		return true;
	}
	@Override
	public String toString() {
		//Indicates the special with an asterik (*)
		if(special)
			return "#" + ID + " " + name + " $" + price +" *";
		else
			return "#" + ID + " " + name + " $" + price;
	}
}
