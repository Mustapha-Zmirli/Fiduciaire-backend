package  ma.zs.univ.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.paiement.TypePaiement;
import ma.zs.univ.dao.criteria.core.paiement.TypePaiementCriteria;
import ma.zs.univ.service.facade.admin.paiement.TypePaiementAdminService;
import ma.zs.univ.ws.converter.paiement.TypePaiementConverter;
import ma.zs.univ.ws.dto.paiement.TypePaiementDto;
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
@RequestMapping("/api/admin/typePaiement/")
public class TypePaiementRestAdmin  extends AbstractController<TypePaiement, TypePaiementDto, TypePaiementCriteria, TypePaiementAdminService, TypePaiementConverter> {



    @Operation(summary = "upload one typePaiement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typePaiements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typePaiements")
    @GetMapping("")
    public ResponseEntity<List<TypePaiementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typePaiements")
    @GetMapping("optimized")
    public ResponseEntity<List<TypePaiementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typePaiement by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypePaiementDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypePaiement(libelle));
    }

    @Operation(summary = "Saves the specified  typePaiement")
    @PostMapping("")
    public ResponseEntity<TypePaiementDto> save(@RequestBody TypePaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typePaiement")
    @PutMapping("")
    public ResponseEntity<TypePaiementDto> update(@RequestBody TypePaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typePaiement")
    @PostMapping("multiple")
    public ResponseEntity<List<TypePaiementDto>> delete(@RequestBody List<TypePaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typePaiement")
    @DeleteMapping("")
    public ResponseEntity<TypePaiementDto> delete(@RequestBody TypePaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typePaiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typePaiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typePaiement and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypePaiementDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typePaiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypePaiementDto>> findByCriteria(@RequestBody TypePaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typePaiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypePaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typePaiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypePaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typePaiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypePaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypePaiementRestAdmin (TypePaiementAdminService service, TypePaiementConverter converter) {
        super(service, converter);
    }




}
