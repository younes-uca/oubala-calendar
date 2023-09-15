package emsi.sir.oubala.service.impl.admin.commun;


import emsi.sir.oubala.bean.core.commun.ClientCategory;
import emsi.sir.oubala.bean.history.commun.ClientCategoryHistory;
import emsi.sir.oubala.dao.criteria.core.commun.ClientCategoryCriteria;
import emsi.sir.oubala.dao.criteria.history.commun.ClientCategoryHistoryCriteria;
import emsi.sir.oubala.dao.facade.core.commun.ClientCategoryDao;
import emsi.sir.oubala.dao.facade.history.commun.ClientCategoryHistoryDao;
import emsi.sir.oubala.dao.specification.core.commun.ClientCategorySpecification;
import emsi.sir.oubala.service.facade.admin.commun.ClientCategoryAdminService;
import emsi.sir.oubala.zynerator.service.AbstractServiceImpl;
import emsi.sir.oubala.zynerator.service.Attribute;
import emsi.sir.oubala.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import emsi.sir.oubala.zynerator.util.VelocityPdf;
import emsi.sir.oubala.ws.dto.commun.ClientCategoryDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory,ClientCategoryHistory, ClientCategoryCriteria, ClientCategoryHistoryCriteria, ClientCategoryDao,
ClientCategoryHistoryDao> implements ClientCategoryAdminService {
    public static final String TEMPLATE = "template/clientCategory.vm";
    public static final String FILE_NAME = "clientCategory.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ClientCategoryDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }




    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ClientCategory.class,ClientCategoryHistory.class, ClientCategoryHistoryCriteria.class, ClientCategorySpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao, ClientCategoryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}