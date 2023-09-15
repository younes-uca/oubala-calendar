import {Component, OnInit} from '@angular/core';
import {ProductService} from 'src/app/controller/service/commun/Product.service';
import {ProductDto} from 'src/app/controller/model/commun/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/commun/ProductCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-product-list-admin',
  templateUrl: './product-list-admin.component.html'
})
export class ProductListAdminComponent extends AbstractListController<ProductDto, ProductCriteria, ProductService>  implements OnInit {

    fileName = 'Product';



constructor( private productService: ProductService  ) {
        super(productService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();

    }


    public async loadProducts(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.service.findAll().subscribe(products => this.items = products,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'reference', header: 'Reference'},
        ];
    }



	public initDuplicate(res: ProductDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Reference': e.reference ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        }];
      }
}
