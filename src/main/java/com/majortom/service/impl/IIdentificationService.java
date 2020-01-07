package com.majortom.service.impl;


import com.majortom.entity.Identification;
import com.majortom.entity.User;

import java.util.List;

public interface IIdentificationService {
    List<Identification> queryByUserList(List<User> users);
}
