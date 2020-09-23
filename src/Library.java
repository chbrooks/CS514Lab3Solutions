import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class Library {
    ArrayList<Song> songs;
    ArrayList<Album> albums;
    ArrayList<Artist> artists;
    ArrayList<Playlist> playlists;

    public Library() {
        songs = new ArrayList<Song>();
        albums = new ArrayList<Album>();
        artists = new ArrayList<Artist>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }
    /* add setters and getters */

    /*vyou complete this. Return an empty Album if the search fails. If there is more than one match, return the first */
    public Album findAlbum(String name) {
        for (Album a : albums) {
            if (a.name.equals(name)) {
                return a;
            }
        }
        return new Album();
    }

    /* you complete this. Return an empty Artist if the search fails. If there is more than one match, return the first*/
    public Artist findArtist(String name) {
        for (Artist a : artists) {
            if (a.name.equals(name)) {
                return a;
            }
        }
        return new Artist();
    }

    /* you complete this. Return an empty Song if the search fails. If there is more than one match, return the first*/
    public Song findSong(String name, Artist a) {
        for (Song s : songs) {
            if (s.name.equals(name) && s.artist.name.equals(a.name)) {
                return s;
            }
        }
        return new Song();

    }

    /* you complete this. */
    public void add(Entity e) {
        if (e instanceof Artist) {
            artists.add((Artist)e);
        } else if (e instanceof Album) {
            albums.add((Album)e);
        } else if (e instanceof Song) {
            songs.add((Song)e);
        } else {
            System.out.println("Type error!");
        }
    }

    /* you complete this */
    public void delete(Entity e) {
        if (e instanceof Artist) {
            artists.remove((Artist)e);
        } else if (e instanceof Album) {
            albums.remove((Album)e);
        } else if (e instanceof Song) {
            songs.remove((Song)e);
        } else {
            System.out.println("Type error!");
        }


    }

    /* you complete this. Print out the library in a pretty, user-friendly way. */
    public void display() {
        System.out.println("Songs");
        for (Song s : songs) {
            System.out.println(s);
        }
        System.out.println("Albums");
        for (Album a : albums) {
            System.out.println(a);
        }
        System.out.println("Artists");
        for (Artist a1 : artists) {
            System.out.println(a1);
        }
    }

    /* you complete this. Return the first match, using the equals() method to determine if something is a duplicate.
        Return an empty Entity if no match is found.
    */


    public Entity findDuplicate(Entity e) {
        if (e instanceof Artist) {
            Artist a = (Artist) e;
            for (Artist artist : artists) {
                if (artist.equals(a)) {
                    return artist;
                }
            }
        } else if (e instanceof Song) {
            Song s = (Song) e;
            for (Song song : songs) {
                if (song.equals(s)) {
                    return song;
                }
            }
        } else if (e instanceof Album) {
            Album a = (Album) e;
            for (Album album : albums) {
                if (album.equals(a)) {
                    return album;
                }
            }
        }
        return new Entity();

    }

    /* remove trailing comma */
    public String stripPunc(String inString) {
        return inString.substring(0,inString.length() -1);
    }

    /* you complete this. Read from a file that has a CSV format like:
    Song: Help!, The Beatles, 0,
Song: Yellow Submarine, The Beatles, 0,
Album: Help!, The Beatles,Help!,
Artist: The Beatles Songs: Octopus' Garden,Yellow Submarine, Albums: Abbey Road
     */
    public void readFromFile(String f) {
        File infile;
        Scanner sc;
        String buf;
        try {
            infile = new File(f);
            sc = new Scanner(infile);
            while (sc.hasNext()) {
                buf = sc.nextLine();
                if (buf.startsWith("Song:" )) {

                    String[] words = buf.substring(6).split(",");
                    /* check to see if we have this artist */
                    Artist newArtist = findArtist(words[1].strip());
                    if (newArtist.getName().length()== 0) {
                        newArtist = new Artist(words[1].strip());
                        add(newArtist);
                    }
                    /* check to see if we have this song */
                    Song s = findSong(words[0].strip(), newArtist);
                    if (s.getName().length() == 0) {
                        s = new Song(words[0].strip(), "testfile", newArtist, 0, words[2]);
                        add(s);
                    }
                    newArtist.getSongs().add(s);

                } else if (buf.startsWith("Artist: ")) {
                    String artistName = buf.substring(8, buf.indexOf("Songs:")).trim();
                    /* check to see if we have this artist */
                    Artist artist = findArtist(artistName);
                    if (artist.getName().length() == 0) {
                        artist=new Artist(artistName);
                        add(artist);
                    }
                    /* now let's deal with the songs */
                    String songBuffer = buf.substring(buf.indexOf("Songs:") + 6, buf.indexOf("Albums:")).trim();
                    String[] songlist = songBuffer.split(",");
                    for (String songname : songlist) {
                        /* check for this song */
                        Song newSong = findSong(songname, artist);
                        if (newSong.getName().length() == 0) {
                            newSong = new Song(songname, "", artist, 0, "");
                            add(newSong);
                            artist.getSongs().add(newSong);
                        }

                    }
                    /* and now the albums */
                    String albumBuffer = buf.substring(buf.indexOf("Albums:") + 7);
                    String[] albumlist = albumBuffer.split(",");
                    for (String albumName : albumlist) {
                        Album newAlbum = findAlbum(albumName);
                        /* check to see if we have this album */
                        if (newAlbum.getName().length() == 0) {
                            newAlbum = new Album(albumName);
                            add(newAlbum);
                        }
                        artist.getAlbums().add(newAlbum);
                        newAlbum.setArtist(artist);
                    }


                } else if (buf.startsWith("Album: ")) {
                    String[] words = buf.substring(7).split(",");
                    /* let's check to see if we already have this album. */
                    Album a = findAlbum(words[0].strip());
                    if (a.getName().length() == 0) {
                        a = new Album(words[0].strip());
                        add(a);
                    }
                    /* check to see if we have this artist */
                    Artist art = findArtist(words[1].strip());
                    if (art.getName().length() == 0) {
                        art = new Artist(words[1].strip());
                        add(art);
                    }
                    a.setArtist(art);
                    art.getAlbums().add(a);
                    for (int i = 2; i < words.length; i++) {
                        String songTitle = words[i].strip();
                        /* check to see if we have this song */
                        Song s = findSong(songTitle, art);
                        if (s.getName().length() == 0) {
                            s = new Song(songTitle, "", art, 0, "");
                            add(s);
                            art.getSongs().add(s);
                            a.getSongs().add(s);
                        }


                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error reading from file");
            return;
        }

    }

    /* readFromFileSimpler */
    /* this will assume that the file is in the order Songs, Albums, Artists, and that all data is consistent, making it much simpler. */

    public void readFromFileSimpler(String f) {
        File infile;
        Scanner sc;
        String buf;
        try {
            infile = new File(f);
            sc = new Scanner(infile);
            while (sc.hasNext()) {
                buf = sc.nextLine();
                if (buf.startsWith("Song:")) {
                    String[] words = buf.substring(6).split(",");
                    /* check to see if we have this artist */
                    Artist newArtist = findArtist(words[1].strip());
                    if (newArtist.getName().length() == 0) {
                        newArtist = new Artist(words[1].strip());
                        add(newArtist);
                    }
                    Song s = new Song(words[0].strip(), "testfile", newArtist, 0, words[2]);
                    add(s);
                    newArtist.getSongs().add(s);

                } else if (buf.startsWith("Album: ")) {
                    String[] words = buf.substring(7).split(",");
                    Album a = new Album(words[0].strip());
                    add(a);
                    Artist art = findArtist(words[1].strip());
                    a.setArtist(art);
                    art.getAlbums().add(a);
                    for (int i = 2; i < words.length; i++) {
                        String songTitle = words[i].strip();
                        Song s = findSong(songTitle, art);
                        a.getSongs().add(s);
                    }
                } else if (buf.startsWith("Artist: ")) {
                    String artistName = buf.substring(8, buf.indexOf("Songs:")).trim();
                    Artist artist = findArtist(artistName);

                    /* now let's deal with the songs */
                    /* we've already loaded them all, so we can skip this.
                    String songBuffer = buf.substring(buf.indexOf("Songs:") + 6, buf.indexOf("Albums:")).trim();
                    String[] songlist = songBuffer.split(",");
                    for (String songname : songlist) {
                        Song newSong = findSong(songname, artist);
                      artist.getSongs().add(newSong);
                    } */
                    /* and now the albums */
                    String albumBuffer = buf.substring(buf.indexOf("Albums:") + 7);
                    String[] albumlist = albumBuffer.split(",");
                    for (String albumName : albumlist) {
                        Album newAlbum = findAlbum(albumName);
                        artist.getAlbums().add(newAlbum);
                        newAlbum.setArtist(artist);
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file." + e);
        }
    }




    /* write the data out to a file in the exact same format. */
    public void writeToFile(String fname) {
        PrintWriter outfile;
        try {
            outfile = new PrintWriter(fname);
            for (Song s : songs) {
                outfile.println(s.toString());
            }
            for (Album a : albums) {
                outfile.println(a.toString());
            }
            for (Artist a1 : artists) {
                outfile.println(a1.toString());
            }
            outfile.close();
        } catch (IOException e) {
            System.out.println("Unable to open file.");
            return;
        }

    }
}





