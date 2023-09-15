import {Component, OnInit, ChangeDetectorRef, ViewChild} from '@angular/core';
import {PurchaseService} from 'src/app/controller/service/flos/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/flos/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/flos/PurchaseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {PurchaseItemDto} from 'src/app/controller/model/flos/PurchaseItem.model';
import {PurchaseItemService} from 'src/app/controller/service/flos/PurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/commun/Product.model';
import {ProductService} from 'src/app/controller/service/commun/Product.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientService} from 'src/app/controller/service/commun/Client.service';

import {CalendarOptions, EventClickArg} from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import {FullCalendarComponent} from '@fullcalendar/angular';
import {ScheduleDto} from 'src/app/zynerator/dto/ScheduleDto.model';

@Component({
  selector: 'app-purchase-list-admin',
  templateUrl: './purchase-list-admin.component.html'
})
export class PurchaseListAdminComponent extends AbstractListController<PurchaseDto, PurchaseCriteria, PurchaseService>  implements OnInit {

    fileName = 'Purchase';

     yesOrNoEtat: any[] = [];
    clients: Array<ClientDto>;
    public currentMonth: number;
    public schedule: ScheduleDto[];
    @ViewChild('calendar') calendarComponent: FullCalendarComponent;
    public visibleMonthNumber: number;
    public events: Array<any> = new Array<any>();
    showEditDialogContent = false;
    createDialogVisible = false;

    calendarOptions: CalendarOptions = {
        plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
        initialView: 'timeGridWeek',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'timeGridWeek,timeGridDay,dayGridMonth'
        },
        dateClick: this.handleDateClick.bind(this),
        eventClick: this.handleEventClick.bind(this),
    };


constructor( private purchaseService: PurchaseService  , private cdRef: ChangeDetectorRef  , private purchaseItemService: PurchaseItemService, private productService: ProductService, private clientService: ClientService) {
        super(purchaseService);
        this.pdfName='Purchase.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.findScheduleDataByMonth();
      this.currentMonth = new Date().getMonth() + 1;

      this.loadClient();
      this.yesOrNoEtat =  [{label: 'Etat', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }


    ngAfterInit() {
        const calendarApi = this.calendarComponent.getApi();
        this.currentMonth = new Date().getMonth() + 1;
        calendarApi.on('datesSet', (arg) => {
            const newView = calendarApi.view;
            this.currentMonth = newView.currentStart.getMonth() + 1;
            this.findScheduleDataByMonth();
        });
    }
    findScheduleDataByMonth(): void {
        this.service.findByMonth(this.currentMonth).subscribe((data) => {
            this.schedule = data;
            this.updateFullCalendarEvents();
            this.cdRef.detectChanges();
        });
    }

    updateFullCalendarEvents(viewType: string = 'timeGridWeek'): void {
      this.calendarOptions.initialView = viewType;
      this.events = this.schedule.map((item) => ({
        title: item.subject,
        start: new Date(item.startTime),
        end: new Date(item.endTime)
      }));
      this.calendarOptions.events = this.events;
    }
/*

    saveNew(): void {
        this.service.saveNew(this.item).subscribe((data) => {
        const event = {
          title: data.subject,
          start: new Date(data.purchaseStartDate),
          end: new Date(data.purchaseEndDate)
        };

        this.calendarComponent.getApi().addEvent(event);
        this.calendarComponent.getApi().refetchEvents();
        this.cdRef.markForCheck();
        this.createDialogVisible = false;
        });
    }
*/


    handleDateClick(info: any) {
        const clickedDate = info.date;
        this.createDialogVisible = true;
        this.item.purchaseStartDate = new Date(clickedDate);
        this.item.purchaseEndDate = new Date(this.item.purchaseStartDate.getTime() + 60 * 60 * 1000);
        super.openCreate();
        this.calendarComponent.getApi().refetchEvents();
        this.cdRef.markForCheck();
    }
    handleEventClick(clickInfo: EventClickArg) {
      const eventTitle = clickInfo.event.title;
      const clickedDate = clickInfo.event.start;
      const itemIndex = this.schedule.findIndex(item => item.subject === eventTitle);
      if (itemIndex !== -1) {
        //this.item = { ...this.schedule[itemIndex] };
        this.item.purchaseStartDate = new Date(clickedDate);
        this.item.purchaseEndDate = new Date(this.item.purchaseStartDate.getTime() + 60 * 60 * 1000);
        this.editDialog = true ;
        this.showEditDialogContent = true;
      }
      this.calendarComponent.getApi().refetchEvents();
      this.cdRef.markForCheck();
    }

    public prepareEdit() {
      this.item.purchaseStartDate = this.service.format(this.item.purchaseStartDate);
      this.item.purchaseEndDate = this.service.format(this.item.purchaseEndDate);
    }




    public async loadPurchases(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.service.findAll().subscribe(purchases => this.items = purchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'purchaseStartDate', header: 'Purchase start date'},
            {field: 'purchaseEndDate', header: 'Purchase end date'},
            {field: 'image', header: 'Image'},
            {field: 'etat', header: 'Etat'},
            {field: 'total', header: 'Total'},
            {field: 'client?.fullName', header: 'Client'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PurchaseDto) {
        if (res.purchaseItems != null) {
             res.purchaseItems.forEach(d => { d.purchase = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Purchase start date': this.datePipe.transform(e.purchaseStartDate , 'dd/MM/yyyy hh:mm'),
                'Purchase end date': this.datePipe.transform(e.purchaseEndDate , 'dd/MM/yyyy hh:mm'),
                 'Image': e.image ,
                'Etat': e.etat? 'Vrai' : 'Faux' ,
                 'Total': e.total ,
                 'Description': e.description ,
                'Client': e.client?.fullName ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Purchase start date Min': this.criteria.purchaseStartDateFrom ? this.datePipe.transform(this.criteria.purchaseStartDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Purchase start date Max': this.criteria.purchaseStartDateTo ? this.datePipe.transform(this.criteria.purchaseStartDateTo , this.dateFormat) : environment.emptyForExport ,
            'Purchase end date Min': this.criteria.purchaseEndDateFrom ? this.datePipe.transform(this.criteria.purchaseEndDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Purchase end date Max': this.criteria.purchaseEndDateTo ? this.datePipe.transform(this.criteria.purchaseEndDateTo , this.dateFormat) : environment.emptyForExport ,
            'Image': this.criteria.image ? this.criteria.image : environment.emptyForExport ,
            'Etat': this.criteria.etat ? (this.criteria.etat ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Client': this.criteria.client?.fullName ? this.criteria.client?.fullName : environment.emptyForExport ,
        }];
      }
}
