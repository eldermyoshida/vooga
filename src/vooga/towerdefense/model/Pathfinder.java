package vooga.towerdefense.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import vooga.towerdefense.util.Location;

public class Pathfinder {

	private Tile[][] myGrid;

	public Pathfinder(Tile[][] grid) {
		myGrid = grid;
	}

	class ArrayIndex {
		public ArrayIndex(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int x;
		public int y;
		public int dist;
	};

	class DistComparator implements Comparator<ArrayIndex> {

		@Override
		public int compare(ArrayIndex a, ArrayIndex b) {
			if (a.dist < b.dist)
				return -1;
			if (a.dist > b.dist)
				return 1;
			return 0;
		}
	}

	public Path getShortestPath(int x1, int y1, int x2, int y2, Location finish) {

//TODO: implement dijkrstra's algoritm to make smart pathfinding
//		int[][] dist = new int[myGrid.length][myGrid[0].length];
//
//		PriorityQueue<ArrayIndex> Q = new PriorityQueue<ArrayIndex>();
//
//		for (int i = 0; i < myGrid.length; i++)
//			for (int j = 0; j < myGrid[0].length; j++) {
//				ArrayIndex a = new ArrayIndex(i, j, Integer.MAX_VALUE);
//				Q.add(a);
//			}
		
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location(100, 0));
		locations.add(new Location(100, 200));
		locations.add(new Location(400, 200));
		locations.add(finish);
		
		return new Path(locations);

	}

}
