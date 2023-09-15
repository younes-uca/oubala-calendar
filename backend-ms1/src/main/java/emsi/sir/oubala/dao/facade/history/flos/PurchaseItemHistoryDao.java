package emsi.sir.oubala.dao.facade.history.flos;

import emsi.sir.oubala.zynerator.repository.AbstractHistoryRepository;
import emsi.sir.oubala.bean.history.flos.PurchaseItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemHistoryDao extends AbstractHistoryRepository<PurchaseItemHistory,Long> {

}
