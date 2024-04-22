package  ma.zs.univ.ws.facade.admin.demande;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.dao.criteria.core.demande.TypeDemandeCriteria;
import ma.zs.univ.service.facade.admin.demande.TypeDemandeAdminService;
import ma.zs.univ.ws.converter.demande.TypeDemandeConverter;
import ma.zs.univ.ws.dto.demande.TypeDemandeDto;
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
@RequestMapping("/api/admin/typeDemande/")
public class TypeDemandeRestAdmin  extends AbstractController<TypeDemande, TypeDemandeDto, TypeDemandeCriteria, TypeDemandeAdminService, TypeDemandeConverter> {



    @Operation(summary = "upload one typeDemande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeDemandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeDemandes")
    @GetMapping("")
    public ResponseEntity<List<TypeDemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeDemandes")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeDemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeDemande by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeDemandeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypeDemande(libelle));
    }

    @Operation(summary = "Saves the specified  typeDemande")
    @PostMapping("")
    public ResponseEntity<TypeDemandeDto> save(@RequestBody TypeDemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeDemande")
    @PutMapping("")
    public ResponseEntity<TypeDemandeDto> update(@RequestBody TypeDemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeDemande")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeDemandeDto>> delete(@RequestBody List<TypeDemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeDemande")
    @DeleteMapping("")
    public ResponseEntity<TypeDemandeDto> delete(@RequestBody TypeDemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeDemande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeDemandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeDemande and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeDemandeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeDemandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeDemandeDto>> findByCriteria(@RequestBody TypeDemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeDemandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeDemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeDemandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeDemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeDemande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeDemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeDemandeRestAdmin (TypeDemandeAdminService service, TypeDemandeConverter converter) {
        super(service, converter);
    }




}
