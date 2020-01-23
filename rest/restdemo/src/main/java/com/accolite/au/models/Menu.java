package com.accolite.au.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Menu {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, MenuItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, MenuItem> items) {
		this.items = items;
	}
	private int id;
	private String name;
	private Map<Integer,MenuItem> items=new HashMap<Integer,MenuItem>();
	
	public MenuItem getItem(int id)
	{
		return items.get(id);
	}
	
	public void addItem(int id,MenuItem item)
	{
		items.put(id, item);
	}
	
	public void removeItem(int id) {
		items.remove(id);
	}
}
