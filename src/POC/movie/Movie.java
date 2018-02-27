package POC.movie;

public class Movie {

    String movieName;
    Integer price;
    Integer noOfSeats;
    Integer seatsAvailable;

    public Movie(String movieName,Integer price,Integer noOfSeats,Integer seatsAvailable){
        this.movieName = movieName;
        this.price = price;
        this.noOfSeats = noOfSeats;
        this.seatsAvailable = seatsAvailable;
    }
}
