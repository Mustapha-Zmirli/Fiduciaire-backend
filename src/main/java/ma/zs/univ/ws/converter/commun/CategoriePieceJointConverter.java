package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.CategoriePieceJoint;
import ma.zs.univ.ws.dto.commun.CategoriePieceJointDto;

@Component
public class CategoriePieceJointConverter extends AbstractConverter<CategoriePieceJoint, CategoriePieceJointDto> {


    public  CategoriePieceJointConverter() {
        super(CategoriePieceJoint.class, CategoriePieceJointDto.class);
    }

    @Override
    public CategoriePieceJoint toItem(CategoriePieceJointDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategoriePieceJoint item = new CategoriePieceJoint();
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
    public CategoriePieceJointDto toDto(CategoriePieceJoint item) {
        if (item == null) {
            return null;
        } else {
            CategoriePieceJointDto dto = new CategoriePieceJointDto();
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
