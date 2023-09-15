package emsi.sir.oubala.dao.facade.history.commun;

import emsi.sir.oubala.zynerator.repository.AbstractHistoryRepository;
import emsi.sir.oubala.bean.history.commun.ProductHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryDao extends AbstractHistoryRepository<ProductHistory,Long> {

}
