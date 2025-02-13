go
use apartment_management
go
Alter table Apartment
drop constraint  [FK_Apartment_Resident]
Alter table Apartment
drop column rId


insert into Floor(floor,Square,usagetype,note)
values(1,500,'Ground Floor','Used for the lobby, security room, and commercial spaces (e.g., shops, mini-markets, cafés)'),
(2,480,'Commercial Floors','Used for shopping centers, restaurants, gyms, and other amenities'),
(3,480,'Commercial Floors','Used for shopping centers, restaurants, gyms, and other amenities'),
(4,480,'Commercial Floors','Used for shopping centers, restaurants, gyms, and other amenities'),
(5,460,'Commercial Floors','Used for shopping centers, restaurants, gyms, and other amenities'),
(6,440,'Mezzanine Floor','Used for offices, management rooms, or additional commercial space'),
(7,440,'Mezzanine Floor','used for offices, management rooms, or additional commercial space'),
(8,460,'Mezzanine Floor','used for offices, management rooms, or additional commercial space'),
(9,460,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(10,440,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(11,440,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(12,460,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(13,460,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(14,440,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(15,440,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels'),
(16,440,'Residential Floors','The main floors where residents live, Includes various apartment types such as standard apartments, duplexes, penthouses, and officetels');

insert into RoomType (Id,Name,maxperson,Square,bedroom,livingroom,bathroom,balcony)
values('1','Standard Apartment',6,40,2,1,1,1),
('2','Luxury Apartment',6,60,2,2,2,2),
('3','Shophouse',4,100,2,0,1,0),
('4','Office',99,100,0,1,2,2)

insert into Apartment(Id,NoPerson,[floor],information,rtId,status)
values('A001',4,10,'Resident Room','1',1),
('A002',4,10,'Resident Apartment','1',1),
('A003',5,10,'Resident Apartment','1',1),
('A004',6,13,'Resident Apartment','1',1),
('A005',6,12,'Resident Apartment','1',1),
('A006',4,11,'Resident Apartment','1',1),
('A007',5,11,'Resident Apartment','1',1),
('A008',3,14,'Resident Apartment','2',1),
('A009',2,14,'Resident Apartment','2',1),
('A010',4,15,'Resident Apartment','2',1),
('A011',1,1,'Guard Room','1',1),
('A012',2,1,'Shopping Apartment ','3',1),
('A013',10,2,'Supper Market','3',1),
('A014',6,3,'Electrical Market','3',1),
('A015',8,6,'Enviroment Company','4',1),
('A016',7,7,'Service Company','4',1),
('A017',8,4,'Fashion Market','3',1),
('A018',6,8,'Ba vi Company','4',1)

insert into AparmentOwner(id,rId,aId,Startdate,status)
values('1','P101','A001','2020-09-22',1),
('2','P102','A002','2020-09-21',1),
('3','P104','A004','2021-09-25',1),
('4','P105','A009','2021-09-26',1),
('5','P103','A010','2020-09-30',1),
('6','P110','A011','2022-07-22',1),
('8','P112','A012','2024-09-22',1),
('9','P113','A013','2023-12-22',1),
('10','P102','A008','2025-09-20',1),
('13','P107','A007','2021-06-12',1),
('14','P109','A006','2023-07-20',1),
('15','P108','A014','2020-05-22',1),
('16','P101','A018','2021-10-12',1),
('17','P101','A016','2021-06-24',1),
('18','P101','A017','2020-02-28',1)

insert into LivingAparment(id,rId,aId,Startdate,status)
values('1','P101','A001','2020-09-22',1),
('2','P102','A002','2020-09-21',1),
('3','P104','A004','2021-09-25',1),
('4','P105','A009','2021-09-26',1),
('5','P103','A010','2020-09-30',1),
('7','P102','A008','2025-09-20',1),
('8','P107','A007','2021-06-12',1),
('9','P109','A006','2023-07-20',1)

