package  ma.zs.univ.ws.facade.admin.demande;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.dao.criteria.core.demande.DemandeCriteria;
import ma.zs.univ.service.facade.admin.demande.DemandeAdminService;
import ma.zs.univ.service.impl.admin.demande.DemandeAdminServiceImpl;
import ma.zs.univ.ws.converter.demande.DemandeConverter;
import ma.zs.univ.ws.dto.demande.DemandeDto;
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
@RequestMapping("/api/admin/demande/")
public class DemandeRestAdmin  extends AbstractController<Demande, DemandeDto, DemandeCriteria, DemandeAdminService, DemandeConverter> {




    @Operation(summary = "upload one demande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple demandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all demandes")
    @GetMapping("")
    public ResponseEntity<List<DemandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all demandes")
    @GetMapping("optimized")
    public ResponseEntity<List<DemandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a demande by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<DemandeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Demande(libelle));
    }

    @Operation(summary = "Saves the specified  demande")
    @PostMapping("")
    public ResponseEntity<DemandeDto> save(@RequestBody DemandeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  demande")
    @PutMapping("")
    public ResponseEntity<DemandeDto> update(@RequestBody DemandeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of demande")
    @PostMapping("multiple")
    public ResponseEntity<List<DemandeDto>> delete(@RequestBody List<DemandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified demande")
    @DeleteMapping("")
    public ResponseEntity<DemandeDto> delete(@RequestBody DemandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified demande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple demandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by societe id")
    @GetMapping("societe/id/{id}")
    public List<DemandeDto> findBySocieteId(@PathVariable Long id){
        return findDtos(service.findBySocieteId(id));
    }
    @Operation(summary = "delete by societe id")
    @DeleteMapping("societe/id/{id}")
    public int deleteBySocieteId(@PathVariable Long id){
        return service.deleteBySocieteId(id);
    }
    @Operation(summary = "find by typeDemande id")
    @GetMapping("typeDemande/id/{id}")
    public List<DemandeDto> findByTypeDemandeId(@PathVariable Long id){
        return findDtos(service.findByTypeDemandeId(id));
    }
    @Operation(summary = "delete by typeDemande id")
    @DeleteMapping("typeDemande/id/{id}")
    public int deleteByTypeDemandeId(@PathVariable Long id){
        return service.deleteByTypeDemandeId(id);
    }
    @Operation(summary = "find by etatDemande id")
    @GetMapping("etatDemande/id/{id}")
    public List<DemandeDto> findByEtatDemandeId(@PathVariable Long id){
        return findDtos(service.findByEtatDemandeId(id));
    }
    @Operation(summary = "delete by etatDemande id")
    @DeleteMapping("etatDemande/id/{id}")
    public int deleteByEtatDemandeId(@PathVariable Long id){
        return service.deleteByEtatDemandeId(id);
    }
    @Operation(summary = "find by comptableValidateur id")
    @GetMapping("comptableValidateur/id/{id}")
    public List<DemandeDto> findByComptableValidateurId(@PathVariable Long id){
        return findDtos(service.findByComptableValidateurId(id));
    }
    @Operation(summary = "delete by comptableValidateur id")
    @DeleteMapping("comptableValidateur/id/{id}")
    public int deleteByComptableValidateurId(@PathVariable Long id){
        return service.deleteByComptableValidateurId(id);
    }
    @Operation(summary = "find by comptableTraitant id")
    @GetMapping("comptableTraitant/id/{id}")
    public List<DemandeDto> findByComptableTraitantId(@PathVariable Long id){
        return findDtos(service.findByComptableTraitantId(id));
    }
    @Operation(summary = "delete by comptableTraitant id")
    @DeleteMapping("comptableTraitant/id/{id}")
    public int deleteByComptableTraitantId(@PathVariable Long id){
        return service.deleteByComptableTraitantId(id);
    }

    @Operation(summary = "Finds a demande and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DemandeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds demandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DemandeDto>> findByCriteria(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated demandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports demandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets demande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DemandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @GetMapping("demandeTraite")
    public List<Demande> getDemandeTraite() {
        return demandeAdminService.getDemandeTraite();
    }

    @GetMapping("demandeEnAttente")
    public List<Demande> getDemandeEnAttente() {
        return demandeAdminService.getDemandeEnAttente();
    }
    @GetMapping("demandesAcceptees")
    public List<Demande> getListDemandesAcceptees() {
        return demandeAdminService.getListDemandesAcceptees();
    }

    @PutMapping("accepterDemande/code/{code}")
    public int accepterDemande(@PathVariable String code){
        return service.accepterDemande(code);
    }
    @PutMapping("refuserDemande/code/{code}")
    public int refuserDemande(@PathVariable String code){
        return service.refuserDemande(code);
    }

    @PutMapping("finaliserDemande/code/{code}")
    public int finaliserDemande(@PathVariable String code){
        return service.finaliserDemande(code);
    }

    @PutMapping("{code}")
    public int validerDemande(@PathVariable String code) {
        return demandeAdminService.validerDemande(code);
    }

    public DemandeRestAdmin (DemandeAdminService service, DemandeConverter converter) {
        super(service, converter);
    }

    @Autowired
    private DemandeAdminServiceImpl demandeAdminService;



}
