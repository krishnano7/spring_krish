package com.spring.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class ItemInfo {

@Id
@GeneratedValue
private int itemid;
	
private String item;

private int price;

private String qty;

private String typeofitem;

public int getItemid() {
	return itemid;
}

public void setItemid(int itemid) {
	this.itemid = itemid;
}

public String getItem() {
	return item;
}

public void setItem(String item) {
	this.item = item;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getQty() {
	return qty;
}

public void setQty(String qty) {
	this.qty = qty;
}

public String getTypeofitem() {
	return typeofitem;
}

public void setTypeofitem(String typeofitem) {
	this.typeofitem = typeofitem;
}

	

}
