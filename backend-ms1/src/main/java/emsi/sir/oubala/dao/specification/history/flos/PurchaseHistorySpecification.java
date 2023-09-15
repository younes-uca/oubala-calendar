package  emsi.sir.oubala.dao.specification.history.flos;

import emsi.sir.oubala.zynerator.specification.AbstractHistorySpecification;
import emsi.sir.oubala.dao.criteria.history.flos.PurchaseHistoryCriteria;
import emsi.sir.oubala.bean.history.flos.PurchaseHistory;


public class PurchaseHistorySpecification extends AbstractHistorySpecification<PurchaseHistoryCriteria, PurchaseHistory> {

    public PurchaseHistorySpecification(PurchaseHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseHistorySpecification(PurchaseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
