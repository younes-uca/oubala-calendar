import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-purchase-create-admin',
  templateUrl: './purchase-create-admin.component.html'
})
export class PurchaseCreateAdminComponent extends AbstractCreateController<PurchaseDto, PurchaseCriteria, PurchaseService>  implements OnInit {

    private _purchaseItemsElement = new PurchaseItemDto();


   private _validPurchaseReference = true;
    private _validClientFullName = true;
    private _validPurchaseItemsProduct = true;
    private _validPurchaseItemsPrice = true;
    private _validPurchaseItemsQuantity = true;

    constructor( private purchaseService: PurchaseService , private purchaseItemService: PurchaseItemService, private productService: ProductService, private clientService: ClientService) {
        super(purchaseService);
    }

    ngOnInit(): void {
        this.purchaseItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        //this.client = new ClientDto();
        //this.clientService.findAll().subscribe((data) => this.clients = data);
}



    validatePurchaseItems(){
        this.errorMessages = new Array();
        this.validatePurchaseItemsProduct();
        this.validatePurchaseItemsPrice();
        this.validatePurchaseItemsQuantity();
    }


    public setValidation(value: boolean){
        this.validPurchaseReference = value;
        this.validPurchaseItemsProduct = value;
        this.validPurchaseItemsPrice = value;
        this.validPurchaseItemsQuantity = value;
    }

    public addPurchaseItems() {
        if( this.item.purchaseItems == null )
            this.item.purchaseItems = new Array<PurchaseItemDto>();
       this.validatePurchaseItems();
       if (this.errorMessages.length === 0) {
              this.item.purchaseItems.push({... this.purchaseItemsElement});
              this.purchaseItemsElement = new PurchaseItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletepurchaseItems(p: PurchaseItemDto) {
        this.item.purchaseItems.forEach((element, index) => {
            if (element === p) { this.item.purchaseItems.splice(index, 1); }
        });
    }

    public editpurchaseItems(p: PurchaseItemDto) {
        this.purchaseItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePurchaseReference();
    }

    public validatePurchaseReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validPurchaseReference = false;
        } else {
            this.validPurchaseReference = true;
        }
    }

    public validatePurchaseItemsProduct(){
        if (this.purchaseItemsElement.product == null) {
            this.errorMessages.push('Product de la purchaseItem est  invalide');
            this.validPurchaseItemsProduct = false;
        } else {
            this.validPurchaseItemsProduct = true;
        }
    }
    public validatePurchaseItemsPrice(){
        if (this.purchaseItemsElement.price == null) {
            this.errorMessages.push('Price de la purchaseItem est  invalide');
            this.validPurchaseItemsPrice = false;
        } else {
            this.validPurchaseItemsPrice = true;
        }
    }
    public validatePurchaseItemsQuantity(){
        if (this.purchaseItemsElement.quantity == null) {
            this.errorMessages.push('Quantity de la purchaseItem est  invalide');
            this.validPurchaseItemsQuantity = false;
        } else {
            this.validPurchaseItemsQuantity = true;
        }
    }


    get product(): ProductDto {
        return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products(): Array<ProductDto> {
        return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get createProductDialog(): boolean {
       return this.productService.createDialog;
    }
    set createProductDialog(value: boolean) {
        this.productService.createDialog= value;
    }
    get client(): ClientDto {
        return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
        return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get createClientDialog(): boolean {
       return this.clientService.createDialog;
    }
    set createClientDialog(value: boolean) {
        this.clientService.createDialog= value;
    }



    get validPurchaseReference(): boolean {
        return this._validPurchaseReference;
    }

    set validPurchaseReference(value: boolean) {
         this._validPurchaseReference = value;
    }

    get validClientFullName(): boolean {
        return this._validClientFullName;
    }
    set validClientFullName(value: boolean) {
        this._validClientFullName = value;
    }
    get validPurchaseItemsProduct(): boolean {
        return this._validPurchaseItemsProduct;
    }
    set validPurchaseItemsProduct(value: boolean) {
        this._validPurchaseItemsProduct = value;
    }
    get validPurchaseItemsPrice(): boolean {
        return this._validPurchaseItemsPrice;
    }
    set validPurchaseItemsPrice(value: boolean) {
        this._validPurchaseItemsPrice = value;
    }
    get validPurchaseItemsQuantity(): boolean {
        return this._validPurchaseItemsQuantity;
    }
    set validPurchaseItemsQuantity(value: boolean) {
        this._validPurchaseItemsQuantity = value;
    }

    get purchaseItemsElement(): PurchaseItemDto {
        if( this._purchaseItemsElement == null )
            this._purchaseItemsElement = new PurchaseItemDto();
        return this._purchaseItemsElement;
    }

    set purchaseItemsElement(value: PurchaseItemDto) {
        this._purchaseItemsElement = value;
    }

}
