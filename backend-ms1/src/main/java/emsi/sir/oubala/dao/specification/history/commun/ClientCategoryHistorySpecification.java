package  emsi.sir.oubala.dao.specification.history.commun;

import emsi.sir.oubala.zynerator.specification.AbstractHistorySpecification;
import emsi.sir.oubala.dao.criteria.history.commun.ClientCategoryHistoryCriteria;
import emsi.sir.oubala.bean.history.commun.ClientCategoryHistory;


public class ClientCategoryHistorySpecification extends AbstractHistorySpecification<ClientCategoryHistoryCriteria, ClientCategoryHistory> {

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria) {
        super(criteria);
    }

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
