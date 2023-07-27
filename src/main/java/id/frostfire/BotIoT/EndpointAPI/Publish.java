package id.frostfire.BotIoT.EndpointAPI;


import id.frostfire.BotIoT.Discord.Discord;
import id.frostfire.BotIoT.Main;
import id.frostfire.BotIoT.Telegram.Telegram;
import id.frostfire.BotIoT.WhatsApp.WhatsApp;
import it.auties.whatsapp.api.Whatsapp;

import static spark.Spark.*;
public class Publish {
    public static void event() {
        get("/", (req, res) -> "Hello World");
        post("/sendwa", (req, res) -> {

            return WhatsApp.pesan(Whatsapp.webBuilder().lastConnection().build().connect().join(),
                    req.params("pesan");
                    req.params("nomer");
        });
        post("senddc", (request, response) -> {
            response.status(201);
            return Discord.pesandc(request.queryParams("pesan"), Main.DcChnId);
        });
        post("sendtele", (request, response) -> {
            response.status(201);
            return Telegram.pesan(request.queryParams("pesan"));
        });
    }
}
