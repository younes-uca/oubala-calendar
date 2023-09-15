package  emsi.sir.oubala.dao.specification.history.commun;

import emsi.sir.oubala.zynerator.specification.AbstractHistorySpecification;
import emsi.sir.oubala.dao.criteria.history.commun.ProductHistoryCriteria;
import emsi.sir.oubala.bean.history.commun.ProductHistory;


public class ProductHistorySpecification extends AbstractHistorySpecification<ProductHistoryCriteria, ProductHistory> {

    public ProductHistorySpecification(ProductHistoryCriteria criteria) {
        super(criteria);
    }

    public ProductHistorySpecification(ProductHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
