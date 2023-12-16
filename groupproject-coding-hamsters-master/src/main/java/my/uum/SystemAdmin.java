package my.uum;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;

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

public class SystemAdmin {
    private static final String password = "admin1234";
    private static final String databaseUrl = "jdbc:sqlite:/Users/balqissukria/campusbites.db";
    private static String deletedEmail;
    private static String registerEmail;

    /**
     * This method handles system administration commands and actions based on the user input
     *
     * @param update The update object containing the incoming message.
     * @author param bot The FoodSearchSystem instance used for executing commands and sending messages.
     *
     */

    public static void systemAdminHandler(Update update, FoodSearchSystem bot) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/systemAdmin")) {
                processPasswordSystemAdmin(chatId, bot);
            } else if (messageText.equals(password)) {
                sendWelcomeMessageSystemAdmin(chatId, bot);
            } else if (messageText.equals("/viewCafeAdminInfo")) {
                viewCafeAdminInfo(chatId, bot);
            } else if (messageText.equals("/deleteCafeAdmin")) {
                processDeleteCafeAdmin(chatId, bot);
            } else if (messageText.equalsIgnoreCase("Yes") && deletedEmail != null) {
                confirmDeleteCafeAdmin(deletedEmail, chatId, bot);
            } else if (messageText.equalsIgnoreCase("No")) {
                SendMessage cancelMessage = new SendMessage();
                cancelMessage.setChatId(String.valueOf(chatId));
                cancelMessage.setText("Delete cancelled.Thank you.");

                try {
                    bot.execute(cancelMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (deletedEmail == null) {
                deletedEmail = messageText;
                deleteCafeAdmin(deletedEmail, chatId, bot);
            } else if (messageText.equals("/approveCafeAdmin")) {
                processApproveCafeAdmin(chatId, bot);
            } else if (registerEmail == null) {
                registerEmail = messageText;
                approveCafeAdmin(registerEmail, chatId, bot);
            } else {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Invalid command, please input a valid command.");

                try {
                    bot.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Sends a welcome message to the system admin, providing information about available options.
     *
     * @param chatId The ID of the chat where the welcome message will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */


    private static void sendWelcomeMessageSystemAdmin(long chatId, FoodSearchSystem bot) {
        String response = "Welcome, System Admin!\n" +
                "You have access to the following options:\n" +
                "1. /viewCafeAdminInfo - View all cafe admin information\n" +
                "2. /deleteCafeAdmin - Delete cafe admin\n" +
                "3. /approveCafeAdmin - Approve cafe admin";

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(response);

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initiates the process of requesting a password from the system admin.
     *
     * @param chatId The ID of the chat where the password request will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */

    private static void processPasswordSystemAdmin(long chatId, FoodSearchSystem bot) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Please enter a password:");

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves and sends the list of approved cafe admin information to the specified chat.
     *
     * @param chatId The ID of the chat where the list of cafe admin information will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */

    private static void viewCafeAdminInfo(long chatId, FoodSearchSystem bot) {
        // Retrieve the cafe admin details from the cafeAdminApproved table
        ResultSet resultSet = getCafeAdminApprovedData();

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        StringBuilder responseBuilder = new StringBuilder("Cafe Admin Approved List:\n");

        try {
            int count = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email_address");
                String cafeName = resultSet.getString("cafe_name");
                String inasisName = resultSet.getString("inasis_name");
                String locationLink = resultSet.getString("location_link");

                responseBuilder.append("\n").append(count).append(". Name: ").append(name)
                        .append("\nEmail: ").append(email)
                        .append("\nCafe Name: ").append(cafeName)
                        .append("\nInasis Name: ").append(inasisName)
                        .append("\nLocation Link: ").append(locationLink)
                        .append("\n");

                count++;
            }

            message.setText(responseBuilder.toString());
            bot.execute(message);
        } catch (SQLException | TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initiates the process of requesting the email of the cafe admin to be deleted.
     *
     * @param chatId The ID of the chat where the email request will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */

    private static void processDeleteCafeAdmin(long chatId, FoodSearchSystem bot) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Please enter the email of the cafe admin to delete:");

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initiates the process of deleting a cafe admin with the specified email.
     *
     * @param email The email address of the cafe admin to be deleted.
     * @param chatId The ID of the chat where the confirmation message will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */

    private static void deleteCafeAdmin(String email, long chatId, FoodSearchSystem bot) {
        // Check if the email exists in cafeAdminApproved table
        boolean emailExists = checkEmailExists(email);

        if (emailExists) {
            SendMessage confirmationMessage = new SendMessage();
            confirmationMessage.setChatId(String.valueOf(chatId));
            confirmationMessage.setText("Are you sure you want to delete this cafe admin with email address " + email + "?\n" +
                    "Please type 'Yes' to confirm or 'No' to cancel.");
            try {
                bot.execute(confirmationMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Confirms the deletion of a cafe admin with the specified email address.
     *
     * @param email The email address of the cafe admin to be deleted.
     * @param chatId The ID of the chat where the deletion confirmation message will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */


    private static void confirmDeleteCafeAdmin(String email, long chatId, FoodSearchSystem bot) {
        if (email.equalsIgnoreCase(deletedEmail)) {
            // Delete the cafe admin from cafeAdminApproved table
            boolean deleteSuccess = deleteCafeAdminFromApproved(email);

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));

            if (deleteSuccess) {
                message.setText("Cafe admin with email address " + email + " has been successfully deleted.");
            } else {
                message.setText("Failed to delete cafe admin with email address " + email + ".");
            }

            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks if the specified email exists in the cafeAdminApproved table.
     *
     * @param email The email address to check for existence.
     * @return true if the email exists in the table, false otherwise.
     */

    private static boolean checkEmailExists(String email) {
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM cafeAdminApproved WHERE email_address = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes a cafe admin with the specified email address from the cafeAdminApproved table.
     *
     * @param email The email address of the cafe admin to be deleted.
     * @return true if the deletion was successful, false otherwise.
     */

    private static boolean deleteCafeAdminFromApproved(String email) {
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cafeAdminApproved WHERE email_address = ?")) {
            preparedStatement.setString(1, email);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) for email: " + email);
                return true;
            } else {
                System.out.println("No rows deleted for email: " + email);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves the data of cafe admins from the cafeAdminApproved table.
     *
     * @return A ResultSet containing the data of cafe admins.
     */

    private static ResultSet getCafeAdminApprovedData() {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM cafeAdminApproved";

            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Initiates the process of approving a cafe admin and displays the registration list for selection.
     *
     * @param chatId The ID of the chat where the registration list will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */


    private static void processApproveCafeAdmin(long chatId, FoodSearchSystem bot) {
        ResultSet resultSet = getCafeAdminRegisterData();

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));

        StringBuilder responseBuilder = new StringBuilder("Cafe Admin Registration List:\n");

        try {
            int count = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email_address");
                String cafeName = resultSet.getString("cafe_name");
                String inasisName = resultSet.getString("inasis_name");
                String locationLink = resultSet.getString("location_link");

                responseBuilder.append("\n").append(count).append(". Name: ").append(name)
                        .append("\nEmail: ").append(email)
                        .append("\nCafe Name: ").append(cafeName)
                        .append("\nInasis Name: ").append(inasisName)
                        .append("\nLocation Link: ").append(locationLink)
                        .append("\n");

                count++;
            }

            responseBuilder.append("\nPlease enter the email address of the cafe admin you want to approve:");

            message.setText(responseBuilder.toString());
            bot.execute(message);
        } catch (SQLException | TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Approves a cafe admin with the specified email address and moves their data from the cafeAdminRegister to cafeAdminApproved.
     *
     * @param email The email address of the cafe admin to be approved.
     * @param chatId The ID of the chat where the approval message will be sent.
     * @param bot The FoodSearchSystem object used for executing Telegram API requests.
     */

    private static void approveCafeAdmin(String email, long chatId, FoodSearchSystem bot) {
        boolean emailExists = checkEmailExistsInRegister(email);

        if (emailExists) {
            // Move the cafe admin data from cafeAdminRegister to cafeAdminApproved
            boolean moveSuccess = moveCafeAdminToApproved(email);

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));

            if (moveSuccess) {
                message.setText("Cafe admin with email address " + email + " has been successfully approved.");
            } else {
                message.setText("Failed to approve cafe admin with email address " + email + ".");
            }

            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText("Cafe admin with email address " + email + " not found in the cafe admin approved list.");

            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks if the specified email exists in the cafeAdminRegister table.
     *
     * @param email The email address to check for existence.
     * @return true if the email exists in the table, false otherwise.
     */

    private static boolean checkEmailExistsInRegister(String email) {
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM cafeAdminRegister WHERE email_address = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Moves the data of a cafe admin with the specified email address from the cafeAdminRegister to cafeAdminApproved table.
     *
     * @param email The email address of the cafe admin to be moved.
     * @return true if the data was successfully moved, false otherwise.
     */

    private static boolean moveCafeAdminToApproved(String email) {
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM cafeAdminRegister WHERE email_address = ?");
             PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO cafeAdminApproved VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
             PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM cafeAdminRegister WHERE email_address = ?")) {
            selectStatement.setString(1, email);
            insertStatement.setString(1, "");
            insertStatement.setString(2, "");
            insertStatement.setString(3, "");
            insertStatement.setString(4, "");
            insertStatement.setString(5, "");
            insertStatement.setString(6, "");
            insertStatement.setString(7, "");
            insertStatement.setString(8, "");
            insertStatement.setString(9, "");
            insertStatement.setString(10, "");

            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                insertStatement.setString(1, resultSet.getString("email_address"));
                insertStatement.setString(2, resultSet.getString("name"));
                insertStatement.setString(3, resultSet.getString("office_telNo"));
                insertStatement.setString(4, resultSet.getString("mobile_telNo"));
                insertStatement.setString(5, resultSet.getString("cafe_name"));
                insertStatement.setString(6, resultSet.getString("inasis_name"));
                insertStatement.setString(7, resultSet.getString("location_link"));
                insertStatement.setString(8, resultSet.getString("open_time"));
                insertStatement.setString(9, resultSet.getString("close_time"));
                insertStatement.setString(10, resultSet.getString("holiday_status"));

                connection.setAutoCommit(false);
                insertStatement.executeUpdate();
                deleteStatement.setString(1, email);
                deleteStatement.executeUpdate();
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Retrieves the data of cafe admins from the cafeAdminRegister table.
     *
     * @return A ResultSet containing the data of cafe admins.
     */

    private static ResultSet getCafeAdminRegisterData() {
        try {
            Connection connection = DriverManager.getConnection(databaseUrl);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM cafeAdminRegister";

            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

