package com.opah.apihoteis.consumers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.opah.apihoteis.entities.Hotel;

/**
 * Consomem os servicos relacionados a Hotel do cliente
 * @author Michel Mendes 	07/06/2019
 */
@Component
public class HotelConsumer {
	
	private final String URL_BASE = "https://cvcbackendhotel.herokuapp.com/";
	private final String URL_HOTEL = URL_BASE + "hotels/";
	private final String URL_AVAIL = URL_HOTEL + "avail/";
	
	public List<Hotel> findByIdCity(Long idCity) {
		List<Hotel> hotelList = getForObject(URL_AVAIL+idCity);
		return hotelList;
	}
	
	public Hotel findById(Long idHotel) {
		Hotel hotel = null;
		List<Hotel> hotelList = getForObject(URL_HOTEL+idHotel);
		if (hotelList != null && !hotelList.isEmpty())
			hotel = hotelList.get(0);
		return hotel;
	}
	
	private List<Hotel> getForObject(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Hotel>> response = restTemplate.exchange(
			url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>(){});
		return response.getBody();
	}

}
