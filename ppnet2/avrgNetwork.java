package PPNet2;
import java.io.*;
//import java.net.URL;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JFrame;

public class avrgNetwork extends JFrame {
	// represents full network
	
	static Node[] listOfNodes = new Node[1000];
	public static int noNodes;
	
	private static int[] noDegrees = new int[100];
	
	
        
        
	// has the GUI prints
	public avrgNetwork() {
		setTitle("Average degree of all nodes");
		Container contents = getContentPane();
		contents.setLayout(new GridLayout(0,1));
		JTextArea jt = new JTextArea(20,50);
		contents.add((new JScrollPane(jt)));
		
		for (int j=0; j<100; j++)
		{
			noDegrees[j]= 0;
		}
		int avg = 0;
		int max = -1;
		for (int i=0; i<noNodes; i++)
		{
			int degree = listOfNodes[i].getNoEdges();
			
			if (degree>max)
				max = degree;
			avg += degree;
			noDegrees[degree]++;
		}
		jt.append("Average number of degrees : " + (double)avg / (double)noNodes + "\n");
		
		pack();
	}
	
	private static int checkIfExists(String newName)
	{
		for (int i=0; i<noNodes; i++)
		{
			if (listOfNodes[i].getName().compareTo(newName) == 0)
				return i;
		}
		
		return 0;
	}
	
	public static void readFile() throws IOException
	{
		
	// make method that reads files
	Scanner file = new Scanner(new File("PPInet.txt"));
	//PrintWriter writer = new PrintWriter("output.txt");
	while(file.hasNext()){
		String line = file.nextLine();
		
		int k = 0;
		String pro1 = "", pro2 = "";
		for (String temp: line.split("\t"))
		{
			k++;
			
			if (k == 1)
			{
				pro1 = temp;
			}
			else
			{
				pro2 = temp;
			}
		
		}
		
		int pro1e = checkIfExists(pro1);
		int pro2e = checkIfExists(pro2);
		
		if (pro1e != 0)
		{
			Node pro1n = listOfNodes[pro1e];
			if (pro2e != 0)
			{
				if (pro1n.checkEdge(pro2e) == 0)
					pro1n.addEdge(pro2e);
				
				Node pro2n = listOfNodes[pro2e];
				if (pro2n.checkEdge(pro1e) == 0)
					pro2n.addEdge(pro1e);
			}
			else
			{
				Node pro2n = new Node(pro2, noNodes);
				listOfNodes[noNodes] = pro2n;
				
				pro1n.addEdge(noNodes);
				pro2n.addEdge(pro1e);
				
				noNodes++;
			}
		}
		else
		{
			if (pro2e != 0)
			{
				Node pro1n = new Node(pro1, noNodes);
				listOfNodes[noNodes] = pro1n;
				Node pro2n = listOfNodes[pro2e];
				
				pro2n.addEdge(noNodes);
				pro1n.addEdge(pro2e);
				
				noNodes++;
			}
			else
			{

				Node pro1n = new Node(pro1, noNodes);
				listOfNodes[noNodes] = pro1n;
				noNodes++;
				
				int copy = noNodes;
				Node pro2n = new Node(pro2, copy);
				listOfNodes[noNodes] = pro2n;
				
				pro1n.addEdge(noNodes);
				pro2n.addEdge(noNodes - 1);
				noNodes++;
			}
		}	
	}
	file.close();
	//writer.close();
	}

}
