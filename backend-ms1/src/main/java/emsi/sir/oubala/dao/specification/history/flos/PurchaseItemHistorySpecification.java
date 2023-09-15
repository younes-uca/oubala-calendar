package  emsi.sir.oubala.dao.specification.history.flos;

import emsi.sir.oubala.zynerator.specification.AbstractHistorySpecification;
import emsi.sir.oubala.dao.criteria.history.flos.PurchaseItemHistoryCriteria;
import emsi.sir.oubala.bean.history.flos.PurchaseItemHistory;


public class PurchaseItemHistorySpecification extends AbstractHistorySpecification<PurchaseItemHistoryCriteria, PurchaseItemHistory> {

    public PurchaseItemHistorySpecification(PurchaseItemHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseItemHistorySpecification(PurchaseItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
