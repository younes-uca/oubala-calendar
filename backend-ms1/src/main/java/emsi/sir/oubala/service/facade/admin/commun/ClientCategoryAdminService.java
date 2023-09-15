package emsi.sir.oubala.service.facade.admin.commun;

import java.util.List;
import emsi.sir.oubala.bean.core.commun.ClientCategory;
import emsi.sir.oubala.dao.criteria.core.commun.ClientCategoryCriteria;
import emsi.sir.oubala.dao.criteria.history.commun.ClientCategoryHistoryCriteria;
import emsi.sir.oubala.zynerator.service.IService;

import emsi.sir.oubala.ws.dto.commun.ClientCategoryDto;
import org.springframework.http.HttpEntity;

public interface ClientCategoryAdminService extends  IService<ClientCategory,ClientCategoryCriteria, ClientCategoryHistoryCriteria>  {



    HttpEntity<byte[]> createPdf(ClientCategoryDto dto) throws Exception;

}
