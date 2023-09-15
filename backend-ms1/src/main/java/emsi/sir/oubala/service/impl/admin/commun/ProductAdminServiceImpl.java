package emsi.sir.oubala.service.impl.admin.commun;


import emsi.sir.oubala.bean.core.commun.Product;
import emsi.sir.oubala.bean.history.commun.ProductHistory;
import emsi.sir.oubala.dao.criteria.core.commun.ProductCriteria;
import emsi.sir.oubala.dao.criteria.history.commun.ProductHistoryCriteria;
import emsi.sir.oubala.dao.facade.core.commun.ProductDao;
import emsi.sir.oubala.dao.facade.history.commun.ProductHistoryDao;
import emsi.sir.oubala.dao.specification.core.commun.ProductSpecification;
import emsi.sir.oubala.service.facade.admin.commun.ProductAdminService;
import emsi.sir.oubala.zynerator.service.AbstractServiceImpl;
import emsi.sir.oubala.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product,ProductHistory, ProductCriteria, ProductHistoryCriteria, ProductDao,
ProductHistoryDao> implements ProductAdminService {





    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }







    public void configure() {
        super.configure(Product.class,ProductHistory.class, ProductHistoryCriteria.class, ProductSpecification.class);
    }



    public ProductAdminServiceImpl(ProductDao dao, ProductHistoryDao historyDao) {
        super(dao, historyDao);
    }

}