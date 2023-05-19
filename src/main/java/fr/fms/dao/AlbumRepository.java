package fr.fms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	public List<Album> findAll();
}
