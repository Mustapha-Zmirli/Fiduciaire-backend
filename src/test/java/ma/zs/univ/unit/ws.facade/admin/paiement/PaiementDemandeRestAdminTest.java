package ma.zs.univ.unit.ws.facade.admin.paiement;

import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.service.impl.admin.paiement.PaiementDemandeAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.paiement.PaiementDemandeRestAdmin;
import ma.zs.univ.ws.converter.paiement.PaiementDemandeConverter;
import ma.zs.univ.ws.dto.paiement.PaiementDemandeDto;
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
public class PaiementDemandeRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private PaiementDemandeAdminServiceImpl service;
    @Mock
    private PaiementDemandeConverter converter;

    @InjectMocks
    private PaiementDemandeRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPaiementDemandeTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PaiementDemandeDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PaiementDemandeDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePaiementDemandeTest() throws Exception {
        // Mock data
        PaiementDemandeDto requestDto = new PaiementDemandeDto();
        PaiementDemande entity = new PaiementDemande();
        PaiementDemande saved = new PaiementDemande();
        PaiementDemandeDto savedDto = new PaiementDemandeDto();

        // Mock the converter to return the paiementDemande object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved paiementDemande DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PaiementDemandeDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PaiementDemandeDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved paiementDemande DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getMontant(), responseBody.getMontant());
        assertEquals(savedDto.getDatePaiement(), responseBody.getDatePaiement());
    }

}
