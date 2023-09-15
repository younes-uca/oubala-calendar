import {Component, OnInit} from '@angular/core';
import {ClientService} from 'src/app/controller/service/commun/Client.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/commun/ClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientCategoryDto} from 'src/app/controller/model/commun/ClientCategory.model';
import {ClientCategoryService} from 'src/app/controller/service/commun/ClientCategory.service';


@Component({
  selector: 'app-client-list-admin',
  templateUrl: './client-list-admin.component.html'
})
export class ClientListAdminComponent extends AbstractListController<ClientDto, ClientCriteria, ClientService>  implements OnInit {

    fileName = 'Client';

     yesOrNoCredentialsNonExpired: any[] = [];
     yesOrNoEnabled: any[] = [];
     yesOrNoAccountNonExpired: any[] = [];
     yesOrNoAccountNonLocked: any[] = [];
     yesOrNoPasswordChanged: any[] = [];
    clientCategorys: Array<ClientCategoryDto>;


constructor( private clientService: ClientService  , private clientCategoryService: ClientCategoryService) {
        super(clientService);
        this.pdfName='Client.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();

      this.loadClientCategory();
      this.yesOrNoCredentialsNonExpired =  [{label: 'CredentialsNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
      this.yesOrNoEnabled =  [{label: 'Enabled', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
      this.yesOrNoAccountNonExpired =  [{label: 'AccountNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
      this.yesOrNoAccountNonLocked =  [{label: 'AccountNonLocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
      this.yesOrNoPasswordChanged =  [{label: 'PasswordChanged', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }


    public async loadClients(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Client', 'list');
        isPermistted ? this.service.findAll().subscribe(clients => this.items = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'fullName', header: 'Full name'},
            {field: 'clientCategory?.reference', header: 'Client category'},
            {field: 'credentialsNonExpired', header: 'Credentials non expired'},
            {field: 'enabled', header: 'Enabled'},
            {field: 'accountNonExpired', header: 'Account non expired'},
            {field: 'accountNonLocked', header: 'Account non locked'},
            {field: 'passwordChanged', header: 'Password changed'},
            {field: 'username', header: 'Username'},
            {field: 'password', header: 'Password'},
        ];
    }


    public async loadClientCategory(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Client', 'list');
        isPermistted ? this.clientCategoryService.findAllOptimized().subscribe(clientCategorys => this.clientCategorys = clientCategorys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ClientDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Full name': e.fullName ,
                'Client category': e.clientCategory?.reference ,
                'Credentials non expired': e.credentialsNonExpired? 'Vrai' : 'Faux' ,
                'Enabled': e.enabled? 'Vrai' : 'Faux' ,
                'Account non expired': e.accountNonExpired? 'Vrai' : 'Faux' ,
                'Account non locked': e.accountNonLocked? 'Vrai' : 'Faux' ,
                'Password changed': e.passwordChanged? 'Vrai' : 'Faux' ,
                 'Username': e.username ,
                 'Password': e.password ,
            }
        });

        this.criteriaData = [{
            'Full name': this.criteria.fullName ? this.criteria.fullName : environment.emptyForExport ,
        //'Client category': this.criteria.clientCategory?.reference ? this.criteria.clientCategory?.reference : environment.emptyForExport ,
            'Credentials non expired': this.criteria.credentialsNonExpired ? (this.criteria.credentialsNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Enabled': this.criteria.enabled ? (this.criteria.enabled ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non expired': this.criteria.accountNonExpired ? (this.criteria.accountNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non locked': this.criteria.accountNonLocked ? (this.criteria.accountNonLocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Password changed': this.criteria.passwordChanged ? (this.criteria.passwordChanged ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
        }];
      }
}
