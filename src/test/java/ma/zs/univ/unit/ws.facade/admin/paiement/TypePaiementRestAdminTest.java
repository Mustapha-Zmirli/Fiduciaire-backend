package ma.zs.univ.unit.ws.facade.admin.paiement;

import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.service.impl.admin.paiement.TypePaiementAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.paiement.TypePaiementRestAdmin;
import ma.zs.univ.ws.converter.paiement.TypePaiementConverter;
import ma.zs.univ.ws.dto.paiement.TypePaiementDto;
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
public class TypePaiementRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TypePaiementAdminServiceImpl service;
    @Mock
    private TypePaiementConverter converter;

    @InjectMocks
    private TypePaiementRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypePaiementTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypePaiementDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypePaiementDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypePaiementTest() throws Exception {
        // Mock data
        TypePaiementDto requestDto = new TypePaiementDto();
        TypePaiement entity = new TypePaiement();
        TypePaiement saved = new TypePaiement();
        TypePaiementDto savedDto = new TypePaiementDto();

        // Mock the converter to return the typePaiement object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typePaiement DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypePaiementDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypePaiementDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typePaiement DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
