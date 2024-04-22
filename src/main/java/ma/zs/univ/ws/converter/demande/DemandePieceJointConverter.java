package  ma.zs.univ.ws.converter.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.demande.DemandeConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.demande.DemandePieceJoint;
import ma.zs.univ.ws.dto.demande.DemandePieceJointDto;

@Component
public class DemandePieceJointConverter extends AbstractConverter<DemandePieceJoint, DemandePieceJointDto> {

    @Autowired
    private DemandeConverter demandeConverter ;
    private boolean demande;

    public  DemandePieceJointConverter() {
        super(DemandePieceJoint.class, DemandePieceJointDto.class);
        init(true);
    }

    @Override
    public DemandePieceJoint toItem(DemandePieceJointDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandePieceJoint item = new DemandePieceJoint();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPath()))
                item.setPath(dto.getPath());
            if(this.demande && dto.getDemande()!=null)
                item.setDemande(demandeConverter.toItem(dto.getDemande())) ;




        return item;
        }
    }

    @Override
    public DemandePieceJointDto toDto(DemandePieceJoint item) {
        if (item == null) {
            return null;
        } else {
            DemandePieceJointDto dto = new DemandePieceJointDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getPath()))
                dto.setPath(item.getPath());
            if(this.demande && item.getDemande()!=null) {
                dto.setDemande(demandeConverter.toDto(item.getDemande())) ;

            }


        return dto;
        }
    }

    public void copy(DemandePieceJointDto dto, DemandePieceJoint t) {
    super.copy(dto, t);
    if (dto.getDemande() != null)
        demandeConverter.copy(dto.getDemande(), t.getDemande());
    }



    public void initObject(boolean value) {
        this.demande = value;
    }


    public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
    }
    public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
    }
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
}
