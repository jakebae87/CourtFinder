package com.jake.courtfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jake.courtfinder.model.Map;
import com.jake.courtfinder.repository.MapRepository;

@Service
public class MapService {
	
	@Autowired
	MapRepository mapRepository;
	
	public List<Map> getAllMaps(){
		return mapRepository.findAll();
	}
}
