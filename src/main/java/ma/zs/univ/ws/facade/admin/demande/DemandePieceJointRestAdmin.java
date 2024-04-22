package  ma.zs.univ.ws.facade.admin.demande;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.dao.criteria.core.demande.DemandePieceJointCriteria;
import ma.zs.univ.service.facade.admin.demande.DemandePieceJointAdminService;
import ma.zs.univ.ws.converter.demande.DemandePieceJointConverter;
import ma.zs.univ.ws.dto.demande.DemandePieceJointDto;
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
@RequestMapping("/api/admin/demandePieceJoint/")
public class DemandePieceJointRestAdmin  extends AbstractController<DemandePieceJoint, DemandePieceJointDto, DemandePieceJointCriteria, DemandePieceJointAdminService, DemandePieceJointConverter> {



    @Operation(summary = "upload one demandePieceJoint")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple demandePieceJoints")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all demandePieceJoints")
    @GetMapping("")
    public ResponseEntity<List<DemandePieceJointDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all demandePieceJoints")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandePieceJointDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a demandePieceJoint by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<DemandePieceJointDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new DemandePieceJoint(libelle));
    }

    @Operation(summary = "Saves the specified  demandePieceJoint")
    @PostMapping("")
    public ResponseEntity<DemandePieceJointDto> save(@RequestBody DemandePieceJointDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  demandePieceJoint")
    @PutMapping("")
    public ResponseEntity<DemandePieceJointDto> update(@RequestBody DemandePieceJointDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of demandePieceJoint")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandePieceJointDto>> delete(@RequestBody List<DemandePieceJointDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified demandePieceJoint")
    @DeleteMapping("")
    public ResponseEntity<DemandePieceJointDto> delete(@RequestBody DemandePieceJointDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified demandePieceJoint")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple demandePieceJoints by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by demande id")
    @GetMapping("demande/id/{id}")
    public List<DemandePieceJointDto> findByDemandeId(@PathVariable Long id){
        return findDtos(service.findByDemandeId(id));
    }
    @Operation(summary = "delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }

    @Operation(summary = "Finds a demandePieceJoint and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandePieceJointDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds demandePieceJoints by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandePieceJointDto>> findByCriteria(@RequestBody DemandePieceJointCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated demandePieceJoints by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandePieceJointCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports demandePieceJoints by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandePieceJointCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets demandePieceJoint data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandePieceJointCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DemandePieceJointRestAdmin (DemandePieceJointAdminService service, DemandePieceJointConverter converter) {
        super(service, converter);
    }




}
