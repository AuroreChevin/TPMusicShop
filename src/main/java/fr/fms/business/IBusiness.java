package fr.fms.business;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.fms.entities.Album;
import fr.fms.entities.MusicGenre;

public interface IBusiness {
	public List<Album> readAllAlbums();
	public boolean createAlbum(Album album);
	public Album readOneAlbum(Long id);
	public boolean updateAlbum(Album album);
	public boolean deleteOneAlbum(Long id);
	public List<MusicGenre> readAllMusicGenre();
	public boolean createMusicGenre(MusicGenre musicGenre);
	public MusicGenre readOneMusicGenre(Long id);
	public boolean updateMusicGenre(MusicGenre musicGenre);
	public boolean deleteOneMusicGenre(Long id);
	public List<Album> readAlbumsByMusicGenreId(Long id);
	public Page<Album> paginationAlbums(Pageable pageable);
}
