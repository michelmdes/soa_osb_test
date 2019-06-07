package com.opah.apihoteis.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opah.apihoteis.entities.Hotel;
import com.opah.apihoteis.services.HotelService;

import io.swagger.annotations.ApiOperation;

/**
 * Controladora que contem os endpoints referentes a Hoteis
 * @author Michel Mendes 	07/06/2019
 */
@RestController
@RequestMapping(value = "/hotels")
public class HotelResource {
	
	@Autowired
	HotelService hotelService;
	
	@ApiOperation(
			value="Pesquisar detalhes do Hotel desejado {id}",
			response=Hotel.class, 
			notes="Não tem como calcular o totalPrice, pois nao tenho a <b>quantidade de dias</b>, "
					+ "<b>quantidade de adultos</b> e <b>crianças</b> que ficarão hospedados")
	@GetMapping("/{idHotel}")
	public ResponseEntity<Hotel> findByIdHotel(@PathVariable("idHotel") Long idHotel) {
		return ResponseEntity.ok().body(hotelService.findById(idHotel));
	}

}
