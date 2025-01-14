create database apartment_management
Go
use apartment_management
go

CREATE TABLE [Role] (
  Id          varchar(10) NOT NULL , 
  [Name]        varchar(255) NOT NULL, 
  [Description] varchar(255) NOT NULL, 
  PRIMARY KEY (Id));

  CREATE TABLE Resident (
  Id       varchar(10) NOT NULL, 
  [Name] nvarchar(255) NOT NULL, 
  Bod      date NOT NULL, 
  Email    varchar(255) unique NOT NULL, 
  Phone      varchar(11) unique NOT NULL, 
  [Address]  nvarchar(255) NOT NULL, 
  CCCD     varchar(12) unique NOT NULL,
  username varchar(255) not null,
  [password] varchar(255) NOT NULL,
  roleId varchar(10) NOT NULL REFERENCES [Role](Id),
  PRIMARY KEY (Id));

CREATE TABLE ServiceProvider (
  id          varchar(10) NOT NULL, 
  [name]        nvarchar(255) NOT NULL, 
  [Description] nvarchar(255) NOT NULL, 
  sdt         varchar(11) unique NOT NULL, 
  email       varchar(255) unique NOT NULL, 
  [address]      varchar(255) NOT NULL, 
  PRIMARY KEY (id));

CREATE TABLE ServiceCategory (
  Id          varchar(10) NOT NULL, 
  [Name]        nvarchar(255) NOT NULL, 
  [Detail] varchar(255) NOT NULL, 
  PRIMARY KEY (Id));

CREATE TABLE Staff (
  Id        varchar(10) NOT NULL , 
  [Name] nvarchar(255) NOT NULL, 
  Bod      date NOT NULL, 
  Email    varchar(255) unique NOT NULL, 
  Phone      varchar(11) unique NOT NULL, 
  [Address]  nvarchar(255) NOT NULL, 
  CCCD     varchar(12) unique NOT NULL,
  Salary     int NOT NULL, 
  Education  varchar(255) NOT NULL, 
  Bank       varchar(255) unique NOT NULL, 
  username varchar(255) not null,
  [password] varchar(255) NOT NULL,
  roleId varchar(10) NOT NULL REFERENCES [Role](Id),
  PRIMARY KEY (Id));

CREATE TABLE Employee (
  Id            varchar(10) NOT NULL, 
  [Name] nvarchar(255) NOT NULL, 
  Bod      date NOT NULL, 
  Email    varchar(255) unique NOT NULL, 
  Phone      varchar(11) unique NOT NULL, 
  [Address]  nvarchar(255) NOT NULL, 
  CCCD     varchar(12) unique NOT NULL,
  Companyid      varchar(10) NOT NULL FOREIGN KEY (Companyid) REFERENCES ServiceProvider (id), 
  Startdate      date NOT NULL, 
  Enddate        date, 
  [status]         int NOT NULL, 
  username varchar(255) not null,
  [password] varchar(255) NOT NULL,
  roleId varchar(10) NOT NULL REFERENCES [Role](Id),
  PRIMARY KEY (Id));
--5
CREATE TABLE Apartment (
  Id     varchar(10) NOT NULL, 
  [Square] int NOT NULL, 
  NoPerson  int NOT NULL, 
  [floor]  int NOT NULL, 
  information nvarchar(255),
  rId varchar(10) NOT NULL REFERENCES Resident(Id),
  [status] int NOT NULL, 
  PRIMARY KEY (Id));
--6
CREATE TABLE [Service] (
  Id          varchar(10) NOT NULL, 
  [Name]      nvarchar(255) NOT NULL, 
  cId         varchar(10) NOT NULL FOREIGN KEY (cId) REFERENCES ServiceCategory (Id), 
  UnitPrice   int NOT NULL, 
  [Description] nvarchar(255) NOT NULL, 
  [Status]      varchar(20) NOT NULL, 
  PRIMARY KEY (Id));

CREATE TABLE Invoice (
  id          varchar(10) NOT NULL, 
  total       int NOT NULL, 
  [date]      date NOT NULL, 
  [status]      varchar(10) NOT NULL, 
  [description] nvarchar(255) NOT NULL, 
  rId         varchar(10) NOT NULL FOREIGN KEY (rId) REFERENCES Resident (Id), 
  PRIMARY KEY (id));

CREATE TABLE TypeRequest (
  Id       varchar(10) NOT NULL , 
  [Name] nvarchar(255) NOT NULL, 
  Detail  nvarchar(255) NOT NULL, 
  PRIMARY KEY (Id));


CREATE TABLE Request (
  rId         varchar(10) NOT NULL FOREIGN KEY (rId) REFERENCES Resident (Id), 
  [sId]         varchar(10) NOT NULL FOREIGN KEY ([sId]) REFERENCES Staff (Id),
  Detail varchar(255) NOT NULL,  
  Response    nvarchar(255) NOT NULL, 
  [Status]      varchar(255) NOT NULL, 
  tId         varchar(10) NOT NULL FOREIGN KEY (tId) REFERENCES TypeRequest (Id), 
  PRIMARY KEY (rId, 
  [sId]));

  CREATE TABLE Feedback (
  Id    varchar(10) NOT NULL , 
  Detail varchar(255) NOT NULL, 
  [Date] date NOT NULL, 
  [rId] varchar(10) NOT NULL FOREIGN KEY (rId) REFERENCES Resident (Id), 
  tId         varchar(10) NOT NULL FOREIGN KEY (tId) REFERENCES TypeRequest (Id), 
  PRIMARY KEY (Id));

CREATE TABLE Expenditure (
  Id           varchar(10) NOT NULL, 
  [Detail]         nvarchar(255) NOT NULL, 
  [Provide]  nvarchar(255) NOT NULL, 
  Price        int NOT NULL, 
  [Date]       date NOT NULL, 
  [Status]       int NOT NULL,
  [sId] varchar(10) NOT NULL FOREIGN KEY ([sId]) REFERENCES Staff (Id),
  PRIMARY KEY (Id));

  CREATE TABLE MonthlyInvoice (
  [sid] varchar(10) NOT NULL FOREIGN KEY ([sid]) REFERENCES [Service] (id), 
  [aId] varchar(10) NOT NULL FOREIGN KEY ([aId]) REFERENCES Apartment (Id), 
  quantity  int NOT NULL,  
  PRIMARY KEY ([sid], [aId]));


CREATE TABLE InvoiceDetail (
  [aId] varchar(10) NOT NULL , 
  [sId] varchar(10) NOT NULL , 
  [iId] varchar(10) NOT NULL FOREIGN KEY ([iId]) REFERENCES Invoice (Id), 
  [date]    date NOT NULL, 
  PRIMARY KEY ([aId],[sId],[iId]),
  FOREIGN KEY ([sId], [aId]) REFERENCES MonthlyInvoice ([sId], [aId])
  );
