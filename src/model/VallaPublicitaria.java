package model;

import java.io.Serializable;

public class VallaPublicitaria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;
	private String brand;
	private boolean inUse;
	
	public VallaPublicitaria(int width, int height, boolean inUse, String brand)
	{
		this.width=width;
		this.height=height;
		this.inUse=inUse;
		this.brand=brand;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean getInUse() {
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	public String toString()
	{
		String out="";
		out+=String.valueOf(width);
		out+=" | ";
		out+=String.valueOf(height);
		out+=" | ";
		out+=String.valueOf(inUse);
		out+=" | ";
		out+=brand;
		out+="\n";
		return out; 
	}
	
	public String toString2()
	{
		String out="";
		out+="Billboard ";
		out+=brand;
		out+=" area ";
		out+=String.valueOf(height*width);
		out+="\n";
		return out;
	}
	
}
