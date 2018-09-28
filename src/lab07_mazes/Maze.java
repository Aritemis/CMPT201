/**
 * @author Ariana Fairbanks
 */

package lab07_mazes;

public class Maze extends MazeSolver
{
	private State position;
	private int[][] map;
	private int startRow;
	private int startCol;
	private boolean showSteps;

	public Maze(String fileName, int numberOfRows, int numberOfColumns, boolean showSteps) 
	{
		super(fileName, numberOfRows, numberOfColumns);
		position = startState;
		startRow = startState.getRow();
		startCol = startState.getColumn();
		this.showSteps = showSteps;
		makeMap();
	}

	@Override
	public void solveDFS()
	{
		printMaze();
		position = startState;
		Stack<State> forks = new ListStack<State>();
		forks.push(position);
		
		while(!position.equals(goalState))
		{
			position = forks.pop();
//			System.out.println(position);
			int row = position.getRow();
			int col = position.getColumn();

			if (!isWallOrOldLocation(row, col))
			{
				addVisit(position);
				
				if(showSteps)
				{
					System.out.println("");
					printMaze();
				}
				
				try
				{
					if (!isWallOrOldLocation(row + 1, col))
					{
						int newRow = row + 1;
						forks.push(states[newRow][col]);
					}
					if (!isWallOrOldLocation(row - 1, col))
					{
						int newRow = row - 1;
						forks.push(states[newRow][col]);
					}
					if (!isWallOrOldLocation(row, col + 1))
					{
						int newCol = col + 1;
						forks.push(states[row][newCol]);
					}
					if (!isWallOrOldLocation(row, col - 1))
					{
						int newCol = col - 1;
						forks.push(states[row][newCol]);
					}
				}
				catch(IndexOutOfBoundsException e){}
			}
		}

		int row = position.getRow();
		int col = position.getColumn();
		states[row][col].setValue('V');
		System.out.println("");
		printMaze();
		System.out.println("");
		System.out.println("");

	}

	@Override
	public void solveBFS() 
	{
		printMaze();
		position = startState;
		Queue<State> forks = new ArrayQueue<State>();
		forks.add(position);
		
		while(!position.equals(goalState))
		{
			position = forks.remove();
//			System.out.println(position);
			int row = position.getRow();
			int col = position.getColumn();

			if (!isWallOrOldLocation(row, col))
			{
				addVisit(position);
				
				if(showSteps)
				{
					System.out.println("");
					printMaze();
				}
				
				try
				{
					if (!isWallOrOldLocation(row + 1, col))
					{
						int newRow = row + 1;
						forks.add(states[newRow][col]);
					}
					if (!isWallOrOldLocation(row - 1, col))
					{
						int newRow = row - 1;
						forks.add(states[newRow][col]);
					}
					if (!isWallOrOldLocation(row, col + 1))
					{
						int newCol = col + 1;
						forks.add(states[row][newCol]);
					}
					if (!isWallOrOldLocation(row, col - 1))
					{
						int newCol = col - 1;
						forks.add(states[row][newCol]);
					}
				}
				catch(IndexOutOfBoundsException e){}
			}
		}

		int row = position.getRow();
		int col = position.getColumn();
		states[row][col].setValue('V');
		System.out.println("");
		printMaze();
		System.out.println("");
		System.out.println("");
	}
	
	private void makeMap()
	{
		map = new int[states.length][states[0].length];
		for(int row = 0; row < states.length; row++)
		{
			for(int col = 0; col < states[row].length; col++)
			{
				if(states[row][col].isWall())
				{
					map[row][col] = 1;
				}
			}
		}
	}
	
	private boolean isWallOrOldLocation(int row, int col)
	{
		boolean isOne = false;
		if(map[row][col] != 0)
		{
			isOne = true;
		}
		return isOne;
	}
	
	private void addVisit(State state)
	{
		int row = state.getRow();
		int col = state.getColumn();
		map[row][col] = 1;
		states[row][col].setValue('+');
		states[startRow][startCol].setValue('S');
	}
}
