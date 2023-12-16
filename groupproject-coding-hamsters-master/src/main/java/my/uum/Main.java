package my.uum;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * The Main class serves as the entry point of the Campus Bites Bot application.
 * It initializes the Telegram API, registers the FoodSearchSystem bot, and starts the bot.
 */

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new FoodSearchSystem());
            System.out.println("The Campus Bites Bot is running!!!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
