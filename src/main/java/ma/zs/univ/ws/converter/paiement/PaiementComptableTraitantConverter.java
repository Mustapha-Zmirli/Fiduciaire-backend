package  ma.zs.univ.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.demande.DemandeConverter;
import ma.zs.univ.ws.converter.paiement.TypePaiementConverter;
import ma.zs.univ.ws.converter.commun.ComptableConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.paiement.PaiementComptableTraitant;
import ma.zs.univ.ws.dto.paiement.PaiementComptableTraitantDto;

@Component
public class PaiementComptableTraitantConverter extends AbstractConverter<PaiementComptableTraitant, PaiementComptableTraitantDto> {

    @Autowired
    private DemandeConverter demandeConverter ;
    @Autowired
    private TypePaiementConverter typePaiementConverter ;
    @Autowired
    private ComptableConverter comptableConverter ;
    private boolean demande;
    private boolean comptableTraitant;
    private boolean typePaiement;

    public  PaiementComptableTraitantConverter() {
        super(PaiementComptableTraitant.class, PaiementComptableTraitantDto.class);
        init(true);
    }

    @Override
    public PaiementComptableTraitant toItem(PaiementComptableTraitantDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementComptableTraitant item = new PaiementComptableTraitant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(this.demande && dto.getDemande()!=null)
                item.setDemande(demandeConverter.toItem(dto.getDemande())) ;

            if(this.comptableTraitant && dto.getComptableTraitant()!=null)
                item.setComptableTraitant(comptableConverter.toItem(dto.getComptableTraitant())) ;

            if(this.typePaiement && dto.getTypePaiement()!=null)
                item.setTypePaiement(typePaiementConverter.toItem(dto.getTypePaiement())) ;




        return item;
        }
    }

    @Override
    public PaiementComptableTraitantDto toDto(PaiementComptableTraitant item) {
        if (item == null) {
            return null;
        } else {
            PaiementComptableTraitantDto dto = new PaiementComptableTraitantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(this.demande && item.getDemande()!=null) {
                dto.setDemande(demandeConverter.toDto(item.getDemande())) ;

            }
            if(this.comptableTraitant && item.getComptableTraitant()!=null) {
                dto.setComptableTraitant(comptableConverter.toDto(item.getComptableTraitant())) ;

            }
            if(this.typePaiement && item.getTypePaiement()!=null) {
                dto.setTypePaiement(typePaiementConverter.toDto(item.getTypePaiement())) ;

            }


        return dto;
        }
    }

    public void copy(PaiementComptableTraitantDto dto, PaiementComptableTraitant t) {
    super.copy(dto, t);
    if (dto.getDemande() != null)
        demandeConverter.copy(dto.getDemande(), t.getDemande());
    if (dto.getComptableTraitant() != null)
        comptableConverter.copy(dto.getComptableTraitant(), t.getComptableTraitant());
    if (dto.getTypePaiement() != null)
        typePaiementConverter.copy(dto.getTypePaiement(), t.getTypePaiement());
    }



    public void initObject(boolean value) {
        this.demande = value;
        this.comptableTraitant = value;
        this.typePaiement = value;
    }


    public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
    }
    public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
    }
    public TypePaiementConverter getTypePaiementConverter(){
        return this.typePaiementConverter;
    }
    public void setTypePaiementConverter(TypePaiementConverter typePaiementConverter ){
        this.typePaiementConverter = typePaiementConverter;
    }
    public ComptableConverter getComptableConverter(){
        return this.comptableConverter;
    }
    public void setComptableConverter(ComptableConverter comptableConverter ){
        this.comptableConverter = comptableConverter;
    }
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
    public boolean  isComptableTraitant(){
        return this.comptableTraitant;
    }
    public void  setComptableTraitant(boolean comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public boolean  isTypePaiement(){
        return this.typePaiement;
    }
    public void  setTypePaiement(boolean typePaiement){
        this.typePaiement = typePaiement;
    }
}
