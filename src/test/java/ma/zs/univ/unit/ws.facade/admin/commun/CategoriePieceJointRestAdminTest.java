package ma.zs.univ.unit.ws.facade.admin.commun;

import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.service.impl.admin.commun.CategoriePieceJointAdminServiceImpl;
import ma.zs.univ.ws.facade.admin.commun.CategoriePieceJointRestAdmin;
import ma.zs.univ.ws.converter.commun.CategoriePieceJointConverter;
import ma.zs.univ.ws.dto.commun.CategoriePieceJointDto;
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
public class CategoriePieceJointRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CategoriePieceJointAdminServiceImpl service;
    @Mock
    private CategoriePieceJointConverter converter;

    @InjectMocks
    private CategoriePieceJointRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategoriePieceJointTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategoriePieceJointDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategoriePieceJointDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategoriePieceJointTest() throws Exception {
        // Mock data
        CategoriePieceJointDto requestDto = new CategoriePieceJointDto();
        CategoriePieceJoint entity = new CategoriePieceJoint();
        CategoriePieceJoint saved = new CategoriePieceJoint();
        CategoriePieceJointDto savedDto = new CategoriePieceJointDto();

        // Mock the converter to return the categoriePieceJoint object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categoriePieceJoint DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategoriePieceJointDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategoriePieceJointDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categoriePieceJoint DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
