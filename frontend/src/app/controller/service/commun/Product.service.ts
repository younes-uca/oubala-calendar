import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProductDto} from 'src/app/controller/model/commun/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/commun/ProductCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProductService extends AbstractService<ProductDto, ProductCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/product/');
    }

    public constrcutDto(): ProductDto {
        return new ProductDto();
    }

    public constrcutCriteria(): ProductCriteria {
        return new ProductCriteria();
    }
}
