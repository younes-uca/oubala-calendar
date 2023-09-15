package emsi.sir.oubala.service.impl.admin.flos;


import emsi.sir.oubala.bean.core.flos.Purchase;
import emsi.sir.oubala.bean.history.flos.PurchaseHistory;
import emsi.sir.oubala.dao.criteria.core.flos.PurchaseCriteria;
import emsi.sir.oubala.dao.criteria.history.flos.PurchaseHistoryCriteria;
import emsi.sir.oubala.dao.facade.core.flos.PurchaseDao;
import emsi.sir.oubala.dao.facade.history.flos.PurchaseHistoryDao;
import emsi.sir.oubala.dao.specification.core.flos.PurchaseSpecification;
import emsi.sir.oubala.service.facade.admin.flos.PurchaseAdminService;
import emsi.sir.oubala.zynerator.service.AbstractServiceImpl;
import emsi.sir.oubala.zynerator.service.Attribute;
import emsi.sir.oubala.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import emsi.sir.oubala.zynerator.dto.ScheduleDto;

import emsi.sir.oubala.zynerator.util.VelocityPdf;
import emsi.sir.oubala.ws.dto.flos.PurchaseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import emsi.sir.oubala.service.facade.admin.flos.PurchaseItemAdminService ;
import emsi.sir.oubala.bean.core.flos.PurchaseItem ;
import emsi.sir.oubala.service.facade.admin.commun.ClientAdminService ;
import emsi.sir.oubala.bean.core.commun.Client ;


import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase,PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
PurchaseHistoryDao> implements PurchaseAdminService {
    public static final String TEMPLATE = "template/purchase.vm";
    public static final String FILE_NAME = "purchase.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));



    ATTRIBUTES.add(new Attribute("image"));

    ATTRIBUTES.add(new Attribute("etat","Boolean"));

    ATTRIBUTES.add(new Attribute("total","BigDecimal"));

    ATTRIBUTES.add(new Attribute("description"));


    }

    @Override
    public HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);
        if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(t);
                    purchaseItemService.create(element);
            });
        }
        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
    }
    }




    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public List<ScheduleDto> findByMonth(int month){
        List<ScheduleDto> results  = dao.findByMonth(month);
        return results;
    }
    public void configure() {
        super.configure(Purchase.class,PurchaseHistory.class, PurchaseHistoryCriteria.class, PurchaseSpecification.class);
    }


    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PurchaseAdminServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}