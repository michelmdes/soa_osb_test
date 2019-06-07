package com.opah.apihoteis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opah.apihoteis.consumers.HotelConsumer;
import com.opah.apihoteis.entities.Hotel;
import com.opah.apihoteis.entities.Room;
import com.opah.apihoteis.utils.Util;

/**
 * Contem as regras de negocio de Hotel
 * @author Michel Mendes 	07/06/2019
 */
@Component
public class HotelService {
	
	@Autowired
	HotelConsumer hotelConsumer;
	
	public List<Hotel> findByCityCode(Long idCity, String dtCheckin, String dtCheckout, Integer nmAdult, Integer nmChild) {
		List<Hotel> hotelList = hotelConsumer.findByIdCity(idCity);
		Integer nmDays = Util.diferencaEmDias(dtCheckin, dtCheckout, "dd/MM/yyyy");
		
		// Setando a quantidade de dias para cada room, e a entidade calcula o totalPrice
		if (hotelList != null) {
			for (Hotel hotel : hotelList) {
				if (hotel != null && hotel.getRooms() != null && !hotel.getRooms().isEmpty()) {
					for (Room room : hotel.getRooms()) {
						if (room != null) {
							room.setNmDays(nmDays);
							room.setNmAdult(nmAdult);
							room.setNmChild(nmChild);
						}
					}
				}
			}
		}
		
		return hotelList;
	}
	
	public Hotel findById(Long idHotel) {
		Hotel hotel = hotelConsumer.findById(idHotel);
		return hotel;
	}

}
