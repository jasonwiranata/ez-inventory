# B21 - CAP0380 , Ez-Inventory

This Group Consist of :
1. Jason Wiranata Ivanovich (A0050353)
2. Ajeng Ristantia (C2792539)
3. Andre Setiawan Wijaya (C0050467)

## Overview

Ez-Inventory is an application for small - medium scale metal industries to help them manage their production and transcation progress, we use realtime database provided by firebase to store the data. This is a project that we made for Google Bangkit Capstone. This is the second version of the app, we previously had a commit in another [git](https://github.com/jasonwiranata/ez-inventory-management), but the apps and the database didn't connect so we decide to make a new app and a new git


## Libraries Used

Firebase
Firebase Realtime Database (KTX)
Androidx (Material Design, cardview, recyclerview)


## Steps to replicate(How the app works):
Ez-inventory have 5 features, these features are:
1. Production : In the production feature the app will ask user to input the Production ID, Production Date, Material Name, Material Used, Material Unit, Product ID, Product Name, Product Qty, and Product Unit. These data will be stored in Firebase realtime database
2. Sales : In the sales feature the app will ask user to input the Transaction ID, Transaction Date, Product ID, Product Name, Product Sold, and Product Unit. These data will be stored in Firebase realtime database
3. View Inventory : In the View Inventory feature, the app will give the user information of the product, such as , Product ID, Product Name, Product QTY, Product Unit
4. View Productions : In the View productions feature, the app will give the user information of the production, such as Production ID, Production Date, Material Name, Material Used, Material Unit, Product ID, Product Name, Product QTY, Product Unit
