package com.opah.apihoteis.entities;

import java.io.Serializable;

/**
 * Entidade que representa Price
 * @author Michel Mendes 	07/06/2019
 */
public class Price implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Double commission = new Double(0.7);
	private Double adult;
	private Double child;
	
	public Price() {
		super();
	}
	
	public Price(Double adult, Double child) {
		super();
		this.adult = adult;
		this.child = child;
	}
	
	public Double getPricePerDayAdult() {
		return calculateCommissionAmount(getAdult());
	}
	
	public Double getPricePerDayChild() {
		return calculateCommissionAmount(getChild());
	}
	
	private Double calculateCommissionAmount(Double value) {
		Double pricePerDay = null;
		if (value != null)
			pricePerDay = value / commission;
		return pricePerDay;
	}
	
	private Double getAdult() {
		return adult;
	}
	public void setAdult(Double adult) {
		this.adult = adult;
	}
	private Double getChild() {
		return child;
	}
	public void setChild(Double child) {
		this.child = child;
	}

}
