package MediaPlayer;
import java.util.ArrayList;
import java.util.List;
public class SongDAOMemoryImpl {
List<Song> songs;
	
	public SongDAOMemoryImpl()
	{
		songs = new ArrayList<Song>();
	}

	public void addSong(Song s)
	{
		songs.add(s);
	}
	

	public boolean delete(int id)
	{
		for(int i=0;i<songs.size();i++)
			if(songs.get(i).getIdSong()==id)
			{
				songs.remove(i);
				return true;
			}
		return false;
	}
	
	public Song findById(int id)
	{
		for(Song song:songs)
			if(song.getIdSong() == id)
				return song;
		return null;
	}

	public Song[] getAllSongs()
	{
		return songs.toArray(new Song[songs.size()]);
	}
}
