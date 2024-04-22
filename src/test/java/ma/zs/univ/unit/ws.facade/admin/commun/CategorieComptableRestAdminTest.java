package ma.zs.univ.unit.ws.facade.admin.commun;

import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.service.impl.admin.commun.CategorieComptableAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.commun.CategorieComptableRestAdmin;
import ma.zs.univ.ws.converter.commun.CategorieComptableConverter;
import ma.zs.univ.ws.dto.commun.CategorieComptableDto;
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
public class CategorieComptableRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CategorieComptableAdminServiceImpl service;
    @Mock
    private CategorieComptableConverter converter;

    @InjectMocks
    private CategorieComptableRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategorieComptableTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategorieComptableDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategorieComptableDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategorieComptableTest() throws Exception {
        // Mock data
        CategorieComptableDto requestDto = new CategorieComptableDto();
        CategorieComptable entity = new CategorieComptable();
        CategorieComptable saved = new CategorieComptable();
        CategorieComptableDto savedDto = new CategorieComptableDto();

        // Mock the converter to return the categorieComptable object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categorieComptable DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategorieComptableDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategorieComptableDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categorieComptable DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
