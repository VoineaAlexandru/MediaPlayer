package MediaPlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAOMySQL_Impl implements SongDAO {
	 public static final String CONNECTION_URL = "jdbc:mysql://localhost/mediaplayer_db?autoReconnect=true&useSSL=false";

		public void addSong(Song song)
		{
			try
			{
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("insert into song(Title, Artist, Duration, URL) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, song.getTitle());
				ps.setString(2, song.getArtist());
				ps.setInt(3, song.getDuration());
				ps.setString(4, song.getURL());
				int affectedRows = ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next())
				{
					song.setIdSong(rs.getInt(1));
					
				closeConnection(conn);
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}


		public boolean delete(int id)
		{
			try
			{
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("delete from song where idSong = ?");
				ps.setInt(1, id);
				int affectedRows = ps.executeUpdate();
				closeConnection(conn);
				return affectedRows == 1;
			}
			catch(SQLException s)
			{
				return false;
			}
		}

		public Song findById(int id)
		{
			Song song = null;
			try
			{
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from song where idSong = ?");
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					int id2 = rs.getInt("idSong");
					String Title= rs.getString("Title");
					String Artist= rs.getString("Artist");
					int Duration= rs.getInt("Duration");
					String URL = rs.getString("URL");
					song = new Song(id2, Title, Artist, Duration, URL);
					}
				closeConnection(conn);
				return song;
				
				
			}
			catch(SQLException s)
			{
				return null;
			}
		}

		public Song[] getAllSongs()
		{
			try
			{
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from song");
				ResultSet rs = ps.executeQuery();
				List<Song> songsList = new ArrayList<Song>();
				while(rs.next())
				{
					int id2 = rs.getInt("idSong");
					String Title= rs.getString("Title");
					String Artist= rs.getString("Artist");
					int Duration= rs.getInt("Duration");
					String URL = rs.getString("URL");
					
					songsList.add(new Song(id2, Title, Artist, Duration, URL));
				}
				closeConnection(conn);
				return songsList.toArray(new Song[songsList.size()]);
			}
			catch(SQLException s)
			{
				return null;
			}
		}
		
		public Connection getConnection() throws SQLException
		{
			return DriverManager.getConnection(CONNECTION_URL, "root", "Alexalex98");
		}
		
		public void closeConnection(Connection conn) throws SQLException
		{
			conn.close();
		}
}
