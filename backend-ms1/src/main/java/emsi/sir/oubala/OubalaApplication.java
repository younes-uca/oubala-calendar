package  emsi.sir.oubala;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import emsi.sir.oubala.bean.core.commun.Client;
import emsi.sir.oubala.service.facade.admin.commun.ClientAdminService;
import emsi.sir.oubala.zynerator.security.common.AuthoritiesConstants;
import emsi.sir.oubala.zynerator.security.bean.User;
import emsi.sir.oubala.zynerator.security.bean.Permission;
import emsi.sir.oubala.zynerator.security.bean.Role;
import emsi.sir.oubala.zynerator.security.service.facade.UserService;
import emsi.sir.oubala.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("emsi.sir.oubala.required.facade")
public class OubalaApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(OubalaApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){

            createClient();


    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }



    private void createClient(){
        String fullName = "fullName";
         String credentialsNonExpired = "credentialsNonExpired";
         String enabled = "enabled";
         String accountNonExpired = "accountNonExpired";
         String accountNonLocked = "accountNonLocked";
         String passwordChanged = "passwordChanged";
        String username = "username";
        String password = "password";
        for (int i = 1; i < 100; i++) {
            Client item = new Client();
            item.setFullName(fakeString(fullName, i));
            item.setCredentialsNonExpired(fakeBoolean(credentialsNonExpired, i));
            item.setEnabled(fakeBoolean(enabled, i));
            item.setAccountNonExpired(fakeBoolean(accountNonExpired, i));
            item.setAccountNonLocked(fakeBoolean(accountNonLocked, i));
            item.setPasswordChanged(fakeBoolean(passwordChanged, i));
            item.setUsername(fakeString(username, i));
            item.setPassword(fakeString(password, i));
            clientService.create(item);
        }
    }

    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("PurchaseItem.edit"));
        permissions.add(new Permission("PurchaseItem.list"));
        permissions.add(new Permission("PurchaseItem.view"));
        permissions.add(new Permission("PurchaseItem.add"));
        permissions.add(new Permission("PurchaseItem.delete"));
        permissions.add(new Permission("Product.edit"));
        permissions.add(new Permission("Product.list"));
        permissions.add(new Permission("Product.view"));
        permissions.add(new Permission("Product.add"));
        permissions.add(new Permission("Product.delete"));
        permissions.add(new Permission("Purchase.edit"));
        permissions.add(new Permission("Purchase.list"));
        permissions.add(new Permission("Purchase.view"));
        permissions.add(new Permission("Purchase.add"));
        permissions.add(new Permission("Purchase.delete"));
        permissions.add(new Permission("ClientCategory.edit"));
        permissions.add(new Permission("ClientCategory.list"));
        permissions.add(new Permission("ClientCategory.view"));
        permissions.add(new Permission("ClientCategory.add"));
        permissions.add(new Permission("ClientCategory.delete"));
    }

    @Autowired
    ClientAdminService clientService;
}


