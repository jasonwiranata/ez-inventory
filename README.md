# B21 - CAP0380 , Ez-Inventory

This Group Consist of :
1. Jason Wiranata Ivanovich (A0050353) - Mobile Development (Android) [Git Profile](https://github.com/jasonwiranata/)
2. Ajeng Ristantia (C2792539) - Cloud Computing [Git Profile](https://github.com/ajengristantia)   
3. Andre Setiawan Wijaya (C0050467) - Cloud Computing [Git Profile](https://github.com/swerdd)

## Overview

Ez-Inventory is an application for small - medium scale metal industries to help them manage their production and transcation progress, we use realtime database provided by firebase to store the data. This is a project that we made for Google Bangkit Capstone. This is the second version of the app, we previously had a commit in another [git](https://github.com/jasonwiranata/ez-inventory-management), but the apps and the database didn't connect so we decide to make a new app and a new git


## Libraries Used

Firebase
Firebase Realtime Database (KTX)
Androidx (Material Design, cardview, recyclerview)


## Steps to replicate(How the app works):
Ez-inventory have 5 features, these features are:
1. Production : In the production feature the app will ask user to input the :
   Production ID, 
   Production Date, 
   Material Name, 
   Material Used, 
   Material Unit, 
   Product ID, 
   Product Name, 
   Product Qty, and 
   Product Unit. 
   The app will take these values from their respective EditText fields, save them in variables, create their respective data models (ProductionData and InventoryData),
   and then insert them into their respective child nodes in the Firebase Realtime Database.
2. Sales : In the sales feature the app will ask user to input the :
   Transaction ID, 
   Transaction Date, 
   Product ID, 
   Product Name, 
   Product Sold, and 
   Product Unit. 
   The app will take these values from their respective EditText fields, save them in variables, create their respective data models (TransactionData and InventoryData),
   and then insert the new transaction as a new item in the database, as well as update the Inventory by deducting the amount sold from the amount in stock.
3. View Inventory : In the View Inventory feature, the app will give the user information of the product, such as ;
   Product ID, Product Name, Product QTY, Product Unit
4. View Productions : In the View productions feature, the app will give the user information of the production, such as;
   Production ID, Production Date, Material Name, Material Used, Material Unit, Product ID, Product Name, Product QTY, Product Unit
5. View Transactions : In the View Transactions, the app will give the user information of the transactions, such as;
   Transaction ID, Transaction Date, Product ID, Product Name, Product Sold, Product Unit. 
   For each of aforementioned Views, we implemented simple Adapters that accepts an ArrayList of their respective data objects (InventoryData for Inventory, and so on).
   We obtain the values of the objects by using a ValueEventListener from Firebase to get a snapshot of the data.
**Note that this features are all synced together.**

## Screenshot
![SplashScreen](https://github.com/swerdd/Ez-inventory-image/blob/main/splash%20screen.png)
![Homepage](https://github.com/swerdd/Ez-inventory-image/blob/main/Homepage.png)
![Production](https://github.com/swerdd/Ez-inventory-image/blob/main/production.png)
![Transaction](https://github.com/swerdd/Ez-inventory-image/blob/main/Transaction.png)
![Inventory](https://github.com/swerdd/Ez-inventory-image/blob/main/Inventory.png)
![Production_List](https://github.com/swerdd/Ez-inventory-image/blob/main/production_list.png)
![Transaction_List](https://github.com/swerdd/Ez-inventory-image/blob/main/Transaction_list.png)

## Features that we think need to be improved / make
1. Production needs validation for duplicate items
2. Conversion unit function for different SI unit
3. Sorting features in View Inventory, View Productions, View Transactions
4. Enable delete entry
5. Clean Architecture can be implemented
6. Infrastructure Improvement
7. Login / Authentication feature
8. Data security improvement

## Presentation Link:
[Presentation](https://docs.google.com/presentation/d/1fO5IRLLXufWxQ0TrCMS86LdJtYh1WQIa0pg2NjTP2To/edit?usp=sharing)

## Go-To Market Link:
[Go-To Market](https://docs.google.com/presentation/d/1RL5Y3AYhjTbI1nsLoF-HaL4rwKQZxklvr_ZP5O1hHrA/edit?usp=sharing)

## Youtube Link:
[Youtube](https://youtu.be/qlNun60bX8g)

## Contribution
**Pull request are denied, because we are more likely to remake the project.**

