package ma.zs.univ.unit.ws.facade.admin.commun;

import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.service.impl.admin.commun.ComptableAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.commun.ComptableRestAdmin;
import ma.zs.univ.ws.converter.commun.ComptableConverter;
import ma.zs.univ.ws.dto.commun.ComptableDto;
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
public class ComptableRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ComptableAdminServiceImpl service;
    @Mock
    private ComptableConverter converter;

    @InjectMocks
    private ComptableRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllComptableTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ComptableDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ComptableDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveComptableTest() throws Exception {
        // Mock data
        ComptableDto requestDto = new ComptableDto();
        Comptable entity = new Comptable();
        Comptable saved = new Comptable();
        ComptableDto savedDto = new ComptableDto();

        // Mock the converter to return the comptable object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved comptable DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ComptableDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ComptableDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved comptable DTO
        assertEquals(savedDto.getCin(), responseBody.getCin());
        assertEquals(savedDto.getPrenom(), responseBody.getPrenom());
        assertEquals(savedDto.getNom(), responseBody.getNom());
        assertEquals(savedDto.getEmail(), responseBody.getEmail());
        assertEquals(savedDto.getCategorieComptable(), responseBody.getCategorieComptable());
    }

}
