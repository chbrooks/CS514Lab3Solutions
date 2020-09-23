public class LibraryTester {
    public static void main(String[] args) {
        Library l = new Library();
        Song s1 = new Song("Help!");
        Song s2 = new Song("Yellow Submarine");
        Artist a1 = new Artist("The Beatles");
        Artist a2 = new Artist("The Who");
        a1.getSongs().add(s1);
        a1.getSongs().add(s2);
        s1.artist = a1;
        s2.artist = a1;
        Album alb1 = new Album("Help!");
        alb1.setArtist(a1);
        alb1.getSongs().add(s1);

        l.add(s1);
        l.add(s2);
        l.add(a1);
        l.add(alb1);
        // l.display();
        //l.writeToFile("testfile");
        Library l2 = new Library();
        l2.readFromFileSimpler("test2");
        l2.display();
    }
}
