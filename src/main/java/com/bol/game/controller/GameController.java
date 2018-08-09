package com.bol.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

		@GetMapping("/game")
		public String game(@RequestParam(name="name", required=false, defaultValue="None") String name, Model model) {
			model.addAttribute("name", name);
			return "game";
		}
	
}
