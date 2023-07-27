package id.frostfire.BotIoT.Telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import id.frostfire.BotIoT.Main;

public class Telegram {
    public static TelegramBot bot;
    public static void inisialize(){
        bot = new TelegramBot(Main.Teletoken);
        bot.setUpdatesListener(updates -> {
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, e -> {
            if (e.response() != null) {
                e.response().errorCode();
                e.response().description();
            } else {
                e.printStackTrace();
            }
        });
    }
    public static String pesan(String Pesan){
        SendResponse response = bot.execute(new SendMessage(Main.TeleId, Pesan));
        return "Mengirim Pesan Telegram dengan pesan " + Pesan;
    }
}
