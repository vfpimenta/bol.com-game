package com.bol.game.business;

public class GameState {

	private static GameState instance;
	
	private Integer currentPlayer;
	private Board board;
	private Boolean gameOver;
	private Integer winner;
	
	private GameState() {
		super();
		this.currentPlayer = 1;
		this.board = new Board();
		this.setGameOver(false);
		this.setWinner(null);
	}
	
	public Integer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Integer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public static synchronized GameState getInstance() {
		if (instance == null) {
			instance = new GameState();
		}
		return instance;
	}
	
	public void reset() {
		this.currentPlayer = 1;
		this.board = new Board();
		this.setGameOver(false);
		this.setWinner(null);
	}
	
	public void play(int tileIndex){
		boolean bonusTurn = false;
		Integer stones = board.emptyTile(tileIndex, true);
		while (stones > 0) {
			Tile nextTile = board.next();
			
			// Avoid putting stones on the enemy's big pit
			if (nextTile.getOwner() == currentPlayer || !nextTile.isBigPit()) {
				// Last stone
				if (stones == 1) {
					// If it lands on the player's big pit gain a bonus turn 
					if (nextTile.isBigPit()) {
						bonusTurn = true;
					// If it lands on an own empty tile captures the opposite stones
					} else if(nextTile.getOwner() == currentPlayer && nextTile.getStones() == 0) { 
						nextTile.setStones(board.emptyTile(board.opposite(), false));
					}
				}
				
				nextTile.setStones(nextTile.getStones()+1);
				stones--;
			}
		}
		
		// If there is no bonus turn then pass
		if (!bonusTurn) {
			currentPlayer = currentPlayer == 1 ? 2 : 1;
		}
		
		// End game scenario, all stones in the big pits
		if (board.getTileStones(6) + board.getTileStones(13) == 72) {
			setGameOver(true);
			if (board.getTileStones(6) > board.getTileStones(13)) {
				setWinner(1);
			} else if (board.getTileStones(6) < board.getTileStones(13)) {
				setWinner(2);
			}
		}
	}

	public Boolean getGameOver() {
		return gameOver;
	}

	public void setGameOver(Boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Integer getWinner() {
		return winner;
	}

	public void setWinner(Integer winner) {
		this.winner = winner;
	}
}
