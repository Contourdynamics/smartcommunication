# Communication Management System (CMS)

The Communication Management System is a web based administration panel for the designing communication services. the mediaserver developed on sip servlet is providing converged application framework. media server can be configured dynamically via web interface to work as per enterprise requirements.

1. CMS FEATURES:
============

1.1- CUSTOMER SUPPORT- includes the Task List, and CallCenter panel Module.

1.2- SALES MANAGEMENT-  includes Orders, Contracts management and promotional Campaigns for increasing revenue

1.3- INVENTORY MANAGEMENT- for Communication oriented Resources

1.4- SMART BILLING SUB SYSTEM - includes Prepay/Postpaid billing for services, resources and packages purchased.

1.5- BI REPORTING - Jasper based graphical Reporting system included. pre-designed and custom reporting supported.

1.6- ADMINISTRATION-  includes the Templating of documents, Workflow and Business Rules Application designing

1.7- SERVICS PORTALS- includes PBX, CallCenter, Campaigns, BLF panel, Communicator and EFax

1.8- DIRECTORY-  Module lets you manage internal and external Contacts which can be utilized in communications.



2. CMS SERVICES:
============
2.1 CONVERGED APPLICATIONS:
    
These are basically the inbound based converged applications designed to work for specific functionalities. system provides a set of converged modules based on which Customers will be able to configure the Applications. Customers can design provided number of applications based on its package for subscriptions. 

Customer will be able to design a Converged system which will include:

    1- Communication Modules
    2- Business Modules 

Example of these applications can be, Recording based system; which on identifying the CLID of caller can record MEMO for specific user and store that recording against that user can send email on compeletion of any recording. and simple example can be a PBX system desiging an IVR of any company based on Modules provided. 

Modules workflows and logic will be designed by Admin user via Workflow Engine. 

2.2 MARKETING SERVICES:

Marketing Services provides the 
    
    1- Outbound Campaigns 
        1- Polling
        2- SMS Marketing
        3- Announcements
        4- Surveys
    2- Packages
        1- Promotional Packages
        2- Packages Designers
        3- Bundle Packages
        
These all Services will be designed in CMS by Customers for the business aspects, and every service workflow will be designed by Administrator of system. 


2.3 CALL-CENTER ACD SERVICE:

This module hold the Call center based ACD Skill based routing engine, which has been designed on Smart queues developed and designed by Administrator for specific business requirements. The customers can design the consumers with skills for provisioning of call handlings by selected consumers. 

The workflow for the ACD skill based routing and call flow will be designed via BPM editor by Administor for the application, and will be applied to all customers. 

2.4 CALLING CARD SERVICE:

The Calling Card service is responsible for handling all outbound dialings by Consumers. Every Consumer will be provided by a Balance and can select the package for dialing. Based on conditions designed by Administrator for dialing out system will perform Authorization and Accounting for all calls. other functionality provided by this service is LCR, which will be selecting the Carrier Vendor for dialing onto destinations, rules for the selection will be designed by Administrator view BPM editor dynamically and applied to overall deployment. 

3. CMS USER ROLES:
============
Communication management system has three roles for the users which operates in different business aspects explained as follow:

3.1 SYSTEM ADMINISTRATOR. 

This user is basically the system designer, which will be working on BPM workflow engine to construct the overall application. the one deployment will work on the provided workflows. Administrator will be able to manage customers, and design the packages and services which can be sell to Customers. This user has two responsibilities 

    1- Designing the System
    2- Desiging and Managing Customers
This user can be termed as Whole Seller of Communication Management System.

3.2 CUSTOMERS:

These users will be the enterprises or individual identities which will be configuring the sytsem for their businesses. These user will not have any access to Workflow or desiging the system. Customers will be able to configure the designed system for different set of services. Customers will be purchasing the services account from administrator and as well can resell them to consumers. Typical example is Customer can be Admin of PBX for all extensions and extensions will be consumers, and other example can be Administrator for configuring the Calling Card service for enabling the dialing out of all consumers. 

This user can be termed as Retailer of Communication Management System. CMS will provide a basic branding for these accounts to be shown for Consumers. 

3.3 CONSUMERS:

These are end users in the system which will be consuming the services, these users will only have access to portals of the system where they can update there accounts and consume services. These consumers will hold the web based, mobile applications. 

# Layout of Smart Communication Application:

![](https://github.com/Contourdynamics/smartcommunication/blob/master/Layout/Layout-SmartCommunication.png)
