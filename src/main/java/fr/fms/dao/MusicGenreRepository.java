package fr.fms.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.fms.entities.MusicGenre;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, Long>{
	@Transactional
	@Modifying
	@Query("update MusicGenre m set m.name = ?2 where m.id = ?1")
	public int updateMusicGenreById(Long id, String name);
	
}
