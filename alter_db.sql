Alter table InvoiceDetail
DROP CONSTRAINT [FK__InvoiceDeta__iId__6C190EBB];
Alter table InvoiceDetail
DROP CONSTRAINT [FK__InvoiceDetail__6D0D32F4];
Alter table InvoiceDetail
DROP CONSTRAINT [PK__InvoiceD__B05036BD6594406F];
Alter table MonthlyInvoice
DROP CONSTRAINT [FK__MonthlyInvo__aId__693CA210];
Alter table MonthlyInvoice
DROP CONSTRAINT [PK__MonthlyI__A03AC596DDE2BC94];
Alter table InvoiceDetail
Drop COLUMN [aId];
Alter table MonthlyInvoice
Drop COLUMN [aId];
Alter table MonthlyInvoice
ADD [rId] varchar(10) NOT NULL FOREIGN KEY ([rId]) REFERENCES Resident (Id);
Alter table InvoiceDetail
ADD [rId] varchar(10) NOT NULL ;
Alter table MonthlyInvoice
add primary key([sid],[rid]);
Alter table InvoiceDetail
add primary key([sid],[rid],[iId]);
Alter table InvoiceDetail
add  FOREIGN KEY ([sId], [rId]) REFERENCES MonthlyInvoice ([sId], [rId]);
CREATE TABLE News (
  [Id] varchar(10) NOT NULL primary key , 
  [Name] nvarchar(255) NOT NULL , 
  [Discription] nvarchar(255) NOT NULL,
  );
