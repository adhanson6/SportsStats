package com.ahansondev.sportsstats.controller.test;

import com.ahansondev.sportsstats.controller.CFBAPIController;
import com.ahansondev.sportsstats.model.Sport;
import com.ahansondev.sportsstats.model.cfb.Conference;
import com.ahansondev.sportsstats.service.SportService;
import com.ahansondev.sportsstats.service.cfb.ConferenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * The test suite testing the {@link com.ahansondev.sportsstats.controller.CFBAPIController} class.
 */
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class CFBAPIControllerTest {

    // Constants
    private static final String SPORTS_ROUTE = "/api/cfb/sports";
    private static final String CONFERENCE_ROUTE = "/api/cfb/conferences";
    private static final String FOOTBALL = "Football";
    private static final String BIG_TEN = "Big Ten";
    private static final String WEST = "West";

    private MockMvc mvc;

    @Mock
    private SportService sportService;

    @Mock
    private ConferenceService conferenceService;

    @InjectMocks
    private CFBAPIController cfbapiController;

    // JSON creation objects
    private JacksonTester<Sport> jsonSport;
    private JacksonTester<List<Sport>> jsonSportArray;
    private JacksonTester<List<Conference>> jsonConferenceArray;

    /**
     * Setup run before each test.
     */
    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(cfbapiController).build();
    }

    /**
     * This test will validate that the {@link SportService} returns an {@link ArrayList} correctly
     * with a valid HTTP status.
     * @throws Exception
     */
    @Test
    public void canRetrieveAllSportsWhenExists() throws Exception {
        // Given
        List<Sport> returnValue = new ArrayList<Sport>();
        returnValue.add(new Sport(FOOTBALL));
        given(sportService.getAllSports()).willReturn(returnValue);

        // When
        MockHttpServletResponse response = mvc.perform(
                get(SPORTS_ROUTE).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSportArray.write(returnValue).getJson()
        );
    }

    /**
     * This test will validate that the {@link SportService} returns an empty {@link ArrayList} when
     * there are no entries with a valid HTTP status.
     * @throws Exception
     */
    @Test
    public void canRetrieveAllSportsWhenDoesNotExist() throws Exception {
        // Given
        given(sportService.getAllSports()).willReturn(new ArrayList<Sport>());

        // When
        MockHttpServletResponse response = mvc.perform(
                get(SPORTS_ROUTE).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSportArray.write(new ArrayList<Sport>()).getJson()
        );
    }

    /**
     * This test will validate that the {@link ConferenceService} returns a {@link List} correctly
     * with a valid HTTP status.
     * @throws Exception
     */
    @Test
    public void canRetrieveAllConferencesWhenExists() throws Exception {
        // Given
        List<Conference> returnValue = new ArrayList<Conference>();
        returnValue.add(new Conference(BIG_TEN, WEST));
        given(conferenceService.getAllConferences()).willReturn(returnValue);

        // When
        MockHttpServletResponse response = mvc.perform(
                get(CONFERENCE_ROUTE).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonConferenceArray.write(returnValue).getJson()
        );
    }

    /**
     * This test will validate that the {@link ConferenceService} returns an empty {@link List} when
     * there are no entries with a valid HTTP status.
     * @throws Exception
     */
    @Test
    public void canRetrieveAllConferencesWhenDoesNotExist() throws Exception {
        // Given
        given(conferenceService.getAllConferences()).willReturn(new ArrayList<Conference>());

        // When
        MockHttpServletResponse response = mvc.perform(
                get(CONFERENCE_ROUTE).accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonConferenceArray.write(new ArrayList<Conference>()).getJson()
        );
    }

}
