import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class Album extends Entity {
    ArrayList<Song> songs;
    Artist artist;
    String totalLength;

    /* you complete this */
    public Album() {
        this("");
    }

    /* you complete this */
    public Album(String n, ArrayList<Song> songs, Artist artist, String totalLength) {
        super(n);
        this.songs = songs;
        this.artist = artist;
        this.totalLength = totalLength;
    }

    /* you complete this */
    public Album(String n) {
        super(n);
        songs = new ArrayList<Song>();
        artist = new Artist();
        totalLength = "";

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(String totalLength) {
        this.totalLength = totalLength;
    }

    /* add setters and getters here */

    /* you complete this */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Album: " + this.name + ", " + this.artist.name + ",");
        for (Song s: songs) {
            sb.append(s.name + ",");
        }
        return sb.toString();
    }

    /* you complete this. Assume that two albums are equal if they have the same name and the same artist. */
    public boolean equals(Album other) {
        if (this.name.equals(other.name) && this.artist.equals(other.artist) &&
                this.songs.containsAll(other.songs) && other.songs.containsAll(this.songs)) {
            return true;
        } else {
            return false;
        }
    }
}
