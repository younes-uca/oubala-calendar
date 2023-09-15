package  emsi.sir.oubala.dao.specification.core.commun;

import emsi.sir.oubala.zynerator.specification.AbstractSpecification;
import emsi.sir.oubala.dao.criteria.core.commun.ClientCriteria;
import emsi.sir.oubala.bean.core.commun.Client;


public class ClientSpecification extends  AbstractSpecification<ClientCriteria, Client>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("fullName", criteria.getFullName(),criteria.getFullNameLike());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicateFk("clientCategory","id", criteria.getClientCategory()==null?null:criteria.getClientCategory().getId());
        addPredicateFk("clientCategory","id", criteria.getClientCategorys());
        addPredicateFk("clientCategory","code", criteria.getClientCategory()==null?null:criteria.getClientCategory().getCode());
    }

    public ClientSpecification(ClientCriteria criteria) {
        super(criteria);
    }

    public ClientSpecification(ClientCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
