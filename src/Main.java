/** This is the the driver class. it handles the interactions with the user, 
** therefore, by Creator pattern it creates the instance of UserInterface
*/

import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Visualizer data;
        System.out.println("Entering console mode...");
        data = new UserInterface();
        data.displayViewer();
    }
}
