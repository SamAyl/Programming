package POC.theatre;

import POC.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Imax extends Theatre {

    boolean threeD;
    public List<Movie> movieList = new ArrayList<>();
    public Imax(String theatreType,Integer numberOfScreens,boolean threeD){
        this.threeD = threeD;
        super.numberOfScreens = numberOfScreens;
        super.theatreType = theatreType;
    }


}
