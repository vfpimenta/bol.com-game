package com.bol.game.business;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Tile> tiles;
	private Integer cursor;

	public Board() {
		tiles = new ArrayList<Tile>();
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(false, 6, 1));
		tiles.add(new Tile(true, 0, 1));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(false, 6, 2));
		tiles.add(new Tile(true, 0, 2));
		cursor = 0;
	}
	
	// Collect all stones from a tile, can also put cursor at the target position
	public Integer emptyTile(int index, boolean replaceCursor) {
		Integer stones = tiles.get(index).getStones();
		tiles.get(index).setStones(0);
		if (replaceCursor) {
			cursor = index;
		}
		return stones;
	}
	
	// Move cursor to next position
	public Tile next(){
		if(cursor < tiles.size()-1) {
			cursor++;
		} else {
			cursor=0;
		}
		return tiles.get(cursor);
	}
	
	// Get position in front of a tile
	public Integer opposite() {
		if(tiles.get(cursor).isBigPit()) {
			return cursor;
		} else {
			return 12 - cursor;
		}
	}
	
	public Integer getTileStones(int index) {
		return tiles.get(index).getStones();
	}
}
