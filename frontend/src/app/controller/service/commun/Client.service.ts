import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ClientCategoryCriteria} from 'src/app/controller/criteria/commun/ClientCategoryCriteria.model';
import {ClientCategoryDto} from 'src/app/controller/model/commun/ClientCategory.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService extends AbstractService<ClientDto, ClientCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/client/');
    }

    public constrcutDto(): ClientDto {
        return new ClientDto();
    }

    public constrcutCriteria(): ClientCriteria {
        return new ClientCriteria();
    }
}
