package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.MessageMapper;
import com.majortom.entity.Message;
import com.majortom.service.impl.IMessageService;

public class MessageService  extends BaseServer<Message,MessageMapper> implements IMessageService{

}
