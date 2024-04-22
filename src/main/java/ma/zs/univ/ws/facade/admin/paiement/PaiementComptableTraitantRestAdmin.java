package  ma.zs.univ.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableTraitantCriteria;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableTraitantAdminService;
import ma.zs.univ.ws.converter.paiement.PaiementComptableTraitantConverter;
import ma.zs.univ.ws.dto.paiement.PaiementComptableTraitantDto;
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
@RequestMapping("/api/admin/paiementComptableTraitant/")
public class PaiementComptableTraitantRestAdmin  extends AbstractController<PaiementComptableTraitant, PaiementComptableTraitantDto, PaiementComptableTraitantCriteria, PaiementComptableTraitantAdminService, PaiementComptableTraitantConverter> {



    @Operation(summary = "upload one paiementComptableTraitant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementComptableTraitants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementComptableTraitants")
    @GetMapping("")
    public ResponseEntity<List<PaiementComptableTraitantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementComptableTraitants")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementComptableTraitantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementComptableTraitant by code")
    @GetMapping("code/{code}")
    public ResponseEntity<PaiementComptableTraitantDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new PaiementComptableTraitant(code));
    }

    @Operation(summary = "Saves the specified  paiementComptableTraitant")
    @PostMapping("")
    public ResponseEntity<PaiementComptableTraitantDto> save(@RequestBody PaiementComptableTraitantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementComptableTraitant")
    @PutMapping("")
    public ResponseEntity<PaiementComptableTraitantDto> update(@RequestBody PaiementComptableTraitantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementComptableTraitant")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementComptableTraitantDto>> delete(@RequestBody List<PaiementComptableTraitantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementComptableTraitant")
    @DeleteMapping("")
    public ResponseEntity<PaiementComptableTraitantDto> delete(@RequestBody PaiementComptableTraitantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementComptableTraitant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementComptableTraitants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by demande id")
    @GetMapping("demande/id/{id}")
    public List<PaiementComptableTraitantDto> findByDemandeId(@PathVariable Long id){
        return findDtos(service.findByDemandeId(id));
    }
    @Operation(summary = "delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @Operation(summary = "find by comptableTraitant id")
    @GetMapping("comptableTraitant/id/{id}")
    public List<PaiementComptableTraitantDto> findByComptableTraitantId(@PathVariable Long id){
        return findDtos(service.findByComptableTraitantId(id));
    }
    @Operation(summary = "delete by comptableTraitant id")
    @DeleteMapping("comptableTraitant/id/{id}")
    public int deleteByComptableTraitantId(@PathVariable Long id){
        return service.deleteByComptableTraitantId(id);
    }
    @Operation(summary = "find by typePaiement id")
    @GetMapping("typePaiement/id/{id}")
    public List<PaiementComptableTraitantDto> findByTypePaiementId(@PathVariable Long id){
        return findDtos(service.findByTypePaiementId(id));
    }
    @Operation(summary = "delete by typePaiement id")
    @DeleteMapping("typePaiement/id/{id}")
    public int deleteByTypePaiementId(@PathVariable Long id){
        return service.deleteByTypePaiementId(id);
    }

    @Operation(summary = "Finds a paiementComptableTraitant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementComptableTraitantDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paiementComptableTraitants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementComptableTraitantDto>> findByCriteria(@RequestBody PaiementComptableTraitantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementComptableTraitants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementComptableTraitantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementComptableTraitants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementComptableTraitantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementComptableTraitant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementComptableTraitantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementComptableTraitantRestAdmin (PaiementComptableTraitantAdminService service, PaiementComptableTraitantConverter converter) {
        super(service, converter);
    }




}
