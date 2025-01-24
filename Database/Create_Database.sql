create database apartment_management
Go
use apartment_management
go

CREATE TABLE [Role] (
  Id          varchar(10) NOT NULL , 
  [Name]        varchar(255) NOT NULL, 
  [Description] varchar(4000) NOT NULL, 
  CONSTRAINT PK_Role PRIMARY KEY (Id));

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
  roleId varchar(10) NOT NULL CONSTRAINT FK_Resident_Role  REFERENCES [Role](Id),
  CONSTRAINT PK_Resident PRIMARY KEY (Id));

CREATE TABLE Company (
  id          varchar(10) NOT NULL, 
  [name]        nvarchar(255) NOT NULL, 
  [Description] nvarchar(4000) NOT NULL, 
  sdt         varchar(11) unique NOT NULL, 
  email       varchar(255) unique NOT NULL, 
  [address]      varchar(255) NOT NULL, 
  CONSTRAINT PK_ServiceProvider PRIMARY KEY (id));

CREATE TABLE ServiceCategory (
  Id          varchar(10) NOT NULL, 
  [Name]        nvarchar(255) NOT NULL, 
  [Detail] varchar(4000) NOT NULL, 
  CONSTRAINT PK_ServiceCategory PRIMARY KEY (Id));

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
  [status]         int NOT NULL,
  username varchar(255) not null,
  [password] varchar(255) NOT NULL,
  roleId varchar(10) NOT NULL CONSTRAINT FK_Staff_Role REFERENCES [Role](Id),
  CONSTRAINT PK_Staff PRIMARY KEY (Id));

CREATE TABLE StaffContract(
  [sId] varchar(10) NOT NULL CONSTRAINT FK_StaffContract_Staff FOREIGN KEY ([sId]) REFERENCES Staff (id), 
  [cId] varchar(10) NOT NULL CONSTRAINT FK_StaffContract_Company FOREIGN KEY (cId) REFERENCES Company (id),
  Startdate      date NOT NULL, 
  Enddate        date,
  CONSTRAINT PK_StaffContract PRIMARY KEY([sId],cId)
);

CREATE TABLE Apartment (
  Id     varchar(10) NOT NULL, 
  [Square] int NOT NULL, 
  NoPerson  int NOT NULL, 
  [floor]  int NOT NULL, 
  information nvarchar(4000),
  rId varchar(10) NOT NULL CONSTRAINT FK_Apartment_Resident REFERENCES Resident(Id),
  [status] int NOT NULL, 
  CONSTRAINT PK_Apartment PRIMARY KEY (Id));

CREATE TABLE RenderAparmentOwner (
	id varchar(10) NOT NULL,
	rId varchar(10) NOT NULL CONSTRAINT FK_RenderAparmentOwner_Resident REFERENCES Resident(Id),
	aId varchar(10) NOT NULL CONSTRAINT FK_RenderAparmentOwner_Aparment REFERENCES Apartment(Id), 
	Startdate      date NOT NULL, 
	Enddate        date,
	[status] int NOT NULL,
	CONSTRAINT PK_RenderAparmentOwner PRIMARY KEY (Id,rid,aid)
);

CREATE TABLE ResidentAparmentOwner (
	id varchar(10) NOT NULL,
	rId varchar(10) NOT NULL CONSTRAINT FK_ResidentAparmentOwner_Resident REFERENCES Resident(Id),
	aId varchar(10) NOT NULL CONSTRAINT FK_ResidentAparmentOwner_Aparment REFERENCES Apartment(Id),
	[status] int NOT NULL,
	CONSTRAINT PK_ResidentAparmentOwner PRIMARY KEY (Id,rid,aid)
);

CREATE TABLE [Service] (
  Id          varchar(10) NOT NULL, 
  [Name]      nvarchar(255) NOT NULL, 
  cId         varchar(10) NOT NULL CONSTRAINT FK_Service_ServiceCategory FOREIGN KEY (cId) REFERENCES ServiceCategory (Id), 
  UnitPrice   int NOT NULL,  
  [Status]      varchar(20) NOT NULL, 
  CONSTRAINT PK_Service PRIMARY KEY (Id));

CREATE TABLE Invoice (
  id          varchar(10) NOT NULL, 
  total       int NOT NULL, 
  [date]      date NOT NULL, 
  [status]      varchar(10) NOT NULL, 
  [description] nvarchar(4000) NOT NULL, 
  rId         varchar(10) NOT NULL CONSTRAINT FK_Invoice_Resident FOREIGN KEY (rId) REFERENCES Resident (Id), 
  CONSTRAINT PK_Invoice PRIMARY KEY (id));

CREATE TABLE TypeRequest (
  Id       varchar(10) NOT NULL , 
  [Name] nvarchar(255) NOT NULL, 
  Detail  nvarchar(4000) NOT NULL, 
  CONSTRAINT PK_TypeRequest PRIMARY KEY (Id));


CREATE TABLE Request (
  Id varchar(10) NOT NULL,
  rId         varchar(10) NOT NULL CONSTRAINT FK_Request_Resident FOREIGN KEY (rId) REFERENCES Resident (Id), 
  [sId]         varchar(10) NOT NULL CONSTRAINT FK_Request_Staff FOREIGN KEY ([sId]) REFERENCES Staff (Id),
  Detail varchar(4000) NOT NULL,  
  Response    nvarchar(255) NOT NULL, 
  [Status]      varchar(255) NOT NULL, 
  tId         varchar(10) NOT NULL CONSTRAINT FK_Request_TypeRequest FOREIGN KEY (tId) REFERENCES TypeRequest (Id), 
  CONSTRAINT PK_Request PRIMARY KEY (Id)
  );

  CREATE TABLE Feedback (
  Id    varchar(10) NOT NULL , 
  Detail varchar(4000) NOT NULL, 
  [Date] date NOT NULL, 
  [rId] varchar(10) NOT NULL CONSTRAINT FK_Feedback_Resident FOREIGN KEY (rId) REFERENCES Resident (Id), 
  tId         varchar(10) NOT NULL CONSTRAINT FK_Feedback_TypeRequest FOREIGN KEY (tId) REFERENCES TypeRequest (Id), 
  CONSTRAINT PK_Feedback PRIMARY KEY (Id));

CREATE TABLE Expenditure (
  Id           varchar(10) NOT NULL, 
  [Detail]         nvarchar(4000) NOT NULL, 
  [Provide]  nvarchar(255) NOT NULL, 
  Price        int NOT NULL, 
  [Date]       date NOT NULL, 
  [Status]       int NOT NULL,
  [sId] varchar(10) NOT NULL CONSTRAINT FK_Expenditure_Staff FOREIGN KEY ([sId]) REFERENCES Staff (Id),
  CONSTRAINT PK_Expenditure PRIMARY KEY (Id));

  CREATE TABLE MonthlyInvoice (
  [sid] varchar(10) NOT NULL CONSTRAINT FK_MonthlyInvoice_Service FOREIGN KEY ([sid]) REFERENCES [Service] (id), 
  [rId] varchar(10) NOT NULL CONSTRAINT FK_MonthlyInvoice_Resident FOREIGN KEY ([rId]) REFERENCES Resident (Id), 
  quantity  int NOT NULL,  
  CONSTRAINT PK_MonthlyInvoice PRIMARY KEY ([sid], [rId]));


CREATE TABLE InvoiceDetail (
  [rId] varchar(10) NOT NULL , 
  [sId] varchar(10) NOT NULL , 
  [iId] varchar(10) NOT NULL CONSTRAINT FK_InvoiceDetail_Invoice FOREIGN KEY ([iId]) REFERENCES Invoice (Id), 
  [date]    date NOT NULL, 
  CONSTRAINT PK_InvoiceDetail PRIMARY KEY ([rId],[sId],[iId]),
  CONSTRAINT FK_InvoiceDetail_MonthlyInvoice FOREIGN KEY ([sId], [rId])  REFERENCES MonthlyInvoice ([sId], [rId])
  );

  CREATE TABLE News (
  [Id] varchar(10) NOT NULL primary key , 
  [Name] nvarchar(255) NOT NULL , 
  [Discription] nvarchar(4000) NOT NULL,
  [sId] varchar(10) NOT NULL CONSTRAINT FK_News_Staff FOREIGN KEY ([sId]) REFERENCES Staff (Id),
  );

