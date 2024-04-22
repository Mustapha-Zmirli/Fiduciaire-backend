package  ma.zs.univ.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.dao.criteria.core.paiement.PaiementDemandeCriteria;
import ma.zs.univ.service.facade.admin.paiement.PaiementDemandeAdminService;
import ma.zs.univ.ws.converter.paiement.PaiementDemandeConverter;
import ma.zs.univ.ws.dto.paiement.PaiementDemandeDto;
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
@RequestMapping("/api/admin/paiementDemande/")
public class PaiementDemandeRestAdmin  extends AbstractController<PaiementDemande, PaiementDemandeDto, PaiementDemandeCriteria, PaiementDemandeAdminService, PaiementDemandeConverter> {



    @Operation(summary = "upload one paiementDemande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementDemandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementDemandes")
    @GetMapping("")
    public ResponseEntity<List<PaiementDemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementDemandes")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementDemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementDemande by code")
    @GetMapping("code/{code}")
    public ResponseEntity<PaiementDemandeDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new PaiementDemande(code));
    }

    @Operation(summary = "Saves the specified  paiementDemande")
    @PostMapping("")
    public ResponseEntity<PaiementDemandeDto> save(@RequestBody PaiementDemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementDemande")
    @PutMapping("")
    public ResponseEntity<PaiementDemandeDto> update(@RequestBody PaiementDemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementDemande")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementDemandeDto>> delete(@RequestBody List<PaiementDemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementDemande")
    @DeleteMapping("")
    public ResponseEntity<PaiementDemandeDto> delete(@RequestBody PaiementDemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementDemande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementDemandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by demande id")
    @GetMapping("demande/id/{id}")
    public List<PaiementDemandeDto> findByDemandeId(@PathVariable Long id){
        return findDtos(service.findByDemandeId(id));
    }
    @Operation(summary = "delete by demande id")
    @DeleteMapping("demande/id/{id}")
    public int deleteByDemandeId(@PathVariable Long id){
        return service.deleteByDemandeId(id);
    }
    @Operation(summary = "find by typePaiement id")
    @GetMapping("typePaiement/id/{id}")
    public List<PaiementDemandeDto> findByTypePaiementId(@PathVariable Long id){
        return findDtos(service.findByTypePaiementId(id));
    }
    @Operation(summary = "delete by typePaiement id")
    @DeleteMapping("typePaiement/id/{id}")
    public int deleteByTypePaiementId(@PathVariable Long id){
        return service.deleteByTypePaiementId(id);
    }

    @Operation(summary = "Finds a paiementDemande and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementDemandeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paiementDemandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementDemandeDto>> findByCriteria(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementDemandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementDemandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementDemande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementDemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementDemandeRestAdmin (PaiementDemandeAdminService service, PaiementDemandeConverter converter) {
        super(service, converter);
    }




}
