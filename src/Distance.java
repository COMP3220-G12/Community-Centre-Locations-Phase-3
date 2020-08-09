//This class is designed to display between the user and the nearest community centres using latitude and longitude.
//It maintains high cohesion since it only contains elements related to computing distance.
import java.util.ArrayList;

public class Distance {
    private double lat1;
    private double lon1;
    private ArrayList<Record> cCentres;

    //overloaded constructor to set values
    public Distance(double lat1, double lon1, ArrayList<Record> cCentres)
    {
        this.lat1 = lat1;
        this.lon1 = lon1;
        this.cCentres = cCentres;
    }

    //create a list for the nearest community centres
    public ArrayList<Record> near()
    {
        int count = 0;
        ArrayList<Record> closest = new ArrayList<>();
        System.out.println("Community Centres that are 5km or less to your location are: ");
        for(Record i: cCentres)
        {
            //latitude and longitude for each centre
            double lat2 = Double.parseDouble(i.getValue(4));
            double lon2 = Double.parseDouble(i.getValue(3));
            ;
            //distance
            double dist = calcDist(lat2, lon2, cCentres);
            if(dist<=5)
            {
                System.out.println(i + ", Distance: " + dist + " km");
                closest.add(i);
            }
        }
        return closest;
    }

    //calculate distances
    //Formula for Lat/Long distance is referenced from https://www.geodatasource.com/developers/java?fbclid=IwAR3vPYGFqOiHUhB-GdtmO-7QYNmrsOLhgVwroIGV8HK0pKznrqNCkj6wiFY
    public double calcDist(double lat2, double lon2, ArrayList<Record> cCentres)
    {
        double dist = 0;
        if (lat1==lat2 && lon1==lon2)
            dist = 0;
        else {
            double theta = lon1 - lon2;
            dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;     //km
        }
        return (dist);
    }

}
