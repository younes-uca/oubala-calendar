package emsi.sir.oubala.dao.facade.core.flos;

import emsi.sir.oubala.zynerator.repository.AbstractRepository;
import emsi.sir.oubala.bean.core.flos.PurchaseItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseItemDao extends AbstractRepository<PurchaseItem,Long>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);


}
