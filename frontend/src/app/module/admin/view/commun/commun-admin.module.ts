import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';

import { ClientCreateAdminComponent } from './client/create/client-create-admin.component';
import { ClientEditAdminComponent } from './client/edit/client-edit-admin.component';
import { ClientViewAdminComponent } from './client/view/client-view-admin.component';
import { ClientListAdminComponent } from './client/list/client-list-admin.component';
import { ProductCreateAdminComponent } from './product/create/product-create-admin.component';
import { ProductEditAdminComponent } from './product/edit/product-edit-admin.component';
import { ProductViewAdminComponent } from './product/view/product-view-admin.component';
import { ProductListAdminComponent } from './product/list/product-list-admin.component';
import { ClientCategoryCreateAdminComponent } from './client-category/create/client-category-create-admin.component';
import { ClientCategoryEditAdminComponent } from './client-category/edit/client-category-edit-admin.component';
import { ClientCategoryViewAdminComponent } from './client-category/view/client-category-view-admin.component';
import { ClientCategoryListAdminComponent } from './client-category/list/client-category-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    ClientCreateAdminComponent,
    ClientListAdminComponent,
    ClientViewAdminComponent,
    ClientEditAdminComponent,
    ProductCreateAdminComponent,
    ProductListAdminComponent,
    ProductViewAdminComponent,
    ProductEditAdminComponent,
    ClientCategoryCreateAdminComponent,
    ClientCategoryListAdminComponent,
    ClientCategoryViewAdminComponent,
    ClientCategoryEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,

  ],
  exports: [
  ClientCreateAdminComponent,
  ClientListAdminComponent,
  ClientViewAdminComponent,
  ClientEditAdminComponent,
  ProductCreateAdminComponent,
  ProductListAdminComponent,
  ProductViewAdminComponent,
  ProductEditAdminComponent,
  ClientCategoryCreateAdminComponent,
  ClientCategoryListAdminComponent,
  ClientCategoryViewAdminComponent,
  ClientCategoryEditAdminComponent,
  ],
  entryComponents: [],
})
export class CommunAdminModule { }
