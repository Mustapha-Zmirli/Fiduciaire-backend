package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.CategorieComptable;
import ma.zs.univ.ws.dto.commun.CategorieComptableDto;

@Component
public class CategorieComptableConverter extends AbstractConverter<CategorieComptable, CategorieComptableDto> {


    public  CategorieComptableConverter() {
        super(CategorieComptable.class, CategorieComptableDto.class);
    }

    @Override
    public CategorieComptable toItem(CategorieComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieComptable item = new CategorieComptable();
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
    public CategorieComptableDto toDto(CategorieComptable item) {
        if (item == null) {
            return null;
        } else {
            CategorieComptableDto dto = new CategorieComptableDto();
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
