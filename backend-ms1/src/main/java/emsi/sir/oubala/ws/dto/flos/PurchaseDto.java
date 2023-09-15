package  emsi.sir.oubala.ws.dto.flos;

import emsi.sir.oubala.zynerator.audit.Log;
import emsi.sir.oubala.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import emsi.sir.oubala.ws.dto.commun.ProductDto;
import emsi.sir.oubala.ws.dto.commun.ClientDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseDto  extends AuditBaseDto {

    private String reference  ;
    private String purchaseStartDate ;
    private String purchaseEndDate ;
    private String image  ;
    private Boolean etat  ;
    private BigDecimal total  ;
    private String description  ;

    private ClientDto client ;

    private List<PurchaseItemDto> purchaseItems ;


    public PurchaseDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getPurchaseStartDate(){
        return this.purchaseStartDate;
    }
    public void setPurchaseStartDate(String purchaseStartDate){
        this.purchaseStartDate = purchaseStartDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getPurchaseEndDate(){
        return this.purchaseEndDate;
    }
    public void setPurchaseEndDate(String purchaseEndDate){
        this.purchaseEndDate = purchaseEndDate;
    }

    @Log
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }

    @Log
    public Boolean getEtat(){
        return this.etat;
    }
    public void setEtat(Boolean etat){
        this.etat = etat;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<PurchaseItemDto> getPurchaseItems(){
        return this.purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItemDto> purchaseItems){
        this.purchaseItems = purchaseItems;
    }



}
