package emsi.sir.oubala.dao.facade.core.flos;

import emsi.sir.oubala.zynerator.repository.AbstractRepository;
import emsi.sir.oubala.bean.core.flos.Purchase;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import emsi.sir.oubala.zynerator.dto.ScheduleDto;

@Repository
public interface PurchaseDao extends AbstractRepository<Purchase,Long>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);


    @Query("SELECT NEW emsi.sir.oubala.zynerator.dto.ScheduleDto(item.id,item.reference ,DATE_FORMAT(item.purchaseStartDate, '%m/%d/%Y %H:%i'),DATE_FORMAT(item.purchaseEndDate, '%m/%d/%Y %H:%i'))  FROM Purchase item WHERE EXTRACT(MONTH from item.purchaseStartDate) = :month")
    List<ScheduleDto> findByMonth(@Param("month") int month);
}
