import java.util.ArrayList;
import java.util.List;

public class Distance {
    private double lat1;
    private double lon1;
    private List<Centres> cCentres;

    //overloaded constructor to set values
    public Distance(double lat1, double lon1, List<Centres> cCentres)
    {
        this.lat1 = lat1;
        this.lon1 = lon1;
        this.cCentres = cCentres;

    }

    //create a list for the nearest community centres
    public List<Centres> near(List<Centres> cCentres)
    {
        List<Centres> closest = new ArrayList<Centres>();
        for(Centres i: cCentres)
        {
            //latitude and longitude for each centre
            double lat2 = i.getY();
            double lon2 = i.getX();
            //distance
            double dist = calcDist(lat2, lon2, cCentres);
            if(dist<=5)
            {
                Centres near = new Centres(i.getFID(), i.getAddress(), i.getname(), i.getX(), i.getY(), dist);
                closest.add(near);
            }
        }
        return closest;
    }

    //calculate distances
    //Formula for Lat/Long distance is referenced from https://www.geodatasource.com/developers/java?fbclid=IwAR3vPYGFqOiHUhB-GdtmO-7QYNmrsOLhgVwroIGV8HK0pKznrqNCkj6wiFY
    public double calcDist(double lat2, double lon2, List<Centres> cCentres)
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
