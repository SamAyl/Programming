package POC;

import POC.location.Location;
import POC.movie.Movie;
import POC.theatre.Imax;
import POC.theatre.Regular;
import POC.theatre.TheatreFactory;

public class App {

    public static void main(String[] args) {
        Location loc1 = new Location("USA","SF",1234);

       Imax t1 = (Imax)TheatreFactory.getTheatre(1,"imax",true);
       Movie m1 = new Movie("m1",5,5,5);
       t1.movieList.add(m1);

       Regular t2 = (Regular)TheatreFactory.getTheatre(2,"regular",false);
       Movie m2 = new Movie("m1",2,5,5);
       Movie m3 = new Movie("m3",2,3,3);
       t2.movieList.add(m2);
       t2.movieList.add(m3);

       loc1.theatreList.add(t1);
       loc1.theatreList.add(t2);



    }
}
