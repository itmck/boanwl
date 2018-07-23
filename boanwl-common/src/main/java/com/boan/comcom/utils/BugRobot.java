package com.boan.comcom.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * User: Boan
 * Date: 2018/7/22
 * Time: 15:09
 * Version:V1.0
 */
public class BugRobot {


    private  DingtalkChatbotClient client = new DingtalkChatbotClient();

    public  SendResult sendErrorToDD(Exception e,String PhoneNumber)  {

        ArrayList<String> atMobiles = new ArrayList<String>();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        e.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();

        TextMessage message = new TextMessage(ret);
        atMobiles.add(PhoneNumber);
        message.setAtMobiles(atMobiles);

        SendResult result = null;
        try {
            result = client.send(BoanConfig.CHATBOT_WEBHOOK, message);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;

    }
    public  SendResult sendErrorToDD(Exception e) throws IOException {

        ArrayList<String> atMobiles = new ArrayList<String>();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        e.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        TextMessage message = new TextMessage(ret);

        message.setAtMobiles(atMobiles);

        SendResult result = null;
        try {
            result = client.send(BoanConfig.CHATBOT_WEBHOOK, message);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;

    }
    public  SendResult sendErrorToDD(Exception e,Boolean flg) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        e.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();

        TextMessage message = new TextMessage(ret);

        if(flg) {
            message.setIsAtAll(true);
        }
        SendResult result = null;
        try {
            result = client.send(BoanConfig.CHATBOT_WEBHOOK, message);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }

}
