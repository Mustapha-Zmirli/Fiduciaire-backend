package  ma.zs.univ.ws.dto.demande;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeDemandeDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private BigDecimal honnoraireComptableTraitant  ;
    private BigDecimal honnoraireComptableValidateur  ;




    public TypeDemandeDto(){
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
    public BigDecimal getHonnoraireComptableTraitant(){
        return this.honnoraireComptableTraitant;
    }
    public void setHonnoraireComptableTraitant(BigDecimal honnoraireComptableTraitant){
        this.honnoraireComptableTraitant = honnoraireComptableTraitant;
    }

    @Log
    public BigDecimal getHonnoraireComptableValidateur(){
        return this.honnoraireComptableValidateur;
    }
    public void setHonnoraireComptableValidateur(BigDecimal honnoraireComptableValidateur){
        this.honnoraireComptableValidateur = honnoraireComptableValidateur;
    }








}
