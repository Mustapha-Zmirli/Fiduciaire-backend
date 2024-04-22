package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.dao.criteria.core.commun.CategoriePieceJointCriteria;
import ma.zs.univ.service.facade.admin.commun.CategoriePieceJointAdminService;
import ma.zs.univ.ws.converter.commun.CategoriePieceJointConverter;
import ma.zs.univ.ws.dto.commun.CategoriePieceJointDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/categoriePieceJoint/")
public class CategoriePieceJointRestAdmin  extends AbstractController<CategoriePieceJoint, CategoriePieceJointDto, CategoriePieceJointCriteria, CategoriePieceJointAdminService, CategoriePieceJointConverter> {



    @Operation(summary = "upload one categoriePieceJoint")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categoriePieceJoints")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categoriePieceJoints")
    @GetMapping("")
    public ResponseEntity<List<CategoriePieceJointDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categoriePieceJoints")
    @GetMapping("optimized")
    public ResponseEntity<List<CategoriePieceJointDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categoriePieceJoint by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CategoriePieceJointDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new CategoriePieceJoint(libelle));
    }

    @Operation(summary = "Saves the specified  categoriePieceJoint")
    @PostMapping("")
    public ResponseEntity<CategoriePieceJointDto> save(@RequestBody CategoriePieceJointDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categoriePieceJoint")
    @PutMapping("")
    public ResponseEntity<CategoriePieceJointDto> update(@RequestBody CategoriePieceJointDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categoriePieceJoint")
    @PostMapping("multiple")
    public ResponseEntity<List<CategoriePieceJointDto>> delete(@RequestBody List<CategoriePieceJointDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categoriePieceJoint")
    @DeleteMapping("")
    public ResponseEntity<CategoriePieceJointDto> delete(@RequestBody CategoriePieceJointDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categoriePieceJoint")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categoriePieceJoints by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categoriePieceJoint and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategoriePieceJointDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categoriePieceJoints by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategoriePieceJointDto>> findByCriteria(@RequestBody CategoriePieceJointCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categoriePieceJoints by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategoriePieceJointCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categoriePieceJoints by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategoriePieceJointCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categoriePieceJoint data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategoriePieceJointCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategoriePieceJointRestAdmin (CategoriePieceJointAdminService service, CategoriePieceJointConverter converter) {
        super(service, converter);
    }




}
