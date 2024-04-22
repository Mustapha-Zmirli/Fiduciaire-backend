package ma.zs.univ.unit.ws.facade.admin.demande;

import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.service.impl.admin.demande.DemandePieceJointAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.demande.DemandePieceJointRestAdmin;
import ma.zs.univ.ws.converter.demande.DemandePieceJointConverter;
import ma.zs.univ.ws.dto.demande.DemandePieceJointDto;
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
public class DemandePieceJointRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private DemandePieceJointAdminServiceImpl service;
    @Mock
    private DemandePieceJointConverter converter;

    @InjectMocks
    private DemandePieceJointRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllDemandePieceJointTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<DemandePieceJointDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<DemandePieceJointDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveDemandePieceJointTest() throws Exception {
        // Mock data
        DemandePieceJointDto requestDto = new DemandePieceJointDto();
        DemandePieceJoint entity = new DemandePieceJoint();
        DemandePieceJoint saved = new DemandePieceJoint();
        DemandePieceJointDto savedDto = new DemandePieceJointDto();

        // Mock the converter to return the demandePieceJoint object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved demandePieceJoint DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<DemandePieceJointDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        DemandePieceJointDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved demandePieceJoint DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getPath(), responseBody.getPath());
    }

}
