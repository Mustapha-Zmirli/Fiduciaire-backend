package  ma.zs.univ.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.demande.DemandeConverter;
import ma.zs.univ.ws.converter.paiement.TypePaiementConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.paiement.PaiementDemande;
import ma.zs.univ.ws.dto.paiement.PaiementDemandeDto;

@Component
public class PaiementDemandeConverter extends AbstractConverter<PaiementDemande, PaiementDemandeDto> {

    @Autowired
    private DemandeConverter demandeConverter ;
    @Autowired
    private TypePaiementConverter typePaiementConverter ;
    private boolean demande;
    private boolean typePaiement;

    public  PaiementDemandeConverter() {
        super(PaiementDemande.class, PaiementDemandeDto.class);
        init(true);
    }

    @Override
    public PaiementDemande toItem(PaiementDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementDemande item = new PaiementDemande();
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

            if(this.typePaiement && dto.getTypePaiement()!=null)
                item.setTypePaiement(typePaiementConverter.toItem(dto.getTypePaiement())) ;




        return item;
        }
    }

    @Override
    public PaiementDemandeDto toDto(PaiementDemande item) {
        if (item == null) {
            return null;
        } else {
            PaiementDemandeDto dto = new PaiementDemandeDto();
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
            if(this.typePaiement && item.getTypePaiement()!=null) {
                dto.setTypePaiement(typePaiementConverter.toDto(item.getTypePaiement())) ;

            }


        return dto;
        }
    }

    public void copy(PaiementDemandeDto dto, PaiementDemande t) {
    super.copy(dto, t);
    if (dto.getDemande() != null)
        demandeConverter.copy(dto.getDemande(), t.getDemande());
    if (dto.getTypePaiement() != null)
        typePaiementConverter.copy(dto.getTypePaiement(), t.getTypePaiement());
    }



    public void initObject(boolean value) {
        this.demande = value;
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
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
    public boolean  isTypePaiement(){
        return this.typePaiement;
    }
    public void  setTypePaiement(boolean typePaiement){
        this.typePaiement = typePaiement;
    }
}
