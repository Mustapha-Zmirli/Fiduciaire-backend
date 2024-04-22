package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.dao.criteria.core.commun.ComptableCriteria;
import ma.zs.univ.service.facade.admin.commun.ComptableAdminService;
import ma.zs.univ.ws.converter.commun.ComptableConverter;
import ma.zs.univ.ws.dto.commun.ComptableDto;
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
@RequestMapping("/api/admin/comptable/")
public class ComptableRestAdmin  extends AbstractController<Comptable, ComptableDto, ComptableCriteria, ComptableAdminService, ComptableConverter> {



    @Operation(summary = "upload one comptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple comptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all comptables")
    @GetMapping("")
    public ResponseEntity<List<ComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all comptables")
    @GetMapping("optimized")
    public ResponseEntity<List<ComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a comptable by cin")
    @GetMapping("cin/{cin}")
    public ResponseEntity<ComptableDto> findByCin(@PathVariable String cin) {
        return super.findByReferenceEntity(new Comptable(cin));
    }

    @Operation(summary = "Saves the specified  comptable")
    @PostMapping("")
    public ResponseEntity<ComptableDto> save(@RequestBody ComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  comptable")
    @PutMapping("")
    public ResponseEntity<ComptableDto> update(@RequestBody ComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of comptable")
    @PostMapping("multiple")
    public ResponseEntity<List<ComptableDto>> delete(@RequestBody List<ComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified comptable")
    @DeleteMapping("")
    public ResponseEntity<ComptableDto> delete(@RequestBody ComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified comptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple comptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a comptable and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ComptableDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds comptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ComptableDto>> findByCriteria(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated comptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports comptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets comptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ComptableRestAdmin (ComptableAdminService service, ComptableConverter converter) {
        super(service, converter);
    }




}
