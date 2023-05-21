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
	private MusicGenre musicGenre;
	public static final int MAX_STRING_LENGTH = 30;
	public Album() {
	}
	public Album(String albumName, String bandName, int releaseYear, double price, MusicGenre musicGenre) {
		this.albumName = albumName;
		this.bandName = bandName;
		this.releaseYear = releaseYear;
		this.price = price;
		this.musicGenre = musicGenre;
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
	
	public MusicGenre getMusicalGenre() {
		return musicGenre;
	}
	public void setMusicalGenre(MusicGenre musicGenre) {
		this.musicGenre = musicGenre;
	}
	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(albumName) + centerString(bandName) + 
				centerString(String.valueOf(releaseYear)) +centerString(String.valueOf(price)) + 
				centerString(musicGenre.getName());
	}
	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                              ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
}
