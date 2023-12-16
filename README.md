[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/XUsNR_oc)
## Requirements for Group Project
[Read the instruction](https://github.com/STIW3054-A222/class-activity-activityteam/blob/main/GroupProject.md)

## Group Info:

| Photo | Matric Number | Name                            | Phone Number |
|-------|---------------|-----------------------------------|--------------|
|![Screenshot - 10_7_2023 , 1_35_21 PM - Copy (3)](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/76acfbd2-e4c6-4157-a7fd-20aa7b928a6f)| 274808        | Raihan Harits (Group Leader)        | 01128661928  |
|![Screenshot - 10_7_2023 , 1_35_21 PM - Copy](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/ebe829fe-6c55-4ed9-89e7-98079a51a725)| 279865        | Balqis Binti Sukria                  | 0174992624   |
|![Screenshot - 10_7_2023 , 1_40_58 PM](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/92582a2f-4ce3-4de6-bc74-e5c5f0a47118)| 280769        | Wardina Syadiyah binti Ahmad Ridhuan | 01137214866  |
|![Screenshot - 10_7_2023 , 1_35_21 PM - Copy (2)](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/9a6d5670-8e26-4268-b1f8-9c38bf887261)| 278415       | Nur Afiqah binti Mohd Amir           | 0184652795   |
|![Screenshot - 10_7_2023 , 1_35_21 PM - Copy (4)](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/08f868b8-6b36-45fc-ab66-188a6ce3c861)| 278062        | Nur Fatin Nasuha Binti Shamas        | 0124907860   |

## Title of your application (a unique title)
Campus Bites Bot

## Abstract (in 300 words)

1. Background
      
      CampusBites bot is a user-friendly Telegram bot for UUM students. Cafe_Admin manages cafeterias and menus, while users explore food listings, compare prices, leave comments, and use location links. System_Admin ensures data integrity. Using SQLite, the bot provides efficient data storage.
      
2. Problem Statement (from an article or newspaper or social media)
     
      The absence of a food search system in UUM's cafes causes inconvenience and frustration for students and staff. To address this, Campus Bites Bot implemented a Telegram bot system for each cafe. Cafe Admin registers and provides reliable food and cafe information. This convenient tool allows users to easily search for food items, cafe locations, and prices, enhancing efficiency and user satisfaction.
   
4. Main objective

      The main objective of Campus Bites Bot are:
      
      1. To provide registration of User to become Cafe Admin.
         The function allow User to register as Cafe Admin. After registration, the User need to wait for System Admin approval first before the User is allowed to enter Cafe Admin system.
      
      2. Functionality of Cafe Admin
      Approved Cafe Admin can enter the system for Cafe Admin so that Cafe Admin can add food information, update added food information, delete food information, view user's food comment, and send daily status message that will be pushed to the users at 8:00 a.m.

      3. Functionality of User
      Users can view food lists from all the cafe available and they can also give comments and ratings of the food they wanted to. The comment can be view by Cafe Admin and all users can view food ratings. Users can also compare food prices from different cafes to select the best one and get food suggestions by the Campus Bites Bot.

      4. Functionality of System Admin
      System Admin can view all of the Cafe Admin information, including user comments. The System Admin can also delete any registered Cafe Admin if needed.

5. Methodology
   
   The methodology for the Campus Bites Bot are:

         1. Requirements Analysis:
               - Identify system requirements based on specifications.
               - Define user roles and functionalities.
               - List functional and non-functional requirements.

         2. Design and Architecture:
               - Explain overall system design and architecture.
               - Justify use of Telegram Bot platform and Java programming language.
               - Present class diagram showing relationships.

         3. Implementation:
               - Describe step-by-step implementation process.
               - Discuss coding practices and design patterns.
               - Address implementation challenges.

         4. System Testing:
               - Explain testing approach for correctness and reliability.
               - Describe test scenarios and cases.
               - Present test results, including bug resolutions.

         5. Results and Evaluation:
               - Evaluate system performance and usability.
               - Assess fulfillment of requirements.
               - Analyze user feedback for effectiveness.

7. Result

     The Campus Bites Bot on Telegram offers UUM students a comprehensive solution for finding and accessing food options on campus. Cafe_Admin registers cafeterias with details like contact info, hours, menus with prices and availability. Users can view, compare, comment, and rate food options. Location links aid navigation. System_Admin manages registrations and data integrity in the SQLite database (campusbites.db). This system enhances UUM's user experience, accessibility, and decision-making. 
   
8. Conclusion

      The Campus Bites Bot is a Food Searching System for UUM students on Telegram. It simplifies finding and comparing food options at campus cafeterias. Cafe_Admin manages cafeteria details, users view food lists, comment, rate, and compare prices. System_Admin oversees operations. This system enhances convenience and accessibility. Future enhancements may include online ordering.

## Flow Diagram of the requirements (MUST be included in your presentation)

![Screenshot - 10_7_2023 , 7_06_41 PM](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/174a45c3-c060-425e-88a4-e9de80f08f8a)


## Use Case Diagram
![CmapusBItes drawio](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/f8d22b87-895c-4b4e-bbfd-7bc48f9b5191)


## UML Class Diagram
![WhatsApp Image 2023-07-10 at 12 55 58](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/bae60668-47e9-4485-b170-c96d49441a23)

## Database Design
![image](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/55873376/7f7454d8-2e83-4862-a2b2-cd1db8bd04fd)

## JavaDoc
(https://github.com/STIW3054-A222/groupproject-coding-hamsters/tree/master/JavaDoc)

## User manual/guideline for testing the system <br>

To use the Campusbites bot, follow these steps:

1.Start the bot: Open your Telegram app and search for the bot username (A222_STIW3054_CampusBitesBot).<br>

 <br>2.Initiate the conversation: Send a message "/start" to the bot. <br>
 
 <br>3.Select User Role:
<br>System Admin: Send the command "/systemAdmin" to access system admin functionalities. note: Accessible only to authorized system administrators.
<br>Regular User: Send the command "/regularUser" to access regular user functionalities.

<br>System Admin Functionalities:
<br>Accessible only to authorized system administrators.
<br>Authenticate: The bot will prompt you to enter a password(admin1234)to verify your identity as a system admin.<br>
<br>Available Options:
<br> * View Cafe Admin Info: Send the command "/viewCafeAdminInfo" to view cafe admin information.
<br>* Receive Cafe Admin List: The bot will display the approved cafe admin details.
<br>* Delete Cafe Admin: Send the command "/deleteCafeAdmin" to delete a cafe admin.
<br>* Enter Email: Reply with the email address of the cafe admin you want to delete.
<br>* Confirm Deletion: The bot will confirm the deletion request.
<br>* Confirmation Options: Reply with "Yes" to confirm deletion or "No" to cancel the deletion.
<br>* Approve Cafe Admin: Send the command "/approveCafeAdmin" to approve a cafe admin.
<br>* Receive Registration List: The bot will display the cafe admin registration list.
<br>* Enter Email: Reply with the email address of the cafe admin you want to approve.
<br>* Approval Process: The bot will move the cafe admin data from registration to approved list.

<br>Cafe Admin 
<br> Send the command "/cafeAdmin" to begin the process.
<br> The bot will respond with available options:
 <br> * To register as a cafe admin, send the command "/register".
 <br> * If you are already registered, you can skip the registration process and perform other operations.  <br> 
 
 <br> Cafe Admin Registration Process:
 <br> *Send the command "/register" to start the registration process.
 <br> *The bot will prompt you to enter your email address.
 <br> *Reply with your email address to proceed.
 <br> *Next, you will be asked to enter your name, office telephone number, mobile telephone number, cafe name, INASIS name, location link, opening time, closing time, and holiday status.
 <br> *Provide the requested information one by one in separate messages.
 <br> *Once you have provided all the details, the bot will save your registration information to the database.
 <br> *You will receive a confirmation message stating that your registration was successful, and your details have been recorded. <br> 
 
 <br> Already Registered Cafe Admin:  
 <br> *If you are already a registered cafe admin, you can access your information and perform certain operations.
 <br> *Send the command "/alreadyRegistered" to retrieve your admin details.
 <br> *The bot will ask you to enter your email address.
 <br> *Reply with your email address to proceed.
 <br> *The bot will check if your email exists in the database and if you are an approved cafe admin.
 <br> *If you are approved, the bot will provide your admin details, such as name, contact information, etc. <br> 
 
 <br> You will also receive a list of available commands to perform various operations:
 <br> - "/add" - Add food price.
 <br> - "/update" - Update food price.
 <br> - "/delete" - Delete food price.
 <br> - "/sendStatus" - Send status message.
 
 <br> Add Food Price:
 <br> *Send the command "/add" to add food prices for your cafe.
 <br> *The bot will prompt you to enter the food type.
 <br> *Reply with the food type (e.g., appetizer, main course, dessert).
 <br> *Next, you will be asked to enter the food name, food price, food image, and food status.
 <br> *Provide the requested information one by one in separate messages.
 <br> *Lastly, enter your cafe name and the location link of your cafe.
 <br> *Once you have provided all the details, the bot will save the food details to the database.
 <br> *You will receive a confirmation message stating that the food details have been added successfully. <br> 
 <br> Update Food Price: 
 <br> *Send the command "/update" to update food prices for your cafe.
 <br> *The bot will prompt you to enter the cafe name.
 <br> *Reply with your cafe name to proceed.
 <br> *The bot will provide you with a list of food details for the selected cafe.
 <br> *Enter the food ID of the item you want to update.
 <br> Choose the field you want to update:
 <br> *Reply with "1" to update the food type.
 <br> *Reply with "2" to update the food name.
 <br> *Reply with "3" to update the food price.
 <br> *Provide the updated value for the selected field.
 <br> *The bot will update the information in the database and provide a success or failure message.  <br> 
 
 <br> Delete Food Price:
 <br> *Send the command "/delete" to delete food prices from your cafe menu.
 <br> *The bot will prompt you to enter the cafe name.
 <br> *Reply with your cafe name to proceed.
 <br> *The bot will provide you with a list of food details for the selected cafe.
 <br> *Enter the food ID of the item you want to delete.
 <br> *The bot will delete the selected food item from the database and provide a success or failure message.
 <br> Send Status Message:
 <br> *Send the command "/sendStatus" to set a daily status message for your cafe.
 <br> *The bot will ask you to enter the status message (e.g., promotion, emergency closure).
 <br> *Reply with the status message you want to send.
 <br> *The bot will confirm that the status message has been set.
 <br> *The status message will be sent daily at 8:00 AM.

<br>Regular User Functionalities:<br>
<br>* View Food Price: Send the command "/viewFoodPrice" to view food prices
<br>* Enter Cafe Name: Reply with the name of the cafe to see its food prices.
<br>* Receive Food Prices: The bot will display the food prices for the specified cafe.
<br>* Compare Food Price: Send the command "/compareFoodPrice" to compare food prices.
<br>* Enter Food Name: Reply with the name of the food to compare its prices.
<br>* Receive Food Prices: The bot will display the food prices for the specified food item across different cafes.
<br>* Leave Feedback: Send the command "/leaveFeedback" to leave a comment and rating.
<br>* Enter Food Name: Reply with the name of the food you want to leave feedback for.
<br>* Enter Cafe Name: Reply with the name of the cafe where you had the food.
<br>* Enter Your Comment: Reply with your comment about the food or cafe.
<br>* Enter Rating: Reply with a number from 1 to 5 to rate your experience.
<br>* Feedback Recorded: The bot will inform you that your feedback has been recorded.
<br>* View Cafe List: Send the command "/viewCafeList" to view the list of cafes and their locations.
<br>* Receive Cafe List: The bot will display the list of cafes and their locations.


## Result/Output (Screenshot of the output)

 START TELEGRAM

![START](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/a98f11fe-6f49-40c2-bff1-848d669d022a)

CAFE ADMIN: REGISTRATION

![CAR1](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/28540fd8-5c2f-4fd5-8d48-46f25328c033)

![CAR2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/1c786b2a-1e5b-4c46-993f-4a19fbb3ec34)

SYSTEM ADMIN: LIST REGISTRATION AND APPROVED CAFE ADMIN

![SALIST RGEISTERAPPROVED_1](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/2b8dccd9-ac90-40b4-9513-9724894bb9c5)

![SALIST RGEISTERAPPROVED_2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/886663e7-e948-4306-8640-c344a1252afd)

DELETE CAFE ADMIN

![DELETECAFEADMIN](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/de4132d5-04fc-4330-8021-f50e129f3257)

CAFE ADMIN: ADD FOOD DETAILS

![CAFEADMINADD](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/4b75f1be-b006-495e-8d07-7eb2ca3e07a6)

![CAFEADMINADD2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/dbb7ddf2-b706-46cb-b960-ebb75b376aca)

CAFE ADMIN: UPDATE

![CAFEADMINUPDATE1](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/5b4ed721-8108-4d86-a3e1-aa078350443f)

![CAFEADMINUPDATE2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/73fbae6c-621c-4ce7-a138-ea9cf4b43c67)

CAFE ADMIN: DELETE

![DELETECAFEADMIN](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/556cb276-f60c-4a8c-9a93-898f31afb467)

![DELETECAFEADMIN2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/09ccc698-8a57-4be7-ae60-fa9a6b476f22)

SEND STATUS

![SENDSTATUS](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/2871ee65-70f6-4b5f-8068-ff41c626fd21)

VIEW AND COMPARE CAFE AND FOOD

![VIEWCOMPARE](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/6659abca-c689-4e30-aa91-411c03cf6558)

FEEDBACK

![FEEDBACKNCAFELIST](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/ae8720f0-675d-468c-92fe-cabbcfb28b55)

![FEEDBACKNCAFELIST2](https://github.com/STIW3054-A222/groupproject-coding-hamsters/assets/73435522/32366146-1ca7-4a5a-8584-6fd361e23225)



## References (Not less than 20)

1.	Building a JAVA Telegram Bot and Deploying in heroku. (2022, March 5). DEV Community. https://dev.to/vinuxd/from-building-a-java-telegram-bot-to-deployment-4kc9

2.	ChatGPT. (n.d.). Food Details by Cafe. https://chat.openai.com

3.	Creating and using a Telegram Bot with Java. (2022, April 6). YouTube. https://www.youtube.com/watch?v=LCuC88s6m4k

4.	Deploying with Git | Heroku Dev Center. (2023, May 4). Deploying With Git | Heroku Dev Center. https://devcenter.heroku.com/articles/git

5.	Direct Heroku Deploy Telegram Bot. (2021, April 6). YouTube. https://www.youtube.com/watch?v=qIuGJEAAIHY

6.	GitHub Copilot · Your AI pair programmer. (n.d.). GitHub. https://github.com/features/copilot

7.	How to create Telegram Bot in Java. (2021, November 11). YouTube. https://www.youtube.com/watch?v=XjOnp8TVNSQ

8.	How can I deploy a telegram bot from intellij to heroku? I write the code using Java from a maven project. (2020, May 28). Stack Overflow. https://stackoverflow.com/questions/62067395/how-can-i-deploy-a-telegram-bot-from-intellij-to-heroku-i-write-the-code-using

9.	How to send local photo in telegram bot for java. (2018, October 23). Stack Overflow. https://stackoverflow.com/questions/52955352/how-to-send-local-photo-in-telegram-bot-for-java

I.	(2022, June 22). Deploy Java Telegram Bot on Heroku Server. Medium. https://medium.com/@learntodevelop2020/deploy-java-telegram-bot-on-heroku-server-42bfcfc311d3

10.	Introduction - Java Telegram Bot Tutorial. (n.d.). Introduction - Java Telegram Bot Tutorial. https://monsterdeveloper.gitbook.io/java-telegram-bot-tutorial/

11.	Importing telegram bot dependencies using Maven in Visual Code? (2018, April 14). Stack Overflow. https://stackoverflow.com/questions/49828661/importing-telegram-bot-dependencies-using-maven-in-visual-code

12.	MySQL | IntelliJ IDEA. (n.d.). IntelliJ IDEA Help. https://www.jetbrains.com/help/idea/mysql.html

13.	Minh, N. H. (2016, November 28). Java Connect to SQLite with JDBC Example. Java Connect to SQLite With JDBC Example. https://www.codejava.net/java-se/jdbc/connect-to-sqlite-via-jdbc

14.	Montalto, P. (2023, February 1). Sending a photo to a Telegram channel the easy way. Medium. https://xabaras.medium.com/sending-a-photo-to-a-telegram-channel-the-easy-way-defbfed30dd

15.	org.telegram.telegrambots.api.methods.send.SendMessage. java code examples | Tabnine. (n.d.). org.telegram.telegrambots.api.methods.send.SendMessage. Java Code Examples | Tabnine. https://www.tabnine.com/code/java/methods/org.telegram.telegrambots.api.methods.send.SendMessage/%3Cinit%3E

16.	R. (2023, June 11). GitHub - rubenlagus/TelegramBots: Java library to create bots using Telegram Bots API. GitHub. https://github.com/rubenlagus/TelegramBots

17.	Thread Scheduling - GeeksforGeeks. (2020, May 19). GeeksforGeeks. https://www.geeksforgeeks.org/thread-scheduling/

18.	Telegram Push Notifications: A Guide to Telegram Bot Push Notification. (n.d.). Telegram Push Notifications: A Guide to Telegram Bot Push Notification. https://respond.io/blog/telegram-push-notifications

19.	T. (n.d.). Notifications and Alarms on your smartphone using Telegram Bot. ThingsBoard. https://thingsboard.io/docs/user-guide/rule-engine-2-0/tutorials/integration-with-telegram-bot/

20.	Telegram Bot in Java, introduction for developers. (2018, September 17). CodeGym. https://codegym.cc/groups/posts/telegram-bot-in-java

21.	Try Bard, an AI experiment by Google. (n.d.). ‎Try Bard, an AI Experiment by Google. https://bard.google.com

22.	SQlite Java - How To Use JDBC To Interact with SQLite. (n.d.). SQLite Tutorial. https://www.sqlitetutorial.net/sqlite-java/

23.	SQLite JAVA Tutorial - Tutlane. (n.d.). SQLite JAVA Tutorial - Tutlane. https://www.tutlane.com/tutorial/sqlite/sqlite-java-tutorial

## Youtube Presentation (10%)
https://youtu.be/k0YJl4L5WPo

