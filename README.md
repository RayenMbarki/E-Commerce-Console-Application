#E-COMMERCE CONSOLE APPLICATION (exam)
##Overview
This project is an e-commerce console application developed using object-oriented programming (OOP) functionalities. The primary focus based on implementing OOP fundamentals using various features. The app establishes an aggregation relationship between users and admins facilitating an interactive and functional e-commerce experience.

##Design Decision
 -CLASS: 1- User , Admin : each class of them can login separately and their members are different so that their access level could not be the same. 2- Categories of products : that implement the product interface which give the admin and the user also to choose whatever type of product they want 3- order class : to make an order and it is also related to payment class and have access to the user shopping cart which is class contating the products a user have added when searching on the app 4- inventory manager class : to manage the user shopping cart : when checking the quantity of a product before starting the order process 5- many classes of payment process and each of them implement the UserOrderPayment which give more payment types for the user

##Features
- User / Admin connection system
a user : can login / logout to the app with the only id and password when creating its account , he's able to search for the product , transfer money to his application wallet , pay and rate a product .
admin : can login / logout , has access to the catalogue of the available products and can manage its
- Admin Page
Product Manager : make him add , delete , update a product on the app and display all the existed products
- User Page
cart management : can filter products , search for them , also he can add , remove or update quantity of a product in his shopping cart
Getting started

##Getting Started
- to run the console app :

    git clone https://github.com/RayenMbarki/E-Commerce-Console-Application.git


    cd E-Commerce-Console-Application/App
    javac src/Main.java
    java Main





    ```
