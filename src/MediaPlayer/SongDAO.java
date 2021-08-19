package MediaPlayer;
import java.util.List;
public interface SongDAO {
	public void addSong(Song s);
	
	public boolean delete(int id);
	public Song findById(int id);
	public Song[] getAllSongs();
}
