package  emsi.sir.oubala.ws.dto.commun;

import emsi.sir.oubala.zynerator.audit.Log;
import emsi.sir.oubala.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientCategoryDto  extends AuditBaseDto {

    private String reference  ;
    private String code  ;




    public ClientCategoryDto(){
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }








}
