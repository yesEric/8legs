package cn.elegs.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

/**
 * 处理消息的工具类
 */
public class MessageUtil {

    private MessageSourceAccessor messages;

    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }

    public String getText(String msgKey) {
        Locale locale = Locale.getDefault();
        return messages.getMessage(msgKey, locale);
    }

    public String getText(String msgKey, Locale locale) {
        return messages.getMessage(msgKey, locale);
    }

    public String getText(String msgKey, String arg, Locale locale) {
        return getText(msgKey, new Object[]{arg}, locale);
    }

    public String getText(String msgKey, Object[] args, Locale locale) {
        return messages.getMessage(msgKey, args, locale);
    }
}
