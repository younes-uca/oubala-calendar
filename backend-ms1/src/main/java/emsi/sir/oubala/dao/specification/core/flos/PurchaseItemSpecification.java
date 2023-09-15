package  emsi.sir.oubala.dao.specification.core.flos;

import emsi.sir.oubala.zynerator.specification.AbstractSpecification;
import emsi.sir.oubala.dao.criteria.core.flos.PurchaseItemCriteria;
import emsi.sir.oubala.bean.core.flos.PurchaseItem;


public class PurchaseItemSpecification extends  AbstractSpecification<PurchaseItemCriteria, PurchaseItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","code", criteria.getProduct()==null?null:criteria.getProduct().getCode());
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria) {
        super(criteria);
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
