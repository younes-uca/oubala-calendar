package  emsi.sir.oubala.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import emsi.sir.oubala.zynerator.util.StringUtil;
import emsi.sir.oubala.zynerator.converter.AbstractConverter;
import emsi.sir.oubala.zynerator.util.DateUtil;
import emsi.sir.oubala.bean.history.commun.ProductHistory;
import emsi.sir.oubala.bean.core.commun.Product;
import emsi.sir.oubala.ws.dto.commun.ProductDto;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto, ProductHistory> {


    public  ProductConverter(){
        super(Product.class, ProductDto.class, ProductHistory.class);
    }

    @Override
    public Product toItem(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
        Product item = new Product();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());



        return item;
        }
    }

    @Override
    public ProductDto toDto(Product item) {
        if (item == null) {
            return null;
        } else {
            ProductDto dto = new ProductDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
