package com.alexproject.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexproject.lookify.models.Songs;
import com.alexproject.lookify.services.SongService;

@RestController
public class SongsApi {
	
	@Autowired
	private SongService sserv;

	@GetMapping("/api/songs")
	public List<Songs> getAllSongs()
	{
		return sserv.getAllSongs();
	}
	
	@PostMapping("/api/songs/create")
	public Songs createSong(Songs newSong)
	{
		return sserv.createSong(newSong);
	}
	
	@GetMapping("/api/songs/search")
	public List<Songs> findSongsByArtist(@RequestParam("artistName")String search)
	{
		return sserv.getSongByArtist(search);
	}
	
	@GetMapping("/api/songs/top10")
	public List<Songs> findTop10Songs()
	{
		return sserv.getTop10Songs();
	}
	
	@PutMapping("/api/songs/edit/{id}")
	public Songs updateSong(@PathVariable Long id, Songs updatedSong)
	{
		return sserv.updateSong(updatedSong);
	}
	
}
