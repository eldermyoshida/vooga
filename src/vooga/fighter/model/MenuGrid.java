package vooga.fighter.model;

import java.util.List;

import vooga.fighter.model.objects.MenuObject;

public class MenuGrid {
	private int myColumns;
	private int myRows;
	private MenuObject [][] myGrid;
	
	public MenuGrid(List<MenuObject> list) {
		myGrid = createEmptyGrid(list.size());
		fillGrid(list, myGrid, myColumns);
	}
	
	public MenuObject [][] createEmptyGrid(int listsize){
		if(listsize < 4){
			myRows = 1;
			myColumns = listsize;
		}
		else if(listsize%2 == 0){
			myColumns = listsize/2;
			myRows = 2;
		}
		else if(listsize%2 == 1){
			myColumns = listsize/2;
			myRows = 3;
		}
		return new MenuObject[myRows][myColumns];
	}
	
	public MenuObject getMenuObject(int i, int j){
		return myGrid[i][j];
	}
	
	private void fillGrid(List<MenuObject> list, MenuObject [][] grid, int columns){
		for(int i = 0; i < list.size(); i ++){
			int RowNumber = 0;
				int ColumnNumber = i*(RowNumber+1) -columns; 
				if(ColumnNumber <columns){
				grid[RowNumber][ColumnNumber] = list.get(i);
				}
				else{
					RowNumber ++;
				}
			
		}
	}

}
