package POC.theatre;

public class TheatreFactory {

    public static Theatre getTheatre(Integer numberOfScreens,String theatreType,boolean threeD){
        if(threeD){
            return new Imax(theatreType,numberOfScreens,threeD);
        }else {
            return new Regular(theatreType,numberOfScreens);
        }
    }
}
