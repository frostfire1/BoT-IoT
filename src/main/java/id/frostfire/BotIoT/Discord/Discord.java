package id.frostfire.BotIoT.Discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

public class Discord {
    public static DiscordApi api;
    public static void Inisialize(String token){
       api = new DiscordApiBuilder().setToken(token).login().join();
        System.out.println("invite Link Discord Bot : " + api.createBotInvite());
    }
    public static String pesandc(String pesan, String id){
       new MessageBuilder().setContent(pesan).send((TextChannel) api.getChannelById(id).get());
       return "Mengirim Pesan Discord dengan pesan " + pesan;
    }
}
