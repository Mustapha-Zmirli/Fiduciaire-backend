package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Comptable;
import ma.zs.univ.ws.dto.commun.ComptableDto;

@Component
public class ComptableConverter extends AbstractConverter<Comptable, ComptableDto> {


    public  ComptableConverter() {
        super(Comptable.class, ComptableDto.class);
    }

    @Override
    public Comptable toItem(ComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        Comptable item = new Comptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getCategorieComptable()))
                item.setCategorieComptable(dto.getCategorieComptable());



        return item;
        }
    }

    @Override
    public ComptableDto toDto(Comptable item) {
        if (item == null) {
            return null;
        } else {
            ComptableDto dto = new ComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getCategorieComptable()))
                dto.setCategorieComptable(item.getCategorieComptable());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
