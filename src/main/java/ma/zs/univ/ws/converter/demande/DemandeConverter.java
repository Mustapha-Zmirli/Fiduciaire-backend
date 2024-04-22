package  ma.zs.univ.ws.converter.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.commun.SocieteConverter;
import ma.zs.univ.ws.converter.demande.EtatDemandeConverter;
import ma.zs.univ.ws.converter.demande.TypeDemandeConverter;
import ma.zs.univ.ws.converter.commun.ComptableConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.demande.Demande;
import ma.zs.univ.ws.dto.demande.DemandeDto;

@Component
public class DemandeConverter extends AbstractConverter<Demande, DemandeDto> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private EtatDemandeConverter etatDemandeConverter ;
    @Autowired
    private TypeDemandeConverter typeDemandeConverter ;
    @Autowired
    private ComptableConverter comptableConverter ;
    private boolean societe;
    private boolean typeDemande;
    private boolean etatDemande;
    private boolean comptableValidateur;
    private boolean comptableTraitant;

    public  DemandeConverter() {
        super(Demande.class, DemandeDto.class);
        init(true);
    }

    @Override
    public Demande toItem(DemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Demande item = new Demande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateDemande()))
                item.setDateDemande(DateUtil.stringEnToDate(dto.getDateDemande()));
            if(StringUtil.isNotEmpty(dto.getDateExigibilite()))
                item.setDateExigibilite(DateUtil.stringEnToDate(dto.getDateExigibilite()));
            if(StringUtil.isNotEmpty(dto.getDateValidation()))
                item.setDateValidation(DateUtil.stringEnToDate(dto.getDateValidation()));
            if(StringUtil.isNotEmpty(dto.getDateTraitement()))
                item.setDateTraitement(DateUtil.stringEnToDate(dto.getDateTraitement()));
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;

            if(this.typeDemande && dto.getTypeDemande()!=null)
                item.setTypeDemande(typeDemandeConverter.toItem(dto.getTypeDemande())) ;

            if(this.etatDemande && dto.getEtatDemande()!=null)
                item.setEtatDemande(etatDemandeConverter.toItem(dto.getEtatDemande())) ;

            if(this.comptableValidateur && dto.getComptableValidateur()!=null)
                item.setComptableValidateur(comptableConverter.toItem(dto.getComptableValidateur())) ;

            if(this.comptableTraitant && dto.getComptableTraitant()!=null)
                item.setComptableTraitant(comptableConverter.toItem(dto.getComptableTraitant())) ;




        return item;
        }
    }

    @Override
    public DemandeDto toDto(Demande item) {
        if (item == null) {
            return null;
        } else {
            DemandeDto dto = new DemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getDateDemande()!=null)
                dto.setDateDemande(DateUtil.dateTimeToString(item.getDateDemande()));
            if(item.getDateExigibilite()!=null)
                dto.setDateExigibilite(DateUtil.dateTimeToString(item.getDateExigibilite()));
            if(item.getDateValidation()!=null)
                dto.setDateValidation(DateUtil.dateTimeToString(item.getDateValidation()));
            if(item.getDateTraitement()!=null)
                dto.setDateTraitement(DateUtil.dateTimeToString(item.getDateTraitement()));
            if(this.societe && item.getSociete()!=null) {
                dto.setSociete(societeConverter.toDto(item.getSociete())) ;

            }
            if(this.typeDemande && item.getTypeDemande()!=null) {
                dto.setTypeDemande(typeDemandeConverter.toDto(item.getTypeDemande())) ;

            }
            if(this.etatDemande && item.getEtatDemande()!=null) {
                dto.setEtatDemande(etatDemandeConverter.toDto(item.getEtatDemande())) ;

            }
            if(this.comptableValidateur && item.getComptableValidateur()!=null) {
                dto.setComptableValidateur(comptableConverter.toDto(item.getComptableValidateur())) ;

            }
            if(this.comptableTraitant && item.getComptableTraitant()!=null) {
                dto.setComptableTraitant(comptableConverter.toDto(item.getComptableTraitant())) ;

            }


        return dto;
        }
    }

    public void copy(DemandeDto dto, Demande t) {
    super.copy(dto, t);
    if (dto.getSociete() != null)
        societeConverter.copy(dto.getSociete(), t.getSociete());
    if (dto.getTypeDemande() != null)
        typeDemandeConverter.copy(dto.getTypeDemande(), t.getTypeDemande());
    if (dto.getEtatDemande() != null)
        etatDemandeConverter.copy(dto.getEtatDemande(), t.getEtatDemande());
    if (dto.getComptableValidateur() != null)
        comptableConverter.copy(dto.getComptableValidateur(), t.getComptableValidateur());
    if (dto.getComptableTraitant() != null)
        comptableConverter.copy(dto.getComptableTraitant(), t.getComptableTraitant());
    }



    public void initObject(boolean value) {
        this.societe = value;
        this.typeDemande = value;
        this.etatDemande = value;
        this.comptableValidateur = value;
        this.comptableTraitant = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public EtatDemandeConverter getEtatDemandeConverter(){
        return this.etatDemandeConverter;
    }
    public void setEtatDemandeConverter(EtatDemandeConverter etatDemandeConverter ){
        this.etatDemandeConverter = etatDemandeConverter;
    }
    public TypeDemandeConverter getTypeDemandeConverter(){
        return this.typeDemandeConverter;
    }
    public void setTypeDemandeConverter(TypeDemandeConverter typeDemandeConverter ){
        this.typeDemandeConverter = typeDemandeConverter;
    }
    public ComptableConverter getComptableConverter(){
        return this.comptableConverter;
    }
    public void setComptableConverter(ComptableConverter comptableConverter ){
        this.comptableConverter = comptableConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isTypeDemande(){
        return this.typeDemande;
    }
    public void  setTypeDemande(boolean typeDemande){
        this.typeDemande = typeDemande;
    }
    public boolean  isEtatDemande(){
        return this.etatDemande;
    }
    public void  setEtatDemande(boolean etatDemande){
        this.etatDemande = etatDemande;
    }
    public boolean  isComptableValidateur(){
        return this.comptableValidateur;
    }
    public void  setComptableValidateur(boolean comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
    public boolean  isComptableTraitant(){
        return this.comptableTraitant;
    }
    public void  setComptableTraitant(boolean comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
}
