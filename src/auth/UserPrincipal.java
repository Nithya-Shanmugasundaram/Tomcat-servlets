package auth;

import java.security.Principal;

public class UserPrincipal implements Principal{
    String name;
    public UserPrincipal(String name) {
        super();
        this.name = name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

}