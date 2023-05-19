package fr.fms.business;

import java.util.ArrayList;
import java.util.List;

import fr.fms.entities.Album;

public interface IBusiness {
	public List<Album> readAllAlbums();
}
