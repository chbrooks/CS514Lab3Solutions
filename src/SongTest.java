public class SongTest {
    public static void main(String[] args) {
        Song s1 = new Song("Help!");
        Song s2 = new Song("Yellow Submarine");
        Artist a1 = new Artist("The Beatles");
        Artist a2 = new Artist("The Who");
        a1.getSongs().add(s1);
        a1.getSongs().add(s2);
        s1.artist = a1;
        s2.artist = a1;

        System.out.println(s1);
        System.out.println(s2);

        if (s1.equals(s2)) {
            System.out.println("Songs equal");
        } else {
            System.out.println("Songs not equal");
        }
        Song s3 = new Song("Help!");
        s3.artist = a1;
        System.out.println(a1);
        a1.getSongs().add(s3);
        if (s1.equals(s3)) {
            System.out.println("Songs equal");
        } else {
            System.out.println("Songs not equal");
        }
        a2.getSongs().add(s3);
        if (a1.equals(a2)) {
            System.out.println("Artists equal");
        } else {
            System.out.println("Artists not equal");
        }

        Album alb1 = new Album("Help!");
        alb1.setArtist(a1);
        alb1.getSongs().add(s1);
        System.out.println(alb1);
    }
}
