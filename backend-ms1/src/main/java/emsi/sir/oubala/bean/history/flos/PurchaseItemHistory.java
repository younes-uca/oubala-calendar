package emsi.sir.oubala.bean.history.flos;

import com.fasterxml.jackson.annotation.JsonInclude;
import emsi.sir.oubala.zynerator.history.HistBusinessObject;
import jakarta.persistence.*;


@Entity
@Table(name = "purchase_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_item_seq",sequenceName="purchase_item_seq",allocationSize=1, initialValue = 1)
public class PurchaseItemHistory extends HistBusinessObject  {


    public PurchaseItemHistory() {
    super();
    }

    public PurchaseItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="purchase_item_seq")
    public Long getId() {
    return id;
    }
}

