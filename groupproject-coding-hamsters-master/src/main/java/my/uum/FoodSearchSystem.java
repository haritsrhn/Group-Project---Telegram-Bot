package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class is for manipulating function in System Admin of Campus Bites Bot
 *
 * @author Raihan Harits 274808
 * @author Balqis binti Sukria 279865
 * @author Wardina Syadiyah binti Ahmad Ridhuan 280769
 * @author Nur Afiqah binti Mohd Amir 278415
 * @author Nur Fatin Nasuha binti Shamas 278062
 *
 */

public class FoodSearchSystem extends TelegramLongPollingBot {

    private static final String password = "admin1234";
    private static final String databaseUrl = "jdbc:sqlite:/Users/balqissukria/campusbites.db";
    private static String deletedEmail;
    private static String registerEmail;
    private static String pendingOpenTime = "";
    private static String pendingMobileTelNo = "";
    private static String pendingLocationLink = "";
    private static String pendingHolidayStatus = "";
    private ScheduledExecutorService scheduler;
    private String statusMessage;
    private long pendingCommentChatId = 0;
    private long pendingUpdate = 0;
    private long pendingFoodChatId = 0;
    private long pendingCafeAdminId = 0;
    private long pendingChatId = 0;
    private long pendingAdmin = 0;
    private String pendingFoodName = "";
    private String pendingFType = "";
    private String pendingFoodNameUpdate = "";
    private String pendingFName = "";
    private String pendingFPrice = "";
    private String pendingFStatus = "";
    private String pendingFImage = "";
    private String pendingFLocation = "";
    private String pendingFCafeName = "";
    private String pendingEmail = "";
    private String pendingCafe = "";
    private String pendingFood = "";
    private String pendingName = "";
    private String pendingComment = "";
    private String pendingInasisName = "";
    private String pendingOfficeTelNo = "";
    private String pendingCloseTime = "";
    private String pendingCafeName = "";
    private long pendingAdminId = 0;
    private String pendingFieldToUpdate = "";
    private String pendingFoodIDUpdate = "";
    private long pendingDelete = 0;
    private String pendingFoodNameDelete = "";
    private String pendingFoodIdDelete = "";
    private long pendingSendStatus = 0;

    /**
     * This method is called when an update is received from the Telegram Bot API.
     * It handles various commands and messages sent by the user.
     *
     * @param update The update received from the Telegram Bot API.
     */
    @Override
public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendWelcomeMessage(chatId);
            } else if (messageText.equals("/systemAdmin")) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equals("/cafeAdmin")) {
                String response = "Hello, Cafe Admin! Please choose an option using the commands:\n\n" +
                        "1. /register - Register cafe admin\n" +
                        "2. /alreadyRegistered - Log in as Cafe Admin";

                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (messageText.equals("/register")) {
                String response = "Please enter your email address: " + "\n\nexample: campusbites@gmail.com";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending registration
                pendingAdminId = chatId;
            } else if (pendingAdminId == chatId) {
                if (pendingEmail.isEmpty()) {
                    pendingEmail = messageText;
                    String response = "Please enter the name:" + "\n\nexample: Raihan Harits";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingName.isEmpty()) {

                    pendingName = messageText;
                    String response = "Please enter your office telephone number:" + "\n\nexample: 012-3456789";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingOfficeTelNo.isEmpty()) {
                    pendingOfficeTelNo = messageText;
                    String response = "Please enter your mobile telephone number:" + "\n\nexample: 012-3456789";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingMobileTelNo.isEmpty()) {
                    pendingMobileTelNo = messageText;
                    String response = "Please enter your cafe name:" + "\n\nexample: Campus Bites Cafe";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingCafeName.isEmpty()) {
                    pendingCafeName = messageText;
                    String response = "Please enter your INASIS name:" + "\n\nexample: Inasis TNB";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingInasisName.isEmpty()) {
                    pendingInasisName = messageText;
                    String response = "Please enter the location link of your cafe:" + "\n\nexample: https://goo.gl/maps/RCKLVrKpqvrpEoMk8";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingLocationLink.isEmpty()) {
                    pendingLocationLink = messageText;
                    String response = "Please enter the opening time of your cafe:" + "\n\nexample: 10AM";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingOpenTime.isEmpty()) {
                    pendingOpenTime = messageText;
                    String response = "Please enter the closing time of your cafe:" + "\n\nexample: 10PM";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingCloseTime.isEmpty()) {
                    pendingCloseTime = messageText;
                    String response = "Please enter the holiday status (days closed) of your cafe:" + "\n\nexample: Every Tuesday";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingHolidayStatus.isEmpty()) {
                    pendingHolidayStatus = messageText;

                    // All registration details received, save to database
                    saveCafeAdminRegistration(pendingEmail, pendingName, pendingOfficeTelNo, pendingMobileTelNo, pendingCafeName, pendingInasisName, pendingLocationLink, pendingOpenTime, pendingCloseTime, pendingHolidayStatus);

                    String response = "Congratulations \uD83C\uDF89 \nRegistration successful! Your details have been recorded.";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    // Reset the pending variables
                    pendingAdminId = 0;
                    registerEmail = "";
                    pendingName = "";
                    pendingOfficeTelNo = "";
                    pendingMobileTelNo = "";
                    pendingCafeName = "";
                    pendingInasisName = "";
                    pendingLocationLink = "";
                    pendingOpenTime = "";
                    pendingCloseTime = "";
                    pendingHolidayStatus = "";
                }
            } else if (messageText.equals("/alreadyRegistered")) { //start of /alreadyRegistered
                String response = "Please enter your email address:" + "\n\nNote that the email need to be approved by System Admin first!" + "\nexample: campusbites@gmail.com";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending registration
                pendingAdmin = chatId;
            } else if (pendingAdmin == chatId) {
                if (pendingEmail.isEmpty()) {
                    pendingEmail = messageText;

                    // Check if the email exists in the database
                    if (isCafeAdminApproved(pendingEmail)) {
                        String adminInfo = getCafeAdminInfo(pendingEmail);
                        String response = "You are already registered as a cafe admin." +
                                "\nHere are your details:\n\n" + adminInfo +
                                "\n\nPlease choose an option using the commands:\n" +
                                "/add - Add Food Price\n" +
                                "/update - Update Food Price\n" +
                                "/delete - Delete Food Price\n" +
                                "/sendStatus - Send status message";

                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else if (!isCafeAdminApproved(pendingEmail)) {
                        String response = "You are not registered as a Cafe Admin. Please contact the system administrator for assistance.";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    pendingAdmin = 0;
                    pendingEmail = "";
                }
            } //end of /alreadyRegistered
            else if (messageText.equals("/add")) { //start /add operation
                String response = "Please enter food type:" + "\n\nexample: western";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending registration
                pendingCafeAdminId = chatId;
            } else if (pendingCafeAdminId == chatId) {
                if (pendingFType.isEmpty()) {
                    pendingFType = messageText;
                    String response = "Please enter the food name:" + "\n\nexample: Chicken Chop";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFName.isEmpty()) {

                    pendingFName = messageText;
                    String response = "Please enter food price:" + "\n\nexample: RM8.00";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFPrice.isEmpty()) {
                    pendingFPrice = messageText;
                    String response = "Please put food image URL:" + "\n\nexample: https://spicepaw.com/2018/07/01/crispy-chicken-chop/";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFImage.isEmpty()) {
                    pendingFImage = messageText;
                    String response = "Please enter food status:" + "\n\nexample: available / unavailable";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFStatus.isEmpty()) {
                    pendingFStatus = messageText;
                    String response = "Please enter your cafe name:" + "\n\nexample: Campus Bites Cafe";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFCafeName.isEmpty()) {
                    pendingFCafeName = messageText;
                    String response = "Please enter the location link of your cafe:" + "\n\nexample: https://goo.gl/maps/RCKLVrKpqvrpEoMk8";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingFLocation.isEmpty()) {
                    pendingFLocation = messageText;

                    // All registration details received, save to database
                    addDetails(pendingFType, pendingFName, pendingFPrice, pendingFImage, pendingFStatus, pendingFCafeName, pendingFLocation, pendingEmail);

                    String response = "Food Details Succesfully Added! Your details have been recorded.";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    // Reset the pending variables
                    pendingCafeAdminId = 0;
                    pendingFType = "";
                    pendingFName = "";
                    pendingFPrice = "";
                    pendingFImage = "";
                    pendingFStatus = "";
                    pendingFCafeName = "";
                    pendingFLocation = "";

                }
            } // end of /add operation
            else if (messageText.equals("/update")) { //start /update operation

                // Reset variables to start a new update operation
                pendingUpdate = 0;
                pendingFoodNameUpdate = "";
                pendingFoodIDUpdate = "";
                pendingFieldToUpdate = "";

                String response = "Please enter cafe name:" + "\n\nexample: Campus Bites Cafe";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending registration
                pendingUpdate = chatId;
            } else if (pendingUpdate == chatId) {
                if (pendingFoodNameUpdate.isEmpty()) {
                    pendingFoodNameUpdate = messageText;

                    // Check if the cafe name exists in the database
                    String foodInfo = getFoodInfo(pendingFoodNameUpdate);
                    String response = "Here are the food details for the selected cafe:\n\n" + foodInfo
                            + "Please enter the food ID you want to update:";

                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println("list");

                } else if (pendingFoodIDUpdate.isEmpty()) {
                    pendingFoodIDUpdate = messageText;

                    // Prompt user to select the field to update
                    String response = "Please select the field you want to update:\n"
                            + "1. Food type\n"
                            + "2. Food name\n"
                            + "3. Food price";

                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println("food ID");

                } else if (pendingFieldToUpdate.isEmpty()) {
                    int fieldSelection = Integer.parseInt(messageText);

                    if (fieldSelection >= 1 && fieldSelection <= 3) {
                        String[] fields = {"food type", "food name", "food price"};
                        pendingFieldToUpdate = fields[fieldSelection - 1];

                        // Ask user to input the updated information
                        String response = "Please enter the updated " + pendingFieldToUpdate + ":";

                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        System.out.println("field");

                    } else {
                        // Invalid field selection
                        String response = "Invalid selection. Please select a valid field to update.";

                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    // User entered the updated information
                    String updatedValue = messageText;

                    // Update the selected field in the database
                    boolean updateSuccess = updateFoodField(pendingFoodIDUpdate, pendingFieldToUpdate, updatedValue);

                    if (updateSuccess) {
                        String successResponse = "Food information has been successfully updated!";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(successResponse);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String errorResponse = "Failed to update food information. Please try again.";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(errorResponse);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }//end of /update operation
            else if (messageText.equals("/delete")) { //start of /delete operation
                // Reset variables to start a new update operation
                pendingDelete = 0;
                pendingFoodNameDelete = "";
                pendingFoodIdDelete = "";

                String response = "Please enter the cafe name:" + "\n\nexample: Campus Bites Cafe";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending deletion
                pendingDelete = chatId;
            } else if (pendingDelete == chatId) {
                if (pendingFoodNameDelete.isEmpty()) {
                    pendingFoodNameDelete = messageText;

                    // Check if the cafe name exists in the database
                    String foodInfo = getFoodInfo(pendingFoodNameDelete);
                    String response = "Here are the food details for the selected cafe:\n\n" + foodInfo
                            + "Please enter the food ID you want to delete:";

                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    System.out.println("list");
                } else if (pendingFoodIdDelete.isEmpty()) {
                    pendingFoodIdDelete = messageText;

                    // Delete the selected food based on the food ID
                    boolean deleteSuccess = deleteFood(pendingFoodIdDelete);

                    if (deleteSuccess) {
                        String successResponse = "Food has been successfully deleted!";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(successResponse);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String errorResponse = "Failed to delete food. Please try again.";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(errorResponse);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } //end of delete operation
            else if (messageText.equals("/sendStatus")) { //start of /sendStatus operation
                pendingSendStatus = 0;
                statusMessage = "";
                String response = "Please enter the status message:\n" +
                        "(for example, the promotion, emergency close, etc.)";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending status message
                pendingSendStatus = chatId;
            } else if (pendingSendStatus == chatId) {
                statusMessage = messageText;

                String response = "Status message has been set. It will be sent daily at 8:00 AM.";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Schedule the daily sending of the status message at 8:00 AM
                scheduleStatusMessage();
            } else if (messageText.equals("/regularUser")) {
                String response = "Hello, User! Please choose an option using the commands:\n\n" +
                        "1. /viewFoodPrice - View Food Price\n" +
                        "2. /compareFoodPrice - Compare Food Price\n" +
                        "3. /leaveFeedback - Leave a Comment and Rating\n" +
                        "4. /viewCafeList - View Cafe List and Locations";

                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (messageText.equals("/viewFoodPrice")) {
                String response = "Please enter the cafe name:" + "\n\nexample: Campus Bites Cafe";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending request
                pendingCommentChatId = chatId;
            } else if (pendingCommentChatId == chatId) {
                if (pendingCafe.isEmpty()) {
                    pendingCafe = messageText;
                    String foodPrices = getFoodPricesFromDatabase(pendingCafe);

                    if (foodPrices.isEmpty()) {
                        String response = "No food prices found for the cafe " + pendingCafe;
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String response = "Here are the food prices for " + pendingCafe + ":\n" + foodPrices;
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                    // Reset the pending variables
                    pendingCommentChatId = 0;
                    pendingCafe = "";
                }


            } else if (messageText.equals("/compareFoodPrice")) {
                String response = "Please enter the food name:" + "\n\nexample: Chicken Chop";
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Store the chat ID to track the pending request
                pendingFoodChatId = chatId;
            } else if (pendingFoodChatId == chatId) {
                if (pendingFood.isEmpty()) {
                    pendingFood = messageText;
                    String foodPrices = getCompareFromDatabase(pendingFood);

                    if (foodPrices.isEmpty()) {
                        String response = "No food prices found for the cafe " + pendingFood;
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String response = "Here are the food prices for " + pendingFood + ":\n" + foodPrices;
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                    // Reset the pending variables
                    pendingCommentChatId = 0;
                    pendingCafe = "";
                }
            } else if (messageText.equals("/leaveFeedback")) {
                String response = "Please enter the food name:" + "\n\nexample: Chicken Chop";;
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(response);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                pendingChatId = chatId;
            } else if (pendingChatId == chatId) {
                if (pendingFoodName.isEmpty()) {
                    pendingFoodName = messageText;
                    String response = "Please enter the cafe:" + "\n\nexample: Campus Bites Cafe";;
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingCafe.isEmpty()) {
                    pendingCafe = messageText;
                    String response = "Please enter your comment about the cafe chosen:";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (pendingComment.isEmpty()) {
                    pendingComment = messageText;
                    String response = "Please enter the rating (1-5):";
                    SendMessage message = new SendMessage();
                    message.setChatId(String.valueOf(chatId));
                    message.setText(response);

                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        int rating = Integer.parseInt(messageText);
                        if (rating >= 1 && rating <= 5) {
                            saveCommentData(pendingFoodName, pendingCafe, pendingComment, rating);

                            String response = "Thank you for your comment and rating! Your feedback has been recorded.";
                            SendMessage message = new SendMessage();
                            message.setChatId(String.valueOf(chatId));
                            message.setText(response);

                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }

                            // Reset the pending variables
                            pendingChatId = 0;
                            pendingFoodName = "";
                            pendingCafe = "";
                            pendingComment = "";
                        } else {
                            String response = "Invalid rating! Please enter a rating from 1 to 5:";
                            SendMessage message = new SendMessage();
                            message.setChatId(String.valueOf(chatId));
                            message.setText(response);

                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (NumberFormatException e) {
                        String response = "Invalid rating! Please enter a rating from 1 to 5:";
                        SendMessage message = new SendMessage();
                        message.setChatId(String.valueOf(chatId));
                        message.setText(response);

                        try {
                            execute(message);
                        } catch (TelegramApiException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } else if (messageText.equals("/viewCafeList")) {
                String cafeList = getCafeListFromDatabase();

                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText(cafeList);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (messageText.equals(password)) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equals("/viewCafeAdminInfo")) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equals("/deleteCafeAdmin")) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equalsIgnoreCase("Yes") && deletedEmail != null) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equalsIgnoreCase("No")) {
                SendMessage cancelMessage = new SendMessage();
                cancelMessage.setChatId(String.valueOf(chatId));
                cancelMessage.setText("Delete canceled. Thank you.");

                try {
                    execute(cancelMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (deletedEmail == null) {
                deletedEmail = messageText;
                SystemAdmin.systemAdminHandler(update, this);
            } else if (messageText.equals("/approveCafeAdmin")) {
                SystemAdmin.systemAdminHandler(update, this);
            } else if (registerEmail == null) {
                registerEmail = messageText;
                SystemAdmin.systemAdminHandler(update, this);
            }
        }
    }

    /**
     * Sends a welcome message to the user upon starting the conversation.
     *
     * @param chatId The ID of the chat to send the message to.
     */

    private void sendWelcomeMessage(long chatId) {
        String response = "\uD83C\uDF54\uD83C\uDF2E\uD83C\uDF55 Welcome to Campus Bites Bot! \uD83C\uDF2F\uD83C\uDF63\uD83C\uDF69\n" +
                "\nPlease select an option below to continue:\n\n" +
                "/systemAdmin - System Administrator\n"
                + "/cafeAdmin - Cafe Administrator\n"
                + "/regularUser - Regular User";

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(response);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves food information for a given cafe from the database.
     *
     * @param pendingFoodNameUpdate name of the cafe to retrieve food information for.
     * @return A string containing the food information for the given cafe, or a message indicating no food items were found.
     */

    private String getFoodInfo(String pendingFoodNameUpdate) {
        StringBuilder foodInfo = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT food_id, food_type, food_name, food_price FROM foodDetails WHERE UPPER(location_link) = UPPER(?) OR LOWER(location_link) = LOWER(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pendingFoodNameUpdate);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String food_id = rs.getString("food_id");
                String food_type = rs.getString("food_type");
                String food_name = rs.getString("food_name");
                String food_price = rs.getString("food_price");

                foodInfo.append("Food ID: ").append(food_id).append("\n")
                        .append("Food type: ").append(food_type).append("\n")
                        .append("Food name: ").append(food_name).append("\n")
                        .append("Food price: ").append(food_price).append("\n\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (foodInfo.length() == 0) {
            return "No food items found for the selected cafe.";
        } else {
            return foodInfo.toString();
        }
    }

    /**
     * Schedules the daily sending of the status message at 8:00 AM.
     * The previously scheduled tasks are canceled and a new task is scheduled.
     * The status message is sent every 24 hours.
     */

    private void scheduleStatusMessage() {
        // Cancel any previously scheduled tasks
        if (scheduler != null) {
            scheduler.shutdownNow();
            System.out.println("Cancel any previously scheduled message");
        }

        // Calculate initial delay until 8:00 AM
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime targetTime = LocalDateTime.of(now.toLocalDate().plusDays(1), LocalTime.of(8, 0));
        long initialDelay = ChronoUnit.SECONDS.between(now, targetTime);

        // Create a new scheduler and schedule the task
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::sendStatusMessage, initialDelay, 24 * 60 * 60, TimeUnit.SECONDS);
        System.out.println("The message scheduled. (" + statusMessage + ")");
    }

    /**
     * Sends the status message to all users.
     * The status message is retrieved from the instance variable 'statusMessage'.
     */

    private void sendStatusMessage() {
        //Sending the status message to all users
        SendMessage message = new SendMessage();
        message.setText("Today's Status Message:\n\n" + statusMessage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a food item from the database based on the given food ID.
     *
     * @param foodID The ID of the food item to be deleted.
     * @return true if the deletion is successful, false otherwise.
     */

    private boolean deleteFood(String foodID) {
        boolean deleteSuccess = false;

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "DELETE FROM foodDetails WHERE food_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, foodID);

            int rowsAffected = pstmt.executeUpdate();
            deleteSuccess = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleteSuccess;
    }

    /**
     * Adds food details to the database.
     *
     * @param pendingFType      The type of the food.
     * @param pendingFName      The name of the food.
     * @param pendingFPrice     The price of the food.
     * @param pendingFImage     The image of the food.
     * @param pendingFStatus    The status of the food.
     * @param pendingFCafeName  The name of the cafe.
     * @param pendingFLocation  The location of the food.
     * @param pendingEmail      The email address associated with the food.
     */

    private void addDetails(String pendingFType, String pendingFName, String pendingFPrice, String pendingFImage, String pendingFStatus, String pendingFCafeName, String pendingFLocation, String pendingEmail) {
        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "INSERT INTO foodDetails (food_type, food_name, food_price, food_image, food_status, location_link, cafe_name,email_address) " + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pendingFType);
            pstmt.setString(2, pendingFName);
            pstmt.setString(3, pendingFPrice);
            pstmt.setString(4, pendingFImage);
            pstmt.setString(5, pendingFStatus);
            pstmt.setString(6, pendingFCafeName);
            pstmt.setString(7, pendingFLocation);
            pstmt.setString(8, pendingEmail);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves food prices from the database for a given food.
     *
     * @param food The name of the food.
     * @return A string containing the cafe names and their corresponding food prices for the given food.
     */

    private String getCompareFromDatabase(String food) {
        String foodPrice = "";

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT cafe_name, food_price FROM foodDetails WHERE food_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, food);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String cafeName = rs.getString("cafe_name");
                String price = rs.getString("food_price");
                foodPrice += cafeName + ": " + price + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodPrice;
    }

    /**
     * Updates a specific field of a food item in the database.
     *
     * @param foodID        The ID of the food item to update.
     * @param fieldToUpdate The field to update (food type, food name, or food price).
     * @param updatedValue  The new value to set for the field.
     * @return True if the update was successful, false otherwise.
     */

    private boolean updateFoodField(String foodID, String fieldToUpdate, String updatedValue) {
        boolean updateSuccess = false;

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "";
            PreparedStatement pstmt;

            if (fieldToUpdate.equalsIgnoreCase("food type")) {
                sql = "UPDATE foodDetails SET food_type = ? WHERE food_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, updatedValue);
                pstmt.setString(2, foodID);
            } else if (fieldToUpdate.equalsIgnoreCase("food name")) {
                sql = "UPDATE foodDetails SET food_name = ? WHERE food_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, updatedValue);
                pstmt.setString(2, foodID);
            } else if (fieldToUpdate.equalsIgnoreCase("food price")) {
                sql = "UPDATE foodDetails SET food_price = ? WHERE food_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, updatedValue);
                pstmt.setString(2, foodID);
            } else {
                // Invalid field to update
                return false;
            }

            int rowsAffected = pstmt.executeUpdate();
            updateSuccess = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSuccess;
    }

    /**
     * Retrieves the food prices for a specific cafe from the database.
     *
     * @param cafe The name of the cafe to retrieve the food prices for.
     * @return A string containing the food names and their respective prices for the specified cafe.
     */

    private String getFoodPricesFromDatabase(String cafe) {
        String foodPrices = "";

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT food_name, food_price FROM foodDetails WHERE UPPER(cafe_name) = UPPER(?) OR LOWER(cafe_name) = LOWER(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cafe);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String foodName = rs.getString("food_name");
                String price = rs.getString("food_price");
                foodPrices += foodName + ": " + price + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodPrices;
    }

    /**
     * Saves the user comment and rating for a specific food and cafe in the database.
     *
     * @param foodName The name of the food.
     * @param cafe The name of the cafe.
     * @param comment The user's comment.
     * @param rating The user's rating.
     */

    private void saveCommentData(String foodName, String cafe, String comment, int rating) {

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "INSERT INTO comments (food_name, cafe_name, user_comment, user_rating) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, foodName);
            pstmt.setString(2, cafe);
            pstmt.setString(3, comment);
            pstmt.setInt(4, rating);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the list of cafes from the database.
     *
     * @return A string containing the cafe names, inasis names, and location links.
     */

    private String getCafeListFromDatabase() {
        String cafeList = "";


        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT cafe_name, inasis_name, location_link FROM cafeAdminApproved";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                String cafeName = rs.getString("cafe_name");
                String inasisName = rs.getString("inasis_name");
                String locationLink = rs.getString("location_link");
                cafeList += cafeName + " (" + inasisName + ")" + " - " + locationLink + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return cafeList;
    }

    /**
     * Saves the registration details of a cafe administrator to the database.
     *
     * @param email         The email address of the cafe administrator.
     * @param name          The name of the cafe administrator.
     * @param officeTelNo   The office telephone number of the cafe administrator.
     * @param mobileTelNo   The mobile telephone number of the cafe administrator.
     * @param cafeName      The name of the cafe.
     * @param inasisName    The name of the inasis.
     * @param locationLink  The location link of the cafe.
     * @param openTime      The opening time of the cafe.
     * @param closeTime     The closing time of the cafe.
     * @param holidayStatus The holiday status of the cafe.
     */

    private void saveCafeAdminRegistration(String email, String name, String officeTelNo, String mobileTelNo, String cafeName, String inasisName, String locationLink, String openTime, String closeTime, String holidayStatus) {

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "INSERT INTO cafeAdminRegister (email_address, name, office_telNo, mobile_telNo, cafe_name, inasis_name, location_link, open_time, close_time, holiday_status) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, officeTelNo);
            pstmt.setString(4, mobileTelNo);
            pstmt.setString(5, cafeName);
            pstmt.setString(6, inasisName);
            pstmt.setString(7, locationLink);
            pstmt.setString(8, openTime);
            pstmt.setString(9, closeTime);
            pstmt.setString(10, holidayStatus);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a cafe administrator with the given email address is approved.
     *
     * @param email The email address of the cafe administrator.
     * @return {@code true} if the cafe administrator is approved, {@code false} otherwise.
     */

    private boolean isCafeAdminApproved(String email) {
        boolean isApproved = false;

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT * FROM cafeAdminApproved WHERE email_address = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isApproved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isApproved;
    }

    /**
     * Retrieves the information of a cafe administrator with the given email address.
     *
     * @param email The email address of the cafe administrator.
     * @return The information of the cafe administrator formatted as a string.
     */

    private String getCafeAdminInfo(String email) {
        String adminInfo = "";

        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            String sql = "SELECT name, office_telNo, mobile_telNo, cafe_name, inasis_name, location_link, open_time, close_time, holiday_status " + "FROM cafeAdminApproved WHERE email_address = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String officeTelNo = rs.getString("office_telNo");
                String mobileTelNo = rs.getString("mobile_telNo");
                String cafeName = rs.getString("cafe_name");
                String inasisName = rs.getString("inasis_name");
                String locationLink = rs.getString("location_link");
                String openTime = rs.getString("open_time");
                String closeTime = rs.getString("close_time");
                String holidayStatus = rs.getString("holiday_status");

                adminInfo = "Name: " + name + "\nOffice Telephone Number: " + officeTelNo + "\nMobile Telephone Number: " + mobileTelNo + "\nCafe Name: " + cafeName + "\nInasis Name: " + inasisName + "\nLocation Link: " + locationLink + "\nOpening Time: " + openTime + "\nClosing Time: " + closeTime + "\nHoliday Status: " + holidayStatus;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adminInfo;
    }

    /**
     * Returns the username of the bot.
     *
     * @return The username of the bot.
     */

    @Override
    public String getBotUsername() {
        // Return the username of your bot
        return "A222_STIW3054_CampusBitesBot";
    }

    /**
     * Returns the token of the bot.
     *
     * @return The token of the bot.
     */

    @Override
    public String getBotToken() {
        // Return the token of your bot
        return "6074674167:AAF6PJeoYz80vCy7oYgo6RBib0uAD9Gyf04";
    }

}
