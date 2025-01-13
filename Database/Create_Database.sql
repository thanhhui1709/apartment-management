--create database apartment_management
use apartment_management

CREATE TABLE [Role] (
  Id          int NOT NULL , 
  [Name]        varchar(255) NOT NULL, 
  [Description] varchar(255) NOT NULL, 
  PRIMARY KEY (Id));

CREATE TABLE ServiceProvider (
  id          varchar(10) NOT NULL, 
  [name]        nvarchar(255) NOT NULL, 
  [Description] nvarchar(255) NOT NULL, 
  sdt         varchar(11) unique NOT NULL, 
  email       varchar(255) unique NOT NULL, 
  [status]      varchar(255) NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE ServiceCategory (
  Id          varchar(10) NOT NULL, 
  [Name]        nvarchar(255) NOT NULL, 
  [Description] varchar(255) NOT NULL, 
  PRIMARY KEY (Id));

CREATE TABLE Person (
  Id       varchar(10) NOT NULL, 
  Fullname nvarchar(255) NOT NULL, 
  Bod      date NOT NULL, 
  Email    varchar(255) unique NOT NULL, 
  Sđt      varchar(11) unique NOT NULL, 
  Address  nvarchar(255) NOT NULL, 
  CCCD     varchar(12) unique NOT NULL, 
  PRIMARY KEY (Id));
  --2
CREATE TABLE Account (
  username varchar(20) NOT NULL, 
  [password] varchar(255) NOT NULL, 
  pId      varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  [Role]     int NOT NULL FOREIGN KEY ([Role]) REFERENCES [Role] (Id), 
  PRIMARY KEY (username));
  
--3
CREATE TABLE [Admin] (
  pId       varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  startdate int NOT NULL, 
  Enddate   date, 
  salary    int NOT NULL, 
  education int, 
  [Status]    int NOT NULL, 
  Bank      varchar(255) unique NOT NULL, 
  PRIMARY KEY (pId));
--4
CREATE TABLE Employee (
  pId            varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  JobDescription nvarchar(255) NOT NULL, 
  Companyid      varchar(10) NOT NULL FOREIGN KEY (Companyid) REFERENCES ServiceProvider (id), 
  startdate      date NOT NULL, 
  Enddate        date, 
  [status]         int NOT NULL, 
  PRIMARY KEY (pId));
--5
CREATE TABLE Apartment (
  Id     varchar(10) NOT NULL, 
  typeid int NOT NULL, 
  [Square] int NOT NULL, 
  price  int NOT NULL, 
  [floor]  int NOT NULL, 
  [status] int NOT NULL, 
  PRIMARY KEY (Id));
--6
CREATE TABLE Invoice (
  id          varchar(10) NOT NULL, 
  pId         varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  total       int NOT NULL, 
  [date]      int NOT NULL, 
  [status]      varchar(10) NOT NULL, 
  [description] nvarchar(255) NOT NULL, 
  PRIMARY KEY (id));
--7
CREATE TABLE [Service] (
  Id          varchar(10) NOT NULL, 
  [Name]        nvarchar(255) NOT NULL, 
  cId         varchar(10) NOT NULL FOREIGN KEY (cId) REFERENCES ServiceCategory (Id), 
  UnitPrice   int NOT NULL, 
  [Description] nvarchar(255) NOT NULL, 
  [Status]      varchar(20) NOT NULL, 
  PRIMARY KEY (Id));


CREATE TABLE Resident (
  pId    varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  Bank   varchar(255) unique NOT NULL, 
  [Status] varchar(255) NOT NULL, 
  PRIMARY KEY (pId));

CREATE TABLE Request (
  pId         varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Resident (pId), 
  [Description] nvarchar(255) NOT NULL, 
  Request     nvarchar(255) NOT NULL, 
  Response    nvarchar(255) NOT NULL, 
  [Status]      varchar(255) NOT NULL, 
  [Date]      date NOT NULL, 
  PRIMARY KEY (pId, 
  [Date]));

CREATE TABLE AprtmentOwner (
  aId       varchar(10) NOT NULL FOREIGN KEY (aId) REFERENCES Apartment (Id), 
  pId       varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Resident (pId), 
  startdate date NOT NULL, 
  noperson  int NOT NULL, 
  [status]    int NOT NULL, 
  PRIMARY KEY (aId));

CREATE TABLE Accountant (
  pId        varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  StartDate  date NOT NULL, 
  Enddate    date, 
  Salary     int NOT NULL, 
  Education  varchar(255) NOT NULL, 
  Experience varchar(255), 
  Bank       varchar(255) unique NOT NULL, 
  supervisor varchar(10) NOT NULL FOREIGN KEY (supervisor) REFERENCES [Admin] (pId), 
  [status]     varchar(255) NOT NULL, 
  PRIMARY KEY (pId));


CREATE TABLE Expenditure (
  Id           varchar(10) NOT NULL, 
  [Name]         nvarchar(255) NOT NULL, 
  AccountantId varchar(10) NOT NULL FOREIGN KEY (AccountantId) REFERENCES Accountant (pId), 
  [Description]  nvarchar(255) NOT NULL, 
  Price        int NOT NULL, 
  [Date]       date NOT NULL, 
  [Status]       int NOT NULL, 
  [Provider]     varchar(255) NOT NULL, 
  PRIMARY KEY (Id));
--17
CREATE TABLE Render (
  pId       varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  aId       varchar(10) NOT NULL FOREIGN KEY (aId) REFERENCES Apartment (Id), 
  rId       varchar(10) NOT NULL FOREIGN KEY (rId) REFERENCES Resident (pId), 
  StartDate date NOT NULL, 
  Enddate   date NOT NULL, 
  [Status]    varchar(255) NOT NULL, 
  PRIMARY KEY (pId, 
  aId));

CREATE TABLE RoomUsage (
  ApartmentId varchar(10) NOT NULL FOREIGN KEY (ApartmentId) REFERENCES Apartment (Id), 
  ServiceId   varchar(10) NOT NULL FOREIGN KEY (ServiceId) REFERENCES [Service] (Id), 
  rId         varchar(10) NOT NULL, 
  [sId]         varchar(10) NOT NULL, 
  Quantity    int NOT NULL, 
  total       int NOT NULL, 
  PRIMARY KEY (ApartmentId, 
  ServiceId));

CREATE TABLE Feedback (
  pId    varchar(10) NOT NULL FOREIGN KEY (pId) REFERENCES Person (Id), 
  Title  varchar(255) NOT NULL, 
  Detail varchar(255) NOT NULL, 
  [Date] date NOT NULL, 
  PRIMARY KEY (pId, 
  [Date]));

CREATE TABLE InvoiceDetail (
  Invoiceid varchar(10) NOT NULL FOREIGN KEY (Invoiceid) REFERENCES Invoice (id), 
  [sId]       varchar(10) NOT NULL FOREIGN KEY ([sId]) REFERENCES [Service] (Id), 
  quantity  int NOT NULL, 
  [date]    int NOT NULL, 
  PRIMARY KEY (Invoiceid, 
  sId));
