/**
 * @author Ariana Fairbanks
 */

package lab7_mazes;

public class MazeGame 
{
	public static void main(String[] args)
	{

		//'+' DENOTES AN AREA THAT HAS BEEN VISITED
		//'V' FOR VICTORY
		//CHANGE BOOLEAN VALUE FOR ANY MAZE TO 'TRUE' TO SHOW EACH STEP TAKEN THROUGH THE MAZE
		
		Maze miniDFS = new Maze("miniMaze.txt", 7, 7, false);
		System.out.println("Mini DFS\n");
		miniDFS.solveDFS();
		
		Maze miniBFS = new Maze("miniMaze.txt", 7, 7, false);
		System.out.println("Mini BFS\n");
		miniBFS.solveBFS();
		
				
		Maze smallDFS = new Maze("smallMaze.txt", 10, 22, false);
		System.out.println("Small DFS\n");
		smallDFS.solveDFS();
		
		Maze smallBFS = new Maze("smallMaze.txt", 10, 22, false);
		System.out.println("Small BFS\n");
		smallBFS.solveBFS();
		
		
		Maze mediumDFS = new Maze("mediumMaze.txt", 18, 36, false);
		System.out.println("Medium DFS\n");
		mediumDFS.solveDFS();
		
		Maze mediumBFS = new Maze("mediumMaze.txt", 18, 36, false);
		System.out.println("Medium BFS\n");
		mediumBFS.solveBFS();
		
		
		Maze bigDFS = new Maze("bigMaze.txt", 37, 37, false);
		System.out.println("Big DFS\n");
		bigDFS.solveDFS();
		
		Maze bigBFS = new Maze("bigMaze.txt", 37, 37, false);
		System.out.println("Big BFS\n");
		bigBFS.solveBFS();
	}
}
