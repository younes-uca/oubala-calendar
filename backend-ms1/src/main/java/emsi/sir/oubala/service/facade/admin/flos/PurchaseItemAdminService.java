package emsi.sir.oubala.service.facade.admin.flos;

import java.util.List;
import emsi.sir.oubala.bean.core.flos.PurchaseItem;
import emsi.sir.oubala.dao.criteria.core.flos.PurchaseItemCriteria;
import emsi.sir.oubala.dao.criteria.history.flos.PurchaseItemHistoryCriteria;
import emsi.sir.oubala.zynerator.service.IService;


public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria, PurchaseItemHistoryCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);



}
