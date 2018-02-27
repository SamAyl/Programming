package POC.theatre;

import POC.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Regular extends Theatre {

    public List<Movie> movieList = new ArrayList<>();
    public Regular(String theatreType,Integer numberOfScreens){
        super.numberOfScreens = numberOfScreens;
        super.theatreType = theatreType;
    }
}
