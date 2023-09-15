package emsi.sir.oubala.service.impl.admin.commun;


import emsi.sir.oubala.bean.core.commun.Client;
import emsi.sir.oubala.bean.history.commun.ClientHistory;
import emsi.sir.oubala.dao.criteria.core.commun.ClientCriteria;
import emsi.sir.oubala.dao.criteria.history.commun.ClientHistoryCriteria;
import emsi.sir.oubala.dao.facade.core.commun.ClientDao;
import emsi.sir.oubala.dao.facade.history.commun.ClientHistoryDao;
import emsi.sir.oubala.dao.specification.core.commun.ClientSpecification;
import emsi.sir.oubala.service.facade.admin.commun.ClientAdminService;
import emsi.sir.oubala.zynerator.service.AbstractServiceImpl;
import emsi.sir.oubala.zynerator.service.Attribute;
import emsi.sir.oubala.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import emsi.sir.oubala.zynerator.util.VelocityPdf;
import emsi.sir.oubala.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import emsi.sir.oubala.service.facade.admin.commun.ClientCategoryAdminService ;
import emsi.sir.oubala.bean.core.commun.ClientCategory ;

import emsi.sir.oubala.zynerator.security.service.facade.UserService;
import emsi.sir.oubala.zynerator.security.service.facade.RoleService;
import emsi.sir.oubala.zynerator.security.bean.Role;
import java.util.Collection;

import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {
    public static final String TEMPLATE = "template/client.vm";
    public static final String FILE_NAME = "client.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("fullName"));


    ATTRIBUTES.add(new Attribute("credentialsNonExpired","Boolean"));

    ATTRIBUTES.add(new Attribute("enabled","Boolean"));

    ATTRIBUTES.add(new Attribute("accountNonExpired","Boolean"));

    ATTRIBUTES.add(new Attribute("accountNonLocked","Boolean"));

    ATTRIBUTES.add(new Attribute("passwordChanged","Boolean"));

    ATTRIBUTES.add(new Attribute("username"));

    ATTRIBUTES.add(new Attribute("password"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Client> findByClientCategoryId(Long id){
        return dao.findByClientCategoryId(id);
    }
    public int deleteByClientCategoryId(Long id){
        return dao.deleteByClientCategoryId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    @Override
    public Client create(Client t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }
        Client mySaved = super.create(t);

        return mySaved;
     }

    public Client findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Autowired
    private ClientCategoryAdminService clientCategoryService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}