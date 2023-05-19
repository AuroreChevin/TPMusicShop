package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MusicalGenre {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "musicalGenre")
	private Collection<Album> albums;
	public MusicalGenre() {
	}
	public MusicalGenre(String name) {
		this.name = name;
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
		return "MusicalGenre [id=" + id + ", name=" + name + ", albums=" + albums + "]";
	}
	
}
