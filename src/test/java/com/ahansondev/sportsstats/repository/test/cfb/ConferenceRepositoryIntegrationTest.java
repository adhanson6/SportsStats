package com.ahansondev.sportsstats.repository.test.cfb;

import com.ahansondev.sportsstats.model.cfb.Conference;
import com.ahansondev.sportsstats.repository.cfb.ConferenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test suite for the {@link ConferenceRepository} class using an in-memory database for
 * integration testing. Integration testing is used due to no implementation details written
 * in the repository interface itself.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class ConferenceRepositoryIntegrationTest {

    // Constants
    private static final String BIG_TEN = "Big Ten";
    private static final String WEST = "West";

    @Autowired
    private ConferenceRepository conferenceRepository;

    /**
     * This test will validate that {@link ConferenceRepository} correctly returns
     * all {@link Conference} objects in the database.
     */
    @Test
    public void findAllReturnsAllConferencess() {
        // Given
        Conference conference = new Conference(BIG_TEN, WEST);
        conferenceRepository.save(conference);

        // When
        List<Conference> returnedValue = conferenceRepository.findAll();

        // Then
        assertThat(returnedValue).hasSize(1);
        assertThat(returnedValue).isNotNull();
        assertThat(returnedValue.get(0)).isNotNull();
        assertThat(returnedValue.get(0).getName()).isEqualTo(BIG_TEN);
        assertThat(returnedValue.get(0).getDivision()).isEqualTo(WEST);
    }

}
