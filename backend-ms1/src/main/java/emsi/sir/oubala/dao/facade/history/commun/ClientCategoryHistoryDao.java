package emsi.sir.oubala.dao.facade.history.commun;

import emsi.sir.oubala.zynerator.repository.AbstractHistoryRepository;
import emsi.sir.oubala.bean.history.commun.ClientCategoryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCategoryHistoryDao extends AbstractHistoryRepository<ClientCategoryHistory,Long> {

}
