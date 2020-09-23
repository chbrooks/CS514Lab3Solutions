import java.util.ArrayList;

public class Artist extends Entity {
    ArrayList<Song> songs;
    ArrayList<Album> albums;

    /* you complete this */
    public Artist() {
       this("");
    }

    /* you complete this */
    public Artist(String name) {
        super(name);
        songs = new ArrayList<Song>(10);
        albums = new ArrayList<Album>(10);

    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    /* add setters and getters */

    /* you complete this */

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setSongs(ArrayList<Song> inputsongs) {
        songs = inputsongs;
    }

    /* you complete this */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Artist: " + this.name + " Songs: ");
        for (Song s: songs) {
            sb.append(s.name + ",");
        }
        sb.append( " Albums: ");
        for (Album a: albums) {
            sb.append(a.name + ",");
        }
        return sb.toString();
    }

    /* you complete this. Assume that two artists are equal if they have the same name and the same albums. */
    public boolean equals(Artist a) {
        if (this.name == a.name && this.albums.containsAll(a.albums) && a.songs.containsAll(this.albums)) {
            return true;
        } else {
            return false;
        }
    }

}
