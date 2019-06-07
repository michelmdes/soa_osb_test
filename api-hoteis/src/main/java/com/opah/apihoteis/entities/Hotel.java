package com.opah.apihoteis.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Entidade que representa Hotel
 * @author Michel Mendes 	07/06/2019
 */
public class Hotel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Long cityCode;
	private String cityName;
	private List<Room> rooms;
	
	public Hotel() {
		super();
	}

	public Hotel(Long id, String name, Long cityCode, String cityName, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.rooms = rooms;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCityCode() {
		return cityCode;
	}
	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
