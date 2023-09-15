package emsi.sir.oubala.zynerator.service;

import emsi.sir.oubala.zynerator.audit.AuditBusinessObjectEnhanced;
import emsi.sir.oubala.zynerator.criteria.BaseCriteria;
import emsi.sir.oubala.zynerator.history.HistBusinessObject;
import emsi.sir.oubala.zynerator.history.HistCriteria;
import emsi.sir.oubala.zynerator.repository.AbstractHistoryRepository;
import emsi.sir.oubala.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}