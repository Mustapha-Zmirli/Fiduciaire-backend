package  ma.zs.univ.ws.converter.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.demande.EtatDemande;
import ma.zs.univ.ws.dto.demande.EtatDemandeDto;

@Component
public class EtatDemandeConverter extends AbstractConverter<EtatDemande, EtatDemandeDto> {


    public  EtatDemandeConverter() {
        super(EtatDemande.class, EtatDemandeDto.class);
    }

    @Override
    public EtatDemande toItem(EtatDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatDemande item = new EtatDemande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatDemandeDto toDto(EtatDemande item) {
        if (item == null) {
            return null;
        } else {
            EtatDemandeDto dto = new EtatDemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
