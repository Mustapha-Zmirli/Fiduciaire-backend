package ma.zs.univ.unit.ws.facade.admin.commun;

import ma.zs.univ.bean.core.commun.Societe;
import ma.zs.univ.service.impl.admin.commun.SocieteAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.commun.SocieteRestAdmin;
import ma.zs.univ.ws.converter.commun.SocieteConverter;
import ma.zs.univ.ws.dto.commun.SocieteDto;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SocieteRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SocieteAdminServiceImpl service;
    @Mock
    private SocieteConverter converter;

    @InjectMocks
    private SocieteRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSocieteTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SocieteDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SocieteDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSocieteTest() throws Exception {
        // Mock data
        SocieteDto requestDto = new SocieteDto();
        Societe entity = new Societe();
        Societe saved = new Societe();
        SocieteDto savedDto = new SocieteDto();

        // Mock the converter to return the societe object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved societe DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SocieteDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SocieteDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved societe DTO
        assertEquals(savedDto.getIce(), responseBody.getIce());
        assertEquals(savedDto.getRc(), responseBody.getRc());
    }

}
