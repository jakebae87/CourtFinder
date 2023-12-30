package com.jake.courtfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jake.courtfinder.model.Map;
import com.jake.courtfinder.service.MapService;

@RestController
public class MapApiController {

	@Autowired
	MapService mapService;

	@GetMapping(value = "/allCourt")
	public List<Map> getAllMaps() {
		return mapService.getAllMaps();
	}
}
