package com.opah.apihoteis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opah.apihoteis.entities.Hotel;
import com.opah.apihoteis.services.HotelService;

import io.swagger.annotations.ApiOperation;

/**
 * Controladora que contem os endpoints referentes a Cidade
 * @author Michel Mendes 	07/06/2019
 */
@RestController
@RequestMapping(value = "/cities")
public class CityResource {
	
	@Autowired
	HotelService hotelService;
	
	@ApiOperation(
			value="Pesquisar hoteis na cidade escolhida, calculando o "
					+ "valor total da viagem e adicionando a comissão para cada um dos quartos retornados",
			response=List.class, 
			notes="Essa lista não valida se o hotel tem vaga disponível, retorna todos os hoteis da lista do cliente")
	@GetMapping("/{cityCode}/hotels")
	public ResponseEntity<List<Hotel>> findByCityCode(@PathVariable("cityCode") Long cityCode,
			@RequestParam(value="dtCheckin") String dtCheckin,
			@RequestParam(value="dtCheckout") String dtCheckout,
			@RequestParam(value="nmAdult") Integer nmAdult,
			@RequestParam(value="nmChild") Integer nmChild) {
		List<Hotel> hotelList = hotelService.findByCityCode(cityCode, dtCheckin, dtCheckout, nmAdult, nmChild);
		return ResponseEntity.ok().body(hotelList);
	}

}
