package  ma.zs.univ.ws.dto.paiement;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.univ.ws.dto.demande.DemandeDto;
import ma.zs.univ.ws.dto.commun.ComptableDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementComptableValidateurDto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal montant  ;
    private String datePaiement ;

    private DemandeDto demande ;
    private ComptableDto comptableValidateur ;
    private TypePaiementDto typePaiement ;



    public PaiementComptableValidateurDto(){
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }


    public DemandeDto getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeDto demande){
        this.demande = demande;
    }
    public ComptableDto getComptableValidateur(){
        return this.comptableValidateur;
    }

    public void setComptableValidateur(ComptableDto comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
    public TypePaiementDto getTypePaiement(){
        return this.typePaiement;
    }

    public void setTypePaiement(TypePaiementDto typePaiement){
        this.typePaiement = typePaiement;
    }






}
