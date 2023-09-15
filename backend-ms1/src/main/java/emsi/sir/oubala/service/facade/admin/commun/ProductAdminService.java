package emsi.sir.oubala.service.facade.admin.commun;

import java.util.List;
import emsi.sir.oubala.bean.core.commun.Product;
import emsi.sir.oubala.dao.criteria.core.commun.ProductCriteria;
import emsi.sir.oubala.dao.criteria.history.commun.ProductHistoryCriteria;
import emsi.sir.oubala.zynerator.service.IService;


public interface ProductAdminService extends  IService<Product,ProductCriteria, ProductHistoryCriteria>  {




}
