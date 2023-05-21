package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MusicGenre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "musicGenre")
	private Collection<Album> albums;
	public static final int MAX_STRING_LENGTH = 30;
	public MusicGenre() {
	}
	
	public MusicGenre(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public MusicGenre(String name) {
		this.name = name;
	}
	
	public MusicGenre(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(Collection<Album> albums) {
		this.albums = albums;
	}
	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(name);
	}
	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                              ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
}
