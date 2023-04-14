package com.alexproject.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexproject.lookify.models.Songs;
import com.alexproject.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository srepo;
	
	//getAll
	public List<Songs> getAllSongs()
	{
		return srepo.findAll();
	}
	
	//getOne
	public Songs getOneSong(Long id)
	{
		return srepo.findById(id).orElse(null);
	}
	
	//create
	public Songs createSong(Songs newSong)
	{
		return srepo.save(newSong);
	}
	
	//update
	public Songs updateSong(Songs updatedSong)
	{
		return this.srepo.save(updatedSong);
	}
	
	//delete
	public void deleteSong(Long id)
	{
		this.srepo.deleteById(id);
	}
	
	//getTop10byRating
	public List<Songs> getTop10Songs()
	{
		return srepo.findTop10ByOrderBySongRatingDesc();
	}
	
	public List<Songs> getSongByArtist(String aristName)
	{
		return srepo.findBySongArtistContaining(aristName);
	}
	
}
