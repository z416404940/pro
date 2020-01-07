package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.IdentificationMapper;
import com.majortom.entity.Identification;
import com.majortom.entity.User;
import com.majortom.service.impl.IIdentificationService;

import java.util.ArrayList;
import java.util.List;

public class IdentificationService  extends BaseServer<Identification,IdentificationMapper> implements IIdentificationService{

    @Override
    public List<Identification> queryByUserList(List<User> users) {
        if (users.size()>0){
            List<Identification> identifications = new ArrayList<>();
            for (User user : users) {
                Identification identification = getByColumn("user_id",user.getUserId()).get(0);
                identifications.add(identification);
            }
            return identifications;
        }
        return null;
    }
}
