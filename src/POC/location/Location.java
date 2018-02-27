package POC.location;

import POC.theatre.Theatre;

import java.util.ArrayList;
import java.util.List;

public class Location {

    public int zipCode;
    public String country;
    public String city;

    public List<Theatre> theatreList =  new ArrayList<>();


    public Location(String country,String city,int zipCode){
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }



}
