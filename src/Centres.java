//contains all the fields/attributes of the community centres that are listed in the file
public class Centres
{
    private int FID;
    private String address;
    private String name;
    private double X;
    private double Y;
    private double dist;        //distance between user-entered lat/long and community centres

    //overloaded constructor
    public Centres(int FID, String address, String name, double X, double Y)
    {
        this.FID = FID;
        this.address = address;
        this.name = name;
        this.X = X;
        this.Y = Y;
    }
    //used when distance is calculated
    public Centres(int FID, String address, String name, double X, double Y, double dist)
    {
        this.FID = FID;
        this.address = address;
        this.name = name;
        this.X = X;
        this.Y = Y;
        this.dist = dist;
    }
    //get methods
    public int getFID()
    {
        return FID;
    }
    public String getAddress()
    {
        return address;
    }
    public String getname()
    {
        return name;
    }
    public double getX()
    {
        return X;
    }
    public double getY()
    {
        return Y;
    }
    public double getDist()
    {
        return dist;
    }

    //set methods
    public void setFID(int FID)
    {
        this.FID = FID;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public void setX(double X)
    {
        this.X = X;
    }
    public void setY(double Y)
    {
        this.Y = Y;
    }
    public void setDist(double dist)
    {
        this.dist = dist;
    }

    //override toString
    public String toString()
    {
        return "FID: " + FID + ", Address: " + address + ", Name: " + name + ", X: " + X + ", Y: " + Y;
    }
    //to print out distances
    public void toString2()
    {
        System.out.println("FID: " + FID + ", Address: " + address + ", Name: " + name + ", X: " + X + ", Y: " + Y + ", Distance (in km): " + dist);
    }

}
