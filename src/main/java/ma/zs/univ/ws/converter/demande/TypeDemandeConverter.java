package  ma.zs.univ.ws.converter.demande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.demande.TypeDemande;
import ma.zs.univ.ws.dto.demande.TypeDemandeDto;

@Component
public class TypeDemandeConverter extends AbstractConverter<TypeDemande, TypeDemandeDto> {


    public  TypeDemandeConverter() {
        super(TypeDemande.class, TypeDemandeDto.class);
    }

    @Override
    public TypeDemande toItem(TypeDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeDemande item = new TypeDemande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getHonnoraireComptableTraitant()))
                item.setHonnoraireComptableTraitant(dto.getHonnoraireComptableTraitant());
            if(StringUtil.isNotEmpty(dto.getHonnoraireComptableValidateur()))
                item.setHonnoraireComptableValidateur(dto.getHonnoraireComptableValidateur());



        return item;
        }
    }

    @Override
    public TypeDemandeDto toDto(TypeDemande item) {
        if (item == null) {
            return null;
        } else {
            TypeDemandeDto dto = new TypeDemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getHonnoraireComptableTraitant()))
                dto.setHonnoraireComptableTraitant(item.getHonnoraireComptableTraitant());
            if(StringUtil.isNotEmpty(item.getHonnoraireComptableValidateur()))
                dto.setHonnoraireComptableValidateur(item.getHonnoraireComptableValidateur());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
