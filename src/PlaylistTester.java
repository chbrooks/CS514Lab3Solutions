public class PlaylistTester {
    public static void main(String[] args) {
        Playlist p1 = new Playlist();
        Song s1 = new Song("Help!");
        Song s2 = new Song("Yellow Submarine");
        Artist a1 = new Artist("The Beatles");
        Artist a2 = new Artist("The Who");
        a1.getSongs().add(s1);
        a1.getSongs().add(s2);
        s1.artist = a1;
        s2.artist = a1;

        p1.add(s1);
        p1.add(s2);
        System.out.println(p1);
        p1.shuffle();
        System.out.println(p1);

    }
}
