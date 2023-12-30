package com.jake.courtfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jake.courtfinder.model.Map;

public interface MapRepository extends JpaRepository<Map, Integer>{

}
