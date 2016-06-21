package PPNet2;

//create Node class

public class Node extends Network{
//represents single Node of Network
	private String name;
	public int id;
	public int[] edges;
	private int noEdges;
	
	public Node(String newName, int newID) {
	// create default constructor that creates node with empty name
		name = newName;
		id = newID;
		noEdges = 0;
		edges = new int[100];
	}
	
	public void addEdge(int otherID)
	{
		edges[noEdges] = otherID;
		noEdges++;
	}
	
	public int getNoEdges()
	{
		return noEdges;	
	}
	
	public String getName()
	{
		return name;
	}
	
	public int checkEdge(int otherID)
	{
		for (int i=0; i<noEdges; i++)
		{
			if (edges[i] == otherID)
				return 1;
		}
		return 0;
	}
	
}
