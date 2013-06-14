
public class Grid {
	Animal[][] grid;
	
	public Grid(int height, int width) {
		height = checkBoundary(height);
		width = checkBoundary(width);
		
		grid = new Animal[width][height];
	}
	
	private int checkBoundary(int boundary) {
		return Math.min(Math.max(boundary, 0), 3);
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
	
	public Animal[][] getSurrounding(Animal animal) {
		if (animal == null) {
			return null;
		}
		
		// Scan entire Grid for animal
		for (int i=0; i<grid.length; i++) {
			for (int j=0; i<grid[0].length; j++) {
				if (animal.equals(grid[i][j]))  {
					// Animal found, get surrounding
					Animal surroundingGrid[][] = new Animal[3][3];
					for (int k=0; k<3; k++) {
						for (int l=0; l<3; l++) {
							// be sure dX is between 0 and width - 1
							// kweenie
							dX = i-k - 1;
							dX = (dX + grid.length) % grid.length;
							dY = j-l - 1;
							dY = (dY + gridY[0].length) % grid[0].length;
							
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
