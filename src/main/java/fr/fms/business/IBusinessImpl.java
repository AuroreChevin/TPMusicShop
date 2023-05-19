package fr.fms.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fms.dao.AlbumRepository;
import fr.fms.entities.Album;
@Service
public class IBusinessImpl implements IBusiness{
	@Autowired
	private AlbumRepository albumRepository;
	
	
	@Override
	public List<Album> readAllAlbums() {
		System.out.println("ok");
		return albumRepository.findAll();	
	}

}
