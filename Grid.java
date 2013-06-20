
public class Grid {
	Animal[][] grid;
	
	public Grid(int height, int width) {
		height = checkBoundary(height);
		width = checkBoundary(width);
		
		grid = new Animal[width][height];
	}
	
	private int checkBoundary(int boundary) {
		return Math.max(boundary, 3);
	}
	
	public boolean addAnimal(Animal animal, int x, int y) {
		if (x >= 0 && x < grid.length && 
			y >= 0 && y < grid[0].length && 
			grid[x][y] == null) {
				grid[x][y] = animal;
				return true;
		}	
		return false;
	}
	
	protected Animal getAnimal(int x, int y) {
		return grid[x][y];
	}
	
	protected void removeAnimal(Animal animal) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; i < grid[0].length; j++) {
				if(grid[i][j].equals(animal)) {
					grid[i][j] = null; 
					return;
				}
			}
		}
			
	}
	
	public void setSurrounding(Animal animal, Animal[][] surroundingGrid) {
		if (animal == null || surroundingGrid == null || surroundingGrid.length != 3 || surroundingGrid[0].length != 3) {
			return;
		}
			
		// Scan entire Grid for animal
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; i < grid[0].length; j++) {
				if (animal.equals(grid[i][j]))  {
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							// be sure dX is between 0 and width - 1
							int dX = i+k - 1;
							dX = (dX + grid.length) % grid.length;
							
							int dY = j+l - 1;
							dY = (dY + grid.length) % grid.length;
							
							grid[dX][dY] = surroundingGrid[k][l];
						}
					}
				}
			}
		}
	}
	
	public Animal[][] getSurrounding(Animal animal) {
		if (animal == null) {
			return null;
		}
		
		// Scan entire Grid for animal
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; i < grid[0].length; j++) {
				if (animal.equals(grid[i][j]))  {
					// Animal found, get surrounding
					Animal surroundingGrid[][] = new Animal[3][3];
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							// be sure dX is between 0 and width - 1
							int dX = i+k - 1;
							dX = (dX + 2*grid.length) % grid.length;
							
							int dY = j+l - 1;
							dY = (dY + 2*grid.length) % grid.length;
							
							surroundingGrid[k][l] = grid[dX][dY];
							
							return surroundingGrid;
						}
					}
				}
			}
		}
		
		// Animal was not found on the grid
		return null;
	}
}
