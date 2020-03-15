package com.summer.cat.vo;

import com.summer.cat.entity.User;
import com.summer.cat.entity.UserToRole;

public class UserRoleVo extends User {
    private UserToRole userToRole;

    public UserToRole getUserToRole() {
        return userToRole;
    }

    public void setUserToRole(UserToRole userToRole) {
        this.userToRole = userToRole;
    }
}
