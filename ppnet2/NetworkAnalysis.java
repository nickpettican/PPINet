package PPNet2;
import java.io.*;

// Contains all the mothods
public class NetworkAnalysis {
    
	public static void listAnalysis() throws IOException
	{
		Network.noNodes = 0;
		Network.readFile();
		
		Network na = new Network();
		na.setVisible(true);
					
		//Network.printList();
		//Network.printAvrg();
		//Network.printHighest();
                //Network.printDegreeDist();
	}
        public static void avrgAnalysis() throws IOException
	{
		avrgNetwork.noNodes = 0;
		avrgNetwork.readFile();
		
		avrgNetwork na = new avrgNetwork();
		na.setVisible(true);
	}
        public static void highestAnalysis() throws IOException
	{
		highNetwork.noNodes = 0;
		highNetwork.readFile();
		
		highNetwork na = new highNetwork();
		na.setVisible(true);
	}
        public static void degDistAnalysis() throws IOException
	{
		degDistNetwork.noNodes = 0;
		degDistNetwork.readFile();
		
		degDistNetwork na = new degDistNetwork();
		na.setVisible(true);
	}
}
