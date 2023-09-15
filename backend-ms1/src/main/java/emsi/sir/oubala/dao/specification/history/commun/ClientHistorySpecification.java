package  emsi.sir.oubala.dao.specification.history.commun;

import emsi.sir.oubala.zynerator.specification.AbstractHistorySpecification;
import emsi.sir.oubala.dao.criteria.history.commun.ClientHistoryCriteria;
import emsi.sir.oubala.bean.history.commun.ClientHistory;


public class ClientHistorySpecification extends AbstractHistorySpecification<ClientHistoryCriteria, ClientHistory> {

    public ClientHistorySpecification(ClientHistoryCriteria criteria) {
        super(criteria);
    }

    public ClientHistorySpecification(ClientHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
