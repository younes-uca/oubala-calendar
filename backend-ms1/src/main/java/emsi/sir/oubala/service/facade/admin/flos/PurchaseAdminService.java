package emsi.sir.oubala.service.facade.admin.flos;

import java.util.List;
import emsi.sir.oubala.bean.core.flos.Purchase;
import emsi.sir.oubala.dao.criteria.core.flos.PurchaseCriteria;
import emsi.sir.oubala.dao.criteria.history.flos.PurchaseHistoryCriteria;
import emsi.sir.oubala.zynerator.service.IService;
import emsi.sir.oubala.zynerator.dto.ScheduleDto;

import emsi.sir.oubala.ws.dto.flos.PurchaseDto;
import org.springframework.http.HttpEntity;

public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria, PurchaseHistoryCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);

public List<ScheduleDto> findByMonth(int month);

    HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception;

}
