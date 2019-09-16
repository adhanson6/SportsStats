package com.ahansondev.sportsstats.repository.test;

import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.repository.SportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test suite for the {@link SportRepository} class using an in-memory database for
 * integration testing. Integration testing is used due to no implementation details written
 * in the repository interface itself.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SportRepositoryIntegrationTest {

    // Constants
    private static final String FOOTBALL = "Football";

    @Autowired
    private SportRepository sportRepository;

    /**
     * This test will validate that {@link SportRepository} correctly returns
     * all {@link Sport} objects in the database.
     */
    @Test
    public void findAllReturnsAllSports() {
        // Given
        Sport sport = new Sport(FOOTBALL);
        sportRepository.save(sport);

        // When
        List<Sport> returnedValue = sportRepository.findAll();

        // Then
        assertThat(returnedValue).hasSize(1);
        assertThat(returnedValue).isNotNull();
        assertThat(returnedValue.get(0)).isNotNull();
        assertThat(returnedValue.get(0).getName()).isEqualTo(FOOTBALL);
    }
}
