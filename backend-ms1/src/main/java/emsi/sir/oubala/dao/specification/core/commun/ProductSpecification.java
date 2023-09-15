package  emsi.sir.oubala.dao.specification.core.commun;

import emsi.sir.oubala.zynerator.specification.AbstractSpecification;
import emsi.sir.oubala.dao.criteria.core.commun.ProductCriteria;
import emsi.sir.oubala.bean.core.commun.Product;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
