package MediaPlayer;

public class Song {
	private int idSong;
	private String Title;
	private String Artist;
	private int Duration;
	private String URL;
	
	
	public Song()
	{
	}
	
	public Song(int idSong, String Title, String Artist, int Duration, String URL)
	{
		this.idSong = idSong;
		this.Title = Title;
		this.Artist = Artist;
		this.Duration = Duration;
		this.URL = URL;
		
	}

	public int getIdSong() {
		return idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", Title=" + Title + ", Artist=" + Artist + ", Duration=" + Duration
				+ ", URL=" + URL + "]";
	}
	
	
}
