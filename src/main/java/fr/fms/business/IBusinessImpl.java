package fr.fms.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void createTable() {
		MusicGenre mathCore = musicGenreRepository.save(new MusicGenre("Math Core"));
		MusicGenre sludgeMetal = musicGenreRepository.save(new MusicGenre("Sludge/Stoner Metal"));
		MusicGenre trashMetal = musicGenreRepository.save(new MusicGenre("Trash Metal"));
		MusicGenre postMetal = musicGenreRepository.save(new MusicGenre("Post Metal"));
		
		albumRepository.save(new Album("Tocsin", "Year of no light", 2013, 12, postMetal));
		albumRepository.save(new Album("Reign in blood", "Slayer", 1986, 9.99, trashMetal));
		albumRepository.save(new Album("From beale street of oblivion", "Clutch", 2007, 15, sludgeMetal));
		albumRepository.save(new Album("Blues for the red sun", "Kyuss", 1992, 12, sludgeMetal));
		albumRepository.save(new Album("One of us is the killer", "The dillinger escape plan", 2013, 15.6, mathCore));
		albumRepository.save(new Album("Somewhere along the way", "Cult of Luna", 2006, 17, postMetal));
		albumRepository.save(new Album("Burn my eyes", "Machine Head", 1994, 6.5, trashMetal));
		albumRepository.save(new Album("Cowboys from hell", "Pantera", 1990, 8.5, trashMetal));
		albumRepository.save(new Album("The hunter", "Mastodon", 2011, 16.5, sludgeMetal));
		albumRepository.save(new Album("Houdini", "Melvins", 1993, 7, sludgeMetal));
		albumRepository.save(new Album("All we love we leave behind", "Converge", 2012, 15, mathCore));
		albumRepository.save(new Album("Mass IIII", "Amenra", 2008, 20, postMetal));
		albumRepository.save(new Album("Delivrance", "Corrosion of conformity", 1994, 6.99, sludgeMetal));
		albumRepository.save(new Album("Nola", "Down", 1995, 13, sludgeMetal));
		albumRepository.save(new Album("Roots", "Sepultura", 1996, 9.99, trashMetal));
		albumRepository.save(new Album("Station", "Russian Circles", 2008, 19, postMetal));
	}
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
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteOneMusicGenre(Long id) {
		musicGenreRepository.deleteById(id);
		return true;
	}
	
	
}
