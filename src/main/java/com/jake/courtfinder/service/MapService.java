package com.jake.courtfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jake.courtfinder.model.Comment;
import com.jake.courtfinder.model.Map;
import com.jake.courtfinder.repository.CommentRepository;
import com.jake.courtfinder.repository.MapRepository;

@Service
public class MapService {

	@Autowired
	MapRepository mapRepository;
	
	@Autowired
	CommentRepository commentRepository;

	public List<Map> getAllMaps() {
		return mapRepository.findAll();
	}

	public Optional<Map> getMap(int id) {
		return mapRepository.findById(id);
	}

	public List<Comment> getCommentsById(int id) {
		Map map = new Map();
		map.setId(id);
		return commentRepository.findCommentsById(map);
	}
}
