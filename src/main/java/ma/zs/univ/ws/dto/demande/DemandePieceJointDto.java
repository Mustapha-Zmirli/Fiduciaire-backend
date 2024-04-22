package  ma.zs.univ.ws.dto.demande;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandePieceJointDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private String path  ;

    private DemandeDto demande ;



    public DemandePieceJointDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }


    public DemandeDto getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeDto demande){
        this.demande = demande;
    }






}
