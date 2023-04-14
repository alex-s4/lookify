package com.alexproject.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alexproject.lookify.models.Songs;
import com.alexproject.lookify.services.SongService;

@Controller
public class SongsController {
	
	@Autowired
	private SongService sserv;
	
	@GetMapping("/")
	public String index() 
	{
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model mv)
	{
		List<Songs> allSongs = sserv.getAllSongs();
		mv.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}
}
