# ELMS: Express Logistics Management System

----------------------

## Project Introduction ##
ELMS is an all-round system builded for an express company to facilitate the efficiency of goods transportation, orders approval, warehouse management, etc.

![ELMS LOGO][1]
## Function Introduction ##

### Express Order Management ###
* Logistics Order Tracking: Allow users to track the order without login
* Build, edit or delete Order: Allow saleman to manage and track the order
* Manage other documents including Truck Loading Documents, Allocate Documents(Used by courier), Arrive Documents, etc.


### Trucks & Drivers Message Management ###
Allow Intermediate Center Manager to check, add or delete trucks and drivers message


### Warehouse Management ###
* Allow Warehouse Staff and Warehouse Manager to check,add or delete goods of the Warehouse.
* Allow Warehouse Manager to verifiy the inventory, set alarm value and recover from alarm state
* Automatically alarm the manager if the goods exceed the alarm value

### Staff and Ministries Management ###
* Allow General Manager to manage the staff message and their priority
* Allow General Manager to manage the Minsitries of the company and staff belong to them

### Finance Report and Cost Control ###
* Allow Financeman to Verify the very days' bills order : System will automatically create the bills of all the orders of that day
* Allow Financeman to manage the bank account, cost and other finance message.
* Allow Financeman to build a new bill of the whole company

### Blueprint and Overall Policy Management ###
* Allow General Manager to Approve/Disapprove the Documents created in the very day
* Allow General Manager to stipulate the salary strategy of the company
* Allow General Manager to stipulate some constants like Cost per mile, price of the order
* Allow General Manager to read the statistics based on the data in the system


## Pics Preview##
![Track Order][4]
<center>Login</center>
![Track Order][2]
<center>Track Order</center>
![Add New Order][3]
<center>Add New Order</center>
![Driver Message Management][5]
<center>Driver Message Management</center>
![Add New Driver][6]
<center>Add New Driver</center>
![Financeman Main Page][7]
<center>Financeman Main Page</center>
![Statistics Creation Page][8]
<center>Statistics Creation Page</center>
![General Manager Main Page][9]
<center>General Manager Main Page</center>
![Documents Approval Page][10]
<center>Documents Approval Page</center>
![Modify Constants][11]
<center>Modify Constants</center>

## Getting Started ##
### Overview ###
ELMS is a Java-based, C/S-Style Project, using Maven as modules management tool.
To run this program, you will need at least **JDK8** & **MySQL**

* First, import the SQL file 'elmssql.sql' in folders ELMSServer to your database.
* Next, if you are macOS users, change the value of "inWindow" in configuration file "globalConfig.xml" under the path "ELMSClient/docs"
* Third, double clicked the ELMSServer.jar in folder 'ELMSServer' to open the server
* Finally, double clicked the ELMSClient.jar in folder 'ELMSClient' to open the client
* Now, enjoy the system :)

### Project Structures ###

ELMS is a maven project with three modules.
Common module is the depended by other two modules.

* ELMSClient: The client module
* ELMSServer: The server module
* common: Documents & Common parts of the client and the server
* Documents are under the common, where you can find full description of this project

You can find more about the software structure in the documents of common folder.


## License ##
Apache License Version 2.0

## About us ##
![ELMS LOGO][13]
![ELMS LOGO][12]









  [1]: readmePics/logo.jpg
  [2]: readmePics/trackOrder.png
  [3]: readmePics/addOrderPanel.png
  [4]: readmePics/login.png
  [5]: readmePics/DriverMessageManagement.png
  [6]: readmePics/DriverMessageManagement2.png
  [7]: readmePics/FinancemanPreview.png
  [8]: readmePics/Statistics.png
  [9]: readmePics/GeneralManagerPreview.png
  [10]: readmePics/DocumentApproval.png
  [11]: readmePics/ConstantsManagement.png
  [12]: readmePics/icon.png
  [13]: readmePics/teamMumber.png
  




