package com.record10.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.record10.models.CatalogItem;
import com.record10.models.Movie;
import com.record10.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		RestTemplate rt = new RestTemplate();
		
		
		//get all rated movies
		List<Rating> ratings = Arrays.asList(
		 new Rating("1234", 4),
		 new Rating("1235", 2)
		);
		
		return ratings.stream().map(rating->{
			Movie movie = rt.getForObject("http://localhost:8081/movie/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Description", rating.getRating());
		})
		.collect(Collectors.toList());
		
		//for each movie id get movie info from info service
		
		
		
		//put them all together

		
	}
	
}
