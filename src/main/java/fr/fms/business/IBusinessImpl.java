package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.fms.dao.AlbumRepository;
import fr.fms.dao.MusicGenreRepository;
import fr.fms.entities.Album;
import fr.fms.entities.MusicGenre;
@Service
public class IBusinessImpl implements IBusiness{
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private MusicGenreRepository musicGenreRepository;
	
	
	@Override
	public List<Album> readAllAlbums() {
		return albumRepository.findAll();	
	}

	@Override
	public List<MusicGenre> readAllMusicGenre() {
		return musicGenreRepository.findAll();
	}
	@Override
	public List<Album> readAlbumsByMusicGenreId(Long id) {
		return albumRepository.findByMusicGenreId(id);
	}
	
	@Override
	public boolean createAlbum(Album album) {
		albumRepository.save(album);
		return true;
	}
	@Override
	public Album readOneAlbum(Long id) {
		Album album = albumRepository.findById(id).get();
		return album;
	}
	@Override
	public boolean updateAlbum(Album album) {
		albumRepository.updateAlbumById(album.getId(), album.getAlbumName(), album.getBandName(), album.getReleaseYear(), album.getPrice());
		return true;
	}
	@Override
	public boolean deleteOneAlbum(Long id) {
		albumRepository.deleteById(id);
		return true;
	}
	@Override
	public boolean createMusicGenre(MusicGenre musicGenre) {
		musicGenreRepository.save(musicGenre);
		return true;
	}
	@Override
	public MusicGenre readOneMusicGenre(Long id) {
		MusicGenre musicGenre = musicGenreRepository.findById(id).get();
		return musicGenre;
	}
	@Override
	public boolean updateMusicGenre(MusicGenre musicGenre) {
		musicGenreRepository.updateMusicGenreById(musicGenre.getId(), musicGenre.getName());
		return true;
	}
	@Override
	public boolean deleteOneMusicGenre(Long id) {
		musicGenreRepository.deleteById(id);
		return true;
	}

	@Override
	public Page<Album> paginationAlbums(Pageable pageable) {
		return albumRepository.findAll(pageable);
	}
	
	
	
}
