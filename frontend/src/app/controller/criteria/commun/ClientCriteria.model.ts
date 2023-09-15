import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ClientCategoryCriteria} from './ClientCategoryCriteria.model';

export class ClientCriteria  extends BaseCriteria  {

    public fullName: string;
    public fullNameLike: string;
    public credentialsNonExpired: null | boolean;
    public enabled: null | boolean;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public passwordChanged: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;
  public clientCategory: ClientCategoryCriteria ;
  public clientCategorys: Array<ClientCategoryCriteria> ;

}
