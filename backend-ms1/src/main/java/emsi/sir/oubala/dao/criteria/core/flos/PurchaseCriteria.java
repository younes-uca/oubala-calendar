package  emsi.sir.oubala.dao.criteria.core.flos;


import emsi.sir.oubala.dao.criteria.core.commun.ClientCriteria;

import emsi.sir.oubala.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PurchaseCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime purchaseStartDate;
    private LocalDateTime purchaseStartDateFrom;
    private LocalDateTime purchaseStartDateTo;
    private LocalDateTime purchaseEndDate;
    private LocalDateTime purchaseEndDateFrom;
    private LocalDateTime purchaseEndDateTo;
    private String image;
    private String imageLike;
    private Boolean etat;
    private String total;
    private String totalMin;
    private String totalMax;
    private String description;
    private String descriptionLike;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;


    public PurchaseCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getPurchaseStartDate(){
        return this.purchaseStartDate;
    }
    public void setPurchaseStartDate(LocalDateTime purchaseStartDate){
        this.purchaseStartDate = purchaseStartDate;
    }
    public LocalDateTime getPurchaseStartDateFrom(){
        return this.purchaseStartDateFrom;
    }
    public void setPurchaseStartDateFrom(LocalDateTime purchaseStartDateFrom){
        this.purchaseStartDateFrom = purchaseStartDateFrom;
    }
    public LocalDateTime getPurchaseStartDateTo(){
        return this.purchaseStartDateTo;
    }
    public void setPurchaseStartDateTo(LocalDateTime purchaseStartDateTo){
        this.purchaseStartDateTo = purchaseStartDateTo;
    }
    public LocalDateTime getPurchaseEndDate(){
        return this.purchaseEndDate;
    }
    public void setPurchaseEndDate(LocalDateTime purchaseEndDate){
        this.purchaseEndDate = purchaseEndDate;
    }
    public LocalDateTime getPurchaseEndDateFrom(){
        return this.purchaseEndDateFrom;
    }
    public void setPurchaseEndDateFrom(LocalDateTime purchaseEndDateFrom){
        this.purchaseEndDateFrom = purchaseEndDateFrom;
    }
    public LocalDateTime getPurchaseEndDateTo(){
        return this.purchaseEndDateTo;
    }
    public void setPurchaseEndDateTo(LocalDateTime purchaseEndDateTo){
        this.purchaseEndDateTo = purchaseEndDateTo;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }

    public Boolean getEtat(){
        return this.etat;
    }
    public void setEtat(Boolean etat){
        this.etat = etat;
    }
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
}
