/* This class represents a Song */

import java.security.PublicKey;

public class Song extends Entity {
    String filename;
    Artist artist;
    int timesPlayed;
    String runningTime;

    /* you complete this */
    public Song() {
       this("","",new Artist(),0,"");
    }

    public Song(String title, String filename, Artist artist, int timesPlayed, String runningTime) {
        super(title);
        this.filename = filename;
        this.artist = artist;
        this.timesPlayed = timesPlayed;
        this.runningTime = runningTime;
    }

    public Song(String n) {
        this(n,"",new Artist(), 0, "");
    }

    /* you complete this */


    /* add setters and getters */

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    /* you complete this */
    public String toString() {
        return "Song: " + name +", "  + artist.name + ", " + timesPlayed + ", " + runningTime;
    }

    /* you complete this. Assume that two songs are equal if they have the same name and the same artist. */
    public boolean equals(Song other) {
        if (this.name.equals(other.name) && this.artist.equals(other.artist)) {
            return true;
        } else {
            return false;
        }
    }

}
