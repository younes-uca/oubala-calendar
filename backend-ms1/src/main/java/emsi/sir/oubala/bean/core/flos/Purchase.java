package emsi.sir.oubala.bean.core.flos;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import emsi.sir.oubala.bean.core.commun.Product;
import emsi.sir.oubala.bean.core.commun.Client;


import com.fasterxml.jackson.annotation.JsonInclude;
import emsi.sir.oubala.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_seq",sequenceName="purchase_seq",allocationSize=1, initialValue = 1)
public class Purchase   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime purchaseStartDate ;
    private LocalDateTime purchaseEndDate ;
    @Column(length = 500)
    private String image;
    @Column(columnDefinition = "boolean default false")
    private Boolean etat = false;
    private BigDecimal total = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Client client ;

    private List<PurchaseItem> purchaseItems ;

    public Purchase(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="purchase_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getPurchaseStartDate(){
        return this.purchaseStartDate;
    }
    public void setPurchaseStartDate(LocalDateTime purchaseStartDate){
        this.purchaseStartDate = purchaseStartDate;
    }
    public LocalDateTime getPurchaseEndDate(){
        return this.purchaseEndDate;
    }
    public void setPurchaseEndDate(LocalDateTime purchaseEndDate){
        this.purchaseEndDate = purchaseEndDate;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public Boolean  getEtat(){
        return this.etat;
    }
    public void setEtat(Boolean etat){
        this.etat = etat;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "purchase")

    public List<PurchaseItem> getPurchaseItems(){
        return this.purchaseItems;
    }
    public void setPurchaseItems(List<PurchaseItem> purchaseItems){
        this.purchaseItems = purchaseItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id != null && id.equals(purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

