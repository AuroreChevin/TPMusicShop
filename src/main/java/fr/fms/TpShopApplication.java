package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Album;
import fr.fms.entities.MusicGenre;
import java.util.Scanner;
@SpringBootApplication
public class TpShopApplication implements CommandLineRunner{
	@Autowired
	private IBusinessImpl business;
	private static Scanner scan = new Scanner(System.in);
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_RED = "\033[0;31m"; 
	public static final String TEXT_RESET = "\u001B[0m";
	private static final String COLUMN_ID = "IDENTIFIANT";
	private static final String COLUMN_ALBUMNAME = "TITRE DE L'ALBUM";
	private static final String COLUMN_BANDNAME = "NOM DU GROUPE";
	private static final String COLUMN_RELEASEYEAR = "ANNEE DE SORTIE";
	private static final String COLUMN_PRICE = "PRIX";
	private static final String COLUMN_NAME = "GENRE MUSICAL";
	
	public static void main(String[] args) {
		SpringApplication.run(TpShopApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		// OK generateAlbums();
		displayAlbums();
		//OK displayMusicGenres();
		//OK displayArticlesByMusicGenreId();
		// OK addOneAlbum();
		//OK displayOneAlbum();
		//OK updateOneAlbum();
		//OK removeAlbum();
		//OK addOneMusicGenre();
		//OK displayOneMusicGenre();
		//OK updateOneMusicGenre();
		// NOK removeMusicGenre();;
		
		
	}
	/**
	 * Méthode qui génère les albums dans la table
	 */
	/*private void generateAlbums() {
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
		
		
	}*/
	/**
	 * Méthode qui affiche le menu principale
	 */
	public static void displayMenu() {	
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant");
		System.out.println("1 : Afficher tous les albums en stock");
		System.out.println("2 : ");
		System.out.println("3 : Afficher tous les genres musicaux");
		System.out.println("4 : Afficher tous les albums d'un genre musical");
		System.out.println("5 : Sortir de l'application");
	}
	/**
	 * Méthode pour les différents choix menu
	 */
	public  void choice() {
		int choice = 0;
		while(choice != 6) {
			displayMenu();
			//choice = scanInt();
			switch(choice) {
				case 1 : displayAlbums();				
					break;					
				case 2 : 
					break;					
				case 3 : displayMusicGenres();
					break;					
				case 4 : displayArticlesByMusicGenreId();
					break;
				case 8 : System.out.println("à bientôt dans notre boutique :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
		}
	}
	/**
	 * Méthode qui affiche tous les Albums en base en centrant le texte 
	 */
	public void displayAlbums() {
		
		System.out.println();
		int currentPage = 0;
		int pageSize = 5;
		boolean albumsInBdd = true;
		
		Page<Album> albums = business.paginationAlbums(PageRequest.of(currentPage, pageSize));
		if(albums.getTotalPages() !=0) {
		displayTitles();
		albums.stream().forEach(System.out::println);
		System.out.println(albums.getTotalPages());
		
		}
		else albumsInBdd = false;
		
		//System.out.println(TEXT_RESET);
	}
	public void displayTitles() {
		System.out.println(TEXT_GREEN + Album.centerString(COLUMN_ID) + Album.centerString(COLUMN_ALBUMNAME) + Album.centerString(COLUMN_BANDNAME) 
		+ Album.centerString(COLUMN_RELEASEYEAR)+Album.centerString(COLUMN_PRICE)+Album.centerString(COLUMN_NAME));
	}
	/**
	 * Méthode qui affiche tous les Albums en base en centrant le texte 
	 */
	public void displayMusicGenres() {
		System.out.println();
		System.out.println(TEXT_RED + Album.centerString(COLUMN_ID) + Album.centerString(COLUMN_NAME));
		business.readAllMusicGenre().forEach(System.out::println);
		System.out.println(TEXT_RESET);
	}
	/**
	 * Méthode qui affiche tous les albums par genre musical en utilisant printf
	 */
	private void displayArticlesByMusicGenreId() {
		//System.out.println("saisissez l'id du genre musical concerné");
		//int id = scanInt();
		MusicGenre musicGenre = business.readOneMusicGenre((long) 2);
		if(musicGenre != null) {
			System.out.printf(TEXT_RED+"                                                 AFFICHAGE PAR GENRE MUSICAL %n");
			System.out.printf("                                                 %-10s %n",musicGenre.getName()+TEXT_RESET);
			System.out.printf(TEXT_GREEN+"-----------------------------------------------------------------------------------------------------------------------%n");
			System.out.printf("%-15s | %-30s | %-30s | %-15s | %-15s | %n",COLUMN_ID,COLUMN_ALBUMNAME,COLUMN_BANDNAME,COLUMN_RELEASEYEAR,COLUMN_PRICE);
			System.out.printf("-----------------------------------------------------------------------------------------------------------------------%n");
			business.readAlbumsByMusicGenreId((long) 2).forEach( a -> System.out.printf("%-15s | %-30s | %-30s | %-15s | %-15s |%n",a.getId(),a.getAlbumName(),a.getBandName(), a.getReleaseYear(),a.getPrice()));
			System.out.println(TEXT_RESET);
		}
		else System.out.println("ce genre musical n'existe pas !");
	}
	/**
	 * Méthode pour ajouter un album
	 */
	public void addOneAlbum() {
		Album album = new Album("Crack the sky", "Mastodon", 2009, 16, new MusicGenre((long) 2));
		if(business.createAlbum(album)==true) System.out.println("L'album a été ajouté au stock");
		
	}
	/**
	 * Méthode pour afficher un album 
	 */
	public void displayOneAlbum() {
		Album album = business.readOneAlbum((long) 5);
		System.out.println(album);
	}
	/**
	 * Méthode pour mettre à jour album
	 */
	public void updateOneAlbum() {
		Album album = business.readOneAlbum((long) 5);
		album.setPrice(500);
		if(business.updateAlbum(album)==true) {
			System.out.println("L'album a été mis à jour");
			System.out.println(album);
		}
		
	}
	/**
	 * Méthode pour savoir si suppression album a fonctionné
	 */
	public void removeAlbum() {
		if(business.deleteOneAlbum((long) 1)==true) System.out.println("L'album a été supprimé du stock");
		
	}
	/**
	 * Méthode pour ajouter un genre musical
	 */
	public void addOneMusicGenre() {
		MusicGenre musicGenre = new MusicGenre("Death metal");
		if(business.createMusicGenre(musicGenre)==true) System.out.println("Le genre musical a été ajouté au stock");
		
	}
	/**
	 * Méthode pour afficher un genre musical 
	 */
	public void displayOneMusicGenre() {
		MusicGenre musicGenre = business.readOneMusicGenre((long) 5);
		System.out.println(musicGenre);
	}
	/**
	 * Méthode pour mettre à jour un genre musical
	 */
	public void updateOneMusicGenre() {
		MusicGenre musicGenre = business.readOneMusicGenre((long) 2);
		musicGenre.setName("j");
		if(business.updateMusicGenre(musicGenre)==true) {
			System.out.println("Le genre musical a été mis à jour");
			System.out.println(musicGenre);
		}
		
	}
	/**
	 * Méthode pour savoir si suppression genre musical a fonctionné
	 */
	public void removeMusicGenre() {
		if(business.deleteOneMusicGenre((long) 1)==true) System.out.println("Le genre musical a été supprimé");
	
	}
	public void pagination() {
		
	}
	
}
