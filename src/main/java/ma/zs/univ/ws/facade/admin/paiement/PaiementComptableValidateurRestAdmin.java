package  ma.zs.univ.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.paiement.PaiementComptableValidateur;
import ma.zs.univ.dao.criteria.core.paiement.PaiementComptableValidateurCriteria;
import ma.zs.univ.service.facade.admin.paiement.PaiementComptableValidateurAdminService;
import ma.zs.univ.ws.converter.paiement.PaiementComptableValidateurConverter;
import ma.zs.univ.ws.dto.paiement.PaiementComptableValidateurDto;
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
@RequestMapping("/api/admin/paiementComptableValidateur/")
public class PaiementComptableValidateurRestAdmin  extends AbstractController<PaiementComptableValidateur, PaiementComptableValidateurDto, PaiementComptableValidateurCriteria, PaiementComptableValidateurAdminService, PaiementComptableValidateurConverter> {



    @Operation(summary = "upload one paiementComptableValidateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementComptableValidateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementComptableValidateurs")
    @GetMapping("")
    public ResponseEntity<List<PaiementComptableValidateurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementComptableValidateurs")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementComptableValidateurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementComptableValidateur by code")
    @GetMapping("code/{code}")
    public ResponseEntity<PaiementComptableValidateurDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new PaiementComptableValidateur(code));
    }

    @Operation(summary = "Saves the specified  paiementComptableValidateur")
    @PostMapping("")
    public ResponseEntity<PaiementComptableValidateurDto> save(@RequestBody PaiementComptableValidateurDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementComptableValidateur")
    @PutMapping("")
    public ResponseEntity<PaiementComptableValidateurDto> update(@RequestBody PaiementComptableValidateurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementComptableValidateur")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementComptableValidateurDto>> delete(@RequestBody List<PaiementComptableValidateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementComptableValidateur")
    @DeleteMapping("")
    public ResponseEntity<PaiementComptableValidateurDto> delete(@RequestBody PaiementComptableValidateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementComptableValidateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementComptableValidateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by demande id")
    @GetMapping("demande/id/{id}")
    public List<PaiementComptableValidateurDto> findByDemandeId(@PathVariable Long id){
        return findDtos(service.findByDemandeId(id));
    }
    @Operation(summary = "delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @Operation(summary = "find by comptableValidateur id")
    @GetMapping("comptableValidateur/id/{id}")
    public List<PaiementComptableValidateurDto> findByComptableValidateurId(@PathVariable Long id){
        return findDtos(service.findByComptableValidateurId(id));
    }
    @Operation(summary = "delete by comptableValidateur id")
    @DeleteMapping("comptableValidateur/id/{id}")
    public int deleteByComptableValidateurId(@PathVariable Long id){
        return service.deleteByComptableValidateurId(id);
    }
    @Operation(summary = "find by typePaiement id")
    @GetMapping("typePaiement/id/{id}")
    public List<PaiementComptableValidateurDto> findByTypePaiementId(@PathVariable Long id){
        return findDtos(service.findByTypePaiementId(id));
    }
    @Operation(summary = "delete by typePaiement id")
    @DeleteMapping("typePaiement/id/{id}")
    public int deleteByTypePaiementId(@PathVariable Long id){
        return service.deleteByTypePaiementId(id);
    }

    @Operation(summary = "Finds a paiementComptableValidateur and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementComptableValidateurDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paiementComptableValidateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementComptableValidateurDto>> findByCriteria(@RequestBody PaiementComptableValidateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementComptableValidateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementComptableValidateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementComptableValidateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementComptableValidateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementComptableValidateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementComptableValidateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementComptableValidateurRestAdmin (PaiementComptableValidateurAdminService service, PaiementComptableValidateurConverter converter) {
        super(service, converter);
    }




}
