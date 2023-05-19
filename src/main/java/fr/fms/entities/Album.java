package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String albumName;
	private String bandName;
	private int releaseYear;
	private double price;
	@ManyToOne
	private MusicalGenre musicalGenre;
	public Album() {
	}
	public Album(String albumName, String bandName, int releaseYear, double price, MusicalGenre musicalGenre) {
		this.albumName = albumName;
		this.bandName = bandName;
		this.releaseYear = releaseYear;
		this.price = price;
		this.musicalGenre = musicalGenre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public MusicalGenre getMusicalGenre() {
		return musicalGenre;
	}
	public void setMusicalGenre(MusicalGenre musicalGenre) {
		this.musicalGenre = musicalGenre;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", albumName=" + albumName + ", bandName=" + bandName + ", releaseYear="
				+ releaseYear + ", price=" + price + ", price="+ musicalGenre.getName() +"]";
	}
	
}
