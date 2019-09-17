package com.ahansondev.sportsstats.service.test.cfb;

import com.ahansondev.sportsstats.model.cfb.Conference;
import com.ahansondev.sportsstats.repository.cfb.ConferenceRepository;
import com.ahansondev.sportsstats.service.cfb.impl.ConferenceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Unit test class to test the {@link ConferenceServiceImpl} class.
 */
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ConferenceServiceImplTest {

    // Constants
    private static final String BIG_TEN = "Big Ten";
    private static final String WEST = "West";

    @InjectMocks
    private ConferenceServiceImpl conferenceService;

    @Mock
    private ConferenceRepository conferenceRepository;

    /**
     * This test will validate that if the {@link ConferenceRepository} returns a {@link List} of {@link Conference}
     * we return it with all members.
     */
    @Test
    public void getAllConferencessReturnsListOfConferences() throws Exception {
        // Given
        List<Conference> returnValue = new ArrayList<Conference>();
        returnValue.add(new Conference(BIG_TEN, WEST));
        given(conferenceRepository.findAll()).willReturn(returnValue);

        // When
        List<Conference> returnedValue = conferenceService.getAllConferences();

        // Then
        assertThat(returnedValue).isEqualTo(returnValue);
    }

    @Test
    public void getAllSportsReturnsEmptyListOfSports() throws Exception {
        // Given
        List<Conference> returnValue = new ArrayList<Conference>();
        given(conferenceRepository.findAll()).willReturn(returnValue);

        // When
        List<Conference> returnedValue = conferenceService.getAllConferences();

        // Then
        assertThat(returnedValue).isEqualTo(returnValue);
    }
}
