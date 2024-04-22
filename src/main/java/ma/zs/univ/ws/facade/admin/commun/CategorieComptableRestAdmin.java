package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.dao.criteria.core.commun.CategorieComptableCriteria;
import ma.zs.univ.service.facade.admin.commun.CategorieComptableAdminService;
import ma.zs.univ.ws.converter.commun.CategorieComptableConverter;
import ma.zs.univ.ws.dto.commun.CategorieComptableDto;
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
@RequestMapping("/api/admin/categorieComptable/")
public class CategorieComptableRestAdmin  extends AbstractController<CategorieComptable, CategorieComptableDto, CategorieComptableCriteria, CategorieComptableAdminService, CategorieComptableConverter> {



    @Operation(summary = "upload one categorieComptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categorieComptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categorieComptables")
    @GetMapping("")
    public ResponseEntity<List<CategorieComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categorieComptables")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorieComptable by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CategorieComptableDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new CategorieComptable(libelle));
    }

    @Operation(summary = "Saves the specified  categorieComptable")
    @PostMapping("")
    public ResponseEntity<CategorieComptableDto> save(@RequestBody CategorieComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorieComptable")
    @PutMapping("")
    public ResponseEntity<CategorieComptableDto> update(@RequestBody CategorieComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorieComptable")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieComptableDto>> delete(@RequestBody List<CategorieComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorieComptable")
    @DeleteMapping("")
    public ResponseEntity<CategorieComptableDto> delete(@RequestBody CategorieComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorieComptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categorieComptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categorieComptable and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieComptableDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds categorieComptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieComptableDto>> findByCriteria(@RequestBody CategorieComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categorieComptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categorieComptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorieComptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieComptableRestAdmin (CategorieComptableAdminService service, CategorieComptableConverter converter) {
        super(service, converter);
    }




}
