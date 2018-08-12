package com.bol.game.business;

public class Tile {
	private Boolean bigPit;
	private Integer stones;
	private Integer owner;
	public Tile(Boolean bigPit, Integer stones, Integer owner) {
		super();
		this.bigPit = bigPit;
		this.stones = stones;
		this.owner = owner;
	}
	public Boolean isBigPit() {
		return bigPit;
	}
	public void setBigPit(Boolean bigPit) {
		this.bigPit = bigPit;
	}
	public Integer getStones() {
		return stones;
	}
	public void setStones(Integer stones) {
		this.stones = stones;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	
}
