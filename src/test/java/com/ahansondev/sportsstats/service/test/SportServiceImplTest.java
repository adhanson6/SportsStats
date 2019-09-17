package com.ahansondev.sportsstats.service.test;

import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.repository.SportRepository;
import com.ahansondev.sportsstats.service.impl.SportServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Unit test class to test the {@link SportServiceImpl} class.
 */
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class SportServiceImplTest {

    // Constants
    private static final String FOOTBALL = "Football";

    @InjectMocks
    private SportServiceImpl sportService;

    @Mock
    private SportRepository sportRepository;

    /**
     * This test will validate that if the {@link SportRepository} returns a {@link List} of {@link Sport}
     * we return it with all members.
     */
    @Test
    public void getAllSportsReturnsListOfSports() throws Exception {
        // Given
        List<Sport> returnValue = new ArrayList<Sport>();
        returnValue.add(new Sport(FOOTBALL));
        given(sportRepository.findAll()).willReturn(returnValue);

        // When
        List<Sport> returnedValue = sportService.getAllSports();

        // Then
        assertThat(returnedValue).isEqualTo(returnValue);
    }

    @Test
    public void getAllSportsReturnsEmptyListOfSports() throws Exception {
        // Given
        List<Sport> returnValue = new ArrayList<Sport>();
        given(sportRepository.findAll()).willReturn(returnValue);

        // When
        List<Sport> returnedValue = sportService.getAllSports();

        // Then
        assertThat(returnedValue).isEqualTo(returnValue);
    }
}
