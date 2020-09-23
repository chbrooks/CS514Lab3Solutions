## Lab 3: Music Library

Due:  Sept 15, 11:59 pm PST

In this lab, we will develop a tool for helping to manage a music library. We'll focus at this point on representing and working with the metadata.

 Later in the semester, we’ll hook this up to a server, to allow us to stream our music collection. This will also give you some practice with the following concepts:

* Creating a class diagram
* Tracing memory allocation
* Constructing classes and instances
* Using Lists
* Inheritance
* Unit testing
* Reading and writing from a file. 

Rubric: <br>
Complete, correct, conforming to style guides: full points. <br>
Mostly complete, some style errors: -1.<br>
Missing major parts: -2 <br>
Incomplete or not working: no credit. <br>


### setup

Recall from our initial design that we want to be able to:

* Organize our Library by Song, Artist, or Album
* Add or delete songs.
* Find songs by name, album or artist.
* Find duplicate songs
* Create a playlist
* Read and write our library to/from a file

Note: Task 1 and task 2 should be completed in a separate document, which should then be added to your repo. 
If you want to do either task on paper and then take a photo of it (and add that to your repo), that's fine also.

#### Task 1 (4 points)

Complete the class design that we started in class to include a Library and a Playlist class. Indicate any additional isA and hasA relationships.

#### Task 2 (4 points)

Trace by hand the following simplified version of our classes. You can assume that all classes have a default constructor that allocates their members to 0, and empty String, or an empty ArrayList;:

    public class Song {
        String name;
        Artist artist;
        int timesPlayed;
    }
    public class Artist {
        String name;
        ArrayList<Songs> songs;
        ArrayList<Album> albums;
    }
    public class Album {
        String name;
        Artist artist;
        ArrayList<Song> songs;
    }
  
    Song s1, s2, s3;
    Artist a1;
    Album album1, album2;
    s1= new Song();
    s2 = new Song();
    Artist a1 = new Artist();
  
    a1.name = "The Beatles";
    s1.name = "Here Comes The Sun";
    s1.artist = a1;
    a1.songs.add(s1);
    s2.name = "Tomorrow Never Knows";
    s2.artist = a1;
    a1.songs.add(s2);
    s3 = new Song();
    s3.name = "Something";
    s3.artist = a1;
    a1.songs.add(s3);
    album1 = new Album();
    album1.name="Abbey Road";
    album1.songs.add(s1);
    album1.songs.add(s3);
    a1.albums.add(album1);
    album1.name="Revolver";
    album1.songs.add(s2);
    a1.albums.add(album2);

 

#### Task 3 (4 points)

Implement the Song, Artist, Album and Entity classes, including constructors, setters/getters, equals(), and toString();

#### Task 4. (4 points)

Create unit tests for each of these classes. You can test all of the classes within one test program if you like.

#### Task 5. (5 points)

Implement the Library class, completing the constructor, setter/getters and methods findAlbum(), findArtist(), findSong(), add(), delete(), display(), and findDuplicate(); 

Add unit tests for each of these methods.

#### Task 6 (5 points)

Implement the Playlist class. Add setters/getters, and complete the methods add(), remove() and shuffle();
Add unit tests for each of these.

#### Task 7 (4 points)

Complete the readFromFile() and writeToFile() methods in the Library class.





