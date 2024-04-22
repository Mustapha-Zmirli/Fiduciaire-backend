package ma.zs.univ.unit.ws.facade.admin.paiement;

import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.service.impl.admin.paiement.PaiementComptableTraitantAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.paiement.PaiementComptableTraitantRestAdmin;
import ma.zs.univ.ws.converter.paiement.PaiementComptableTraitantConverter;
import ma.zs.univ.ws.dto.paiement.PaiementComptableTraitantDto;
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
public class PaiementComptableTraitantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private PaiementComptableTraitantAdminServiceImpl service;
    @Mock
    private PaiementComptableTraitantConverter converter;

    @InjectMocks
    private PaiementComptableTraitantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPaiementComptableTraitantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PaiementComptableTraitantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PaiementComptableTraitantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePaiementComptableTraitantTest() throws Exception {
        // Mock data
        PaiementComptableTraitantDto requestDto = new PaiementComptableTraitantDto();
        PaiementComptableTraitant entity = new PaiementComptableTraitant();
        PaiementComptableTraitant saved = new PaiementComptableTraitant();
        PaiementComptableTraitantDto savedDto = new PaiementComptableTraitantDto();

        // Mock the converter to return the paiementComptableTraitant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved paiementComptableTraitant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PaiementComptableTraitantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PaiementComptableTraitantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved paiementComptableTraitant DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getMontant(), responseBody.getMontant());
        assertEquals(savedDto.getDatePaiement(), responseBody.getDatePaiement());
    }

}
