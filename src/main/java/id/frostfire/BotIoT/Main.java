package id.frostfire.BotIoT;

import id.frostfire.BotIoT.Discord.Discord;
import id.frostfire.BotIoT.EndpointAPI.Publish;
import id.frostfire.BotIoT.Telegram.Telegram;
import id.frostfire.BotIoT.WhatsApp.WhatsApp;
import it.auties.whatsapp.api.Whatsapp;

import java.util.Scanner;

import static spark.Spark.port;

public class Main {
 public static String DcChnId;
 public static long TeleId;
 public static Boolean usewhatsapp = false;
 public static Boolean usediscord = false;
 public static boolean usetelegram = false;

 public static String Teletoken;

 public static void main(String[] args){
  port(80);
  Scanner scn = new Scanner(System.in);
  System.out.println("Are You using WhatsApp?");
  String wa = scn.nextLine();
  if(wa.equals("y") || wa.equals("yes") || wa.equals("true")){ WhatsApp.client(); usewhatsapp = true;}
  System.out.println("Are You using Discord?");
  String dc = scn.nextLine();
  if(dc.equals("yes") || dc.equals("y") || dc.equals("true")){
   usediscord = true;
   System.out.println("Please Insert your Discord Bot Token :");
   String token = scn.nextLine();
   Discord.Inisialize(token);
   System.out.println("Please Insert your ChannelID :");
   DcChnId = scn.nextLine();
  }
  System.out.println("Are you using Telegram?");
  String tele = scn.nextLine();
  if(tele.equals("y") || tele.equals("yes") || tele.equals("true")){
   System.out.println("Please Insert your Telegram Bot Token :");
   Teletoken = scn.nextLine();
   Telegram.inisialize();
   System.out.println("Please Insert your IDcontact :");
   TeleId = scn.nextLong();
   usetelegram = true;
  }
  Publish.event();
  if(usewhatsapp) System.out.println(WhatsApp.pesan(Whatsapp.webBuilder().lastConnection().build().connect().join(),
          "+6285236486026",
          "Server Menyala"));
  System.out.println("Server Menyala");
 }
}
