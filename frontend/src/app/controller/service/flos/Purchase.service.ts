import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PurchaseDto} from 'src/app/controller/model/flos/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/flos/PurchaseCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService extends AbstractService<PurchaseDto, PurchaseCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/purchase/');
    }

    public constrcutDto(): PurchaseDto {
        return new PurchaseDto();
    }

    public constrcutCriteria(): PurchaseCriteria {
        return new PurchaseCriteria();
    }
}
