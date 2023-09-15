import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClientCategoryDto} from './ClientCategory.model';

export class ClientDto extends BaseDto{

    public fullName: string;

   public credentialsNonExpired: null | boolean;

   public enabled: null | boolean;

   public accountNonExpired: null | boolean;

   public accountNonLocked: null | boolean;

   public passwordChanged: null | boolean;

    public username: string;

    public password: string;

    public clientCategory: ClientCategoryDto ;
    

    constructor() {
        super();

        this.fullName = '';
        this.credentialsNonExpired = null;
        this.enabled = null;
        this.accountNonExpired = null;
        this.accountNonLocked = null;
        this.passwordChanged = null;
        this.username = '';
        this.password = '';
        this.clientCategory = new ClientCategoryDto() ;

        }

}
