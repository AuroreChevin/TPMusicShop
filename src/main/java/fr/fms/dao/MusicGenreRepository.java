package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.MusicGenre;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long>{
	//public List<MusicGenre> findAll();
	
}
