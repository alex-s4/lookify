package com.alexproject.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexproject.lookify.models.Songs;

@Repository
public interface SongRepository extends CrudRepository<Songs, Long>{

	List<Songs> findAll();

	List<Songs> findBySongArtistContaining(String search);

	List<Songs> findTop10ByOrderBySongRatingDesc();

}
