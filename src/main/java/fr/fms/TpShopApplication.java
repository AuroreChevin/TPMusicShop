package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.AlbumRepository;
import fr.fms.dao.MusicGenreRepository;
import fr.fms.entities.Album;
import fr.fms.entities.MusicGenre;

@SpringBootApplication
public class TpShopApplication implements CommandLineRunner{
	@Autowired
	private IBusinessImpl business;
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
		//displayAlbums();
		//displayMusicGenres();
		//displayArticlesByMusicGenreId();
		//business.createAlbum(new Album("Crack the sky", "Mastodon", 2009, 16, new MusicGenre("Sludge/Stoner Metal")));
		Album album = business.readOneAlbum((long) 5);
		System.out.println(album);
		//displayAlbums();
	}
	
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
	 * Méthode qui affiche tous les Albums en base en centrant le texte 
	 */
	public void displayAlbums() {
		System.out.println();
		System.out.println(TEXT_GREEN + Album.centerString(COLUMN_ID) + Album.centerString(COLUMN_ALBUMNAME) + Album.centerString(COLUMN_BANDNAME) 
		+ Album.centerString(COLUMN_RELEASEYEAR)+Album.centerString(COLUMN_PRICE)+Album.centerString(COLUMN_NAME));
		business.readAllAlbums().forEach(System.out::println);
		System.out.println(TEXT_RESET);
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
			System.out.printf(TEXT_RED+"                                                 AFFICHAGE PAR CATEGORIE %n");
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
	 * Méthode pour les différents choix menu
	 */
	/*public void choice() {
		int choice = 0;
		while(choice != 6) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : displayAlbums();				
					break;					
				case 2 : removeArticle();
					break;					
				case 3 : displayMusicGenres();
					break;					
				case 4 : displayArticlesByMusicGenreId();
					break;						
				case 5 : displayCategories();
					break;
				case 6 : displayArticlesByCategoryId();
					break;
				case 7 : connection();
					break;
				case 8 : System.out.println("à bientôt dans notre boutique :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
		}
	}*/
}
