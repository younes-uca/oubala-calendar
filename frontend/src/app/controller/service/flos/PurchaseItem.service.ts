import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PurchaseItemDto} from 'src/app/controller/model/flos/PurchaseItem.model';
import {PurchaseItemCriteria} from 'src/app/controller/criteria/flos/PurchaseItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ProductCriteria} from 'src/app/controller/criteria/commun/ProductCriteria.model';
import {ProductDto} from 'src/app/controller/model/commun/Product.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/flos/PurchaseCriteria.model';
import {PurchaseDto} from 'src/app/controller/model/flos/Purchase.model';

@Injectable({
  providedIn: 'root'
})
export class PurchaseItemService extends AbstractService<PurchaseItemDto, PurchaseItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/purchaseItem/');
    }

    public constrcutDto(): PurchaseItemDto {
        return new PurchaseItemDto();
    }

    public constrcutCriteria(): PurchaseItemCriteria {
        return new PurchaseItemCriteria();
    }
}
