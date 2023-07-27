package id.frostfire.BotIoT.WhatsApp;

import it.auties.whatsapp.api.QrHandler;
import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.contact.ContactJid;


public class WhatsApp {
    public static void client(){
        Whatsapp.webBuilder().newConnection().qrHandler(QrHandler.toTerminal()).name("FrostFireIoT Bot").build().connect().join();
    }
    public static String pesan(Whatsapp api, String nomer, String pesan){
        api.sendMessage(ContactJid.of(nomer),pesan);
        return "Mengirim pesan ke " + nomer + " Dengan pesan " + pesan;
    }
}
