package fr.fms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.fms.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
	//public List<Album> findAll();
	@Transactional
	@Modifying
	@Query("update Album a set a.albumName = ?2 , a.bandName = ?3, a.releaseYear = ?4, a.price = ?5 where a.id = ?1")
	public boolean updateAlbumById(Long id, String albumName, String bandName, int releaseYear, double price);
	 
	public List<Album> findByMusicGenreId(Long Id);
}
