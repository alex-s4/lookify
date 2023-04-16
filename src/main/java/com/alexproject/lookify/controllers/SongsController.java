package com.alexproject.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("newSong") Songs newSong,
			BindingResult result,
			Model mv)
	{
//		if(result.hasErrors()) {
//			return "redirect:/songs/new";
//		}
		return "new.jsp";
	}
	
	@PostMapping("/songs/create")
	public String createSong(@Valid @ModelAttribute("newSong") Songs createdSong,
			BindingResult result,
			Model mv)
	{
		if(result.hasErrors()) {
			return "new.jsp";
		}
		sserv.createSong(createdSong);
		return "redirect:/songs/new";
	}
	
	@GetMapping("/songs/{id}")
	public String showDescription(@PathVariable("id") Long id,
			Model mv) 
	{
		Songs song = sserv.getOneSong(id);
		mv.addAttribute("songToShow", song);
		return "show.jsp";
	}
	
	@GetMapping("/songs/top-ten")
	public String getTopTen(Model mv)
	{
		List<Songs> topSongs = sserv.getTop10Songs();
		mv.addAttribute("topSongs", topSongs);
		return "topTen.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
	public String destroySong(@PathVariable("id") Long id)
	{
		sserv.deleteSong(id);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/search/{searchArtist}")
	public String searchByArtist(@PathVariable("searchArtist") String searchArtist,
			Model mv)
	{
		List<Songs> songsByArtist = sserv.getSongByArtist(searchArtist);
		mv.addAttribute("songs", songsByArtist);
		mv.addAttribute("searchQuery", searchArtist);
		return "searchResults.jsp";
	}
	
}
