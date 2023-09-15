import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchaseService} from 'src/app/controller/service/flos/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/flos/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/flos/PurchaseCriteria.model';

import {PurchaseItemDto} from 'src/app/controller/model/flos/PurchaseItem.model';
import {PurchaseItemService} from 'src/app/controller/service/flos/PurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/commun/Product.model';
import {ProductService} from 'src/app/controller/service/commun/Product.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientService} from 'src/app/controller/service/commun/Client.service';
@Component({
  selector: 'app-purchase-view-admin',
  templateUrl: './purchase-view-admin.component.html'
})
export class PurchaseViewAdminComponent extends AbstractViewController<PurchaseDto, PurchaseCriteria, PurchaseService> implements OnInit {

    purchaseItems = new PurchaseItemDto();
    purchaseItemss: Array<PurchaseItemDto> = [];

    constructor(private purchaseService: PurchaseService, private purchaseItemService: PurchaseItemService, private productService: ProductService, private clientService: ClientService){
        super(purchaseService);
    }

    ngOnInit(): void {
        this.purchaseItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products():Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }


}
