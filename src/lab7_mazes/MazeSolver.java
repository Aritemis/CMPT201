/**
 * Abstract class representing solving a maze.
 * 
 * @author Greg Gagne February 2017
 */

package lab7_mazes;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class MazeSolver 
{
	protected State[][] states;
	protected State startState;
	protected State goalState;
	protected int numberOfRows;
	protected int numberOfColumns;
	
	/**
	 * Inner class representing a state in the maze
	 * 
	 * A state is distinguished by a (row,column) as 
	 * well as a character where '%' indicates a wall
	 * and a blank space ' ' where the agent can move.
	 * 	
	 */
	protected class State
	{
		private int row;
		private int column;
		private char value;
				
		protected State(int row, int column, char value) 
		{
			this.row = row;
			this.column = column;
			this.value = value;
		}
		
		protected void setValue(char value) 
		{
			this.value = value;
		}
		
		protected int getRow()
		{
			return row;
		}
		
		protected int getColumn() 
		{
			return column;
		}
		
		protected boolean isWall() 
		{
			if (value == '%')
				return true;
			else
				return false;
		}
		
		protected boolean isGoalState() 
		{
			if (value == 'G')
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public String toString() 
		{
			return "row = " + row + " column = " + column + " " + Character.toString(value);
		}
		
		public boolean equals(Object other) 
		{
			State s = (State)other;
			
			if (this.row == s.row && this.column == s.column)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	
	/**
	 * Initializes the states of a maze.
	 * 
	 * @param fileName
	 * @param numberOfRows
	 * @param numberOfColumns
	 */
	@SuppressWarnings("resource")
	public MazeSolver(String fileName, int numberOfRows, int numberOfColumns) 
	{
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		
		states = new State[numberOfRows][numberOfColumns];
				
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String line;
		
			int row = 0;
			
			while ( (line = reader.readLine()) != null) 
			{
				for (int column = 0; column < line.length(); column++) 
				{
					states[row][column] = new State(row,column,line.charAt(column));
					
					if (line.charAt(column) == 'S')
						startState = new State(row, column, line.charAt(column));
					else if (line.charAt(column) == 'G')
						goalState = new State(row,column, line.charAt(column));
				}
				
				// move on to the next row
				row++;
			}
		}
		catch (Exception e) { System.err.println(e); }
	}
	
	/**
	 * Outputs the maze
	 */
	public void printMaze() 
	{
		for (int row = 0; row < states.length; row++) 
		{
			for (int col = 0; col < states[row].length; col++) 
			{
				System.out.print(states[row][col].value + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Solve the maze using a depth-first strategy (DFS)
	 */
	public abstract void solveDFS();
	
	/**
	 * Solve the maze using a breadth-first strategy (BFS)
	 */
	public abstract void solveBFS();
	
}
