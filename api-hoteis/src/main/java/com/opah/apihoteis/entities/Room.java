package com.opah.apihoteis.entities;

import java.io.Serializable;

/**
 * Entidade que representa Room
 * @author Michel Mendes 	07/06/2019
 */
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long roomID;
	private String categoryName;
	private Price price;
	
	// Atributos necessarios para calcular o totalPrice
	private Integer nmDays;
	private Integer nmAdult;
	private Integer nmChild;
	
	
	public Room() {
		super();
	}

	public Room(Long roomID, String categoryName, Price price) {
		super();
		this.roomID = roomID;
		this.categoryName = categoryName;
		this.price = price;
	}
	
	/**
	 * Calcula o totalPrice (valor crianca + adulto/comissao)
	 * @return totalPrice
	 */
	public Double getTotalPrice() {
		Double totalPrice = null;
		if (price != null && nmDays != null && nmAdult != null && nmChild != null) {
			totalPrice = new Double(0);
			if (price.getPricePerDayAdult() != null)
				totalPrice = price.getPricePerDayAdult() * nmAdult;
			if (price.getPricePerDayChild() != null) {
				totalPrice = totalPrice + ( price.getPricePerDayChild() * nmChild );
			}
			totalPrice = totalPrice * nmDays;
		}
		return totalPrice;
	}
	
	public Long getRoomID() {
		return roomID;
	}
	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
//	public Double getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(Double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	public Integer getNmDays() {
		return nmDays;
	}
	public void setNmDays(Integer nmDays) {
		this.nmDays = nmDays;
	}
	public Integer getNmAdult() {
		return nmAdult;
	}
	public void setNmAdult(Integer nmAdult) {
		this.nmAdult = nmAdult;
	}
	public Integer getNmChild() {
		return nmChild;
	}
	public void setNmChild(Integer nmChild) {
		this.nmChild = nmChild;
	}

}
