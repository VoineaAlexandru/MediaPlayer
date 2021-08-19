package MediaPlayer;



import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestSong {

	
	
	public static void main(String[] args) {
		SongDAOFactory songDAOFactory = new SongDAOFactory();
		SongDAO sDAO = songDAOFactory.createSongDAO();
		
		
	//	Song s8 = new Song(7, "Venom ", "Eminem", 305, "https://www.youtube.com/watch?v=8CdcCD5V-d8&list=RDXbGs_qK2PQA&index=4");
		
	//	sDAO.addSong(s8);
	//	Song foundSong = sDAO.findById(1);
	//  sDAO.delete(7);
		
   playSongs();
	
	}
	
	
	
	
	
	
	
	
	
	public static void lanseazaURL(int id) {
		
		SongDAOFactory songDAOFactory = new SongDAOFactory();
	    SongDAO sDAO = songDAOFactory.createSongDAO();
		
		Song foundSong = sDAO.findById(id);
//		
	try {
		  Desktop desktop = java.awt.Desktop.getDesktop();
		  URI oURL = new URI(foundSong.getURL());
		  desktop.browse(oURL);
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	
	public static void makePlaylistByArtist(ArrayList<Song> numePlaylist, String numeArtist) {
		
		SongDAOFactory songDAOFactory = new SongDAOFactory();
		SongDAO sDAO = songDAOFactory.createSongDAO();
	
		
		for(int i=0; i<sDAO.getAllSongs().length;i++)
			  if (sDAO.getAllSongs()[i].getArtist().contains(numeArtist))
		numePlaylist.add(sDAO.getAllSongs()[i]);  
		
	}
	
	public static void playSongs() {
		SongDAOFactory songDAOFactory = new SongDAOFactory();
		SongDAO sDAO = songDAOFactory.createSongDAO();
	
		try {
			for( int i=0;i<sDAO.getAllSongs().length;i++)
			{
				lanseazaURL(sDAO.getAllSongs()[i].getIdSong());
	            System.out.println("am trecut pe aici"+i+1);
				Thread.sleep(sDAO.getAllSongs()[i].getDuration() * 1000);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	
	}

}
