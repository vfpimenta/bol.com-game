package com.bol.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bol.game.business.GameState;

@Controller
public class GameController {
	
	private GameState gameState = GameState.getInstance();

	@GetMapping("/game")
	public String game(@RequestParam(name="tile", required=false, defaultValue="None") String tile,
			@RequestParam(name="reset", required=false, defaultValue="false") String reset, 
			Model model) {
		if(Boolean.parseBoolean(reset)) {
			gameState.reset();
		}else {
			if(!"None".equals(tile)) {
				Integer tileIndex = Integer.parseInt(tile);
				gameState.play(tileIndex);
			} 
		}
		model.addAttribute("gameState", gameState);
		return "game";
	}
}
