package com.eldorado.productservice.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eldorado.productservice.entities.Rating;
import com.eldorado.productservice.exceptions.EmptyFieldException;
import com.eldorado.productservice.exceptions.EntryExistException;
import com.eldorado.productservice.exceptions.NoUserFoundException;
import com.eldorado.productservice.repositories.RatingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceImplTest {
	
	@Autowired
	RatingServiceImpl ratingService;
	
	@MockBean
	RatingRepository ratingRepository;

	@Test
	public void addRatingServiceTest() throws Exception {

		Rating r1 = new Rating("p1","u1",4);
		when(ratingRepository.getRating("u1", "p1")).thenReturn(r1);
		when(ratingRepository.save(r1)).thenReturn(r1);

		assertThrows(EntryExistException.class,()-> ratingService.addRatingService(r1));
	}
/*
	@Test
	public void getAvgRatingTest() throws EmptyFieldException {

		when(ratingService.getAvgRating("p1")).thenReturn(new HashMap<String,Object>());

		// verify
		ratingService.getAvgRating("p1");

		verify(ratingService).getAvgRating("p1");

	}
*/
	@Test
	public void getRatingTest() throws EmptyFieldException, NoUserFoundException {

		Rating r1 = new Rating();

		when(ratingRepository.getRating("u1", "p1")).thenReturn(r1);

		assertNotNull(ratingService.getRating("u1", "p1"));

	}
	
}
