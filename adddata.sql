INSERT INTO Role (Id, Name, Description)
VALUES
(1, 'Resident', 'Role for residents'),
(2, 'Staff', 'Role for staff members'),
(3, 'Accountant', 'Role for accountant');
INSERT INTO Resident (Id, Name, Bod, Email, Phone, Address, CCCD, username, password, roleId) VALUES 
('P100', 'Alice Nguyen', '1990-05-14', 'alice@example.com', '1234567890', '123 Elm Street', '123456789', 'alice', 'password1', 1),
('P101', 'Bob Tran', '1985-09-22', 'bob@example.com', '0987654321', '456 Oak Avenue', '987654321', 'bob', 'password2', 1),
('P102', 'Charlie Le', '1992-11-30', 'charlie@example.com', '1122334455', '789 Pine Lane', '112233445', 'charlie', 'password3', 1),
('P103', 'David Pham', '1988-03-18', 'david@example.com', '5566778899', '101 Maple Road', '556677889', 'david', 'password4', 1),
('P104', 'Eve Hoang', '1995-12-25', 'eve@example.com', '2233445566', '202 Birch Boulevard', '223344556', 'eve', 'password5', 1),
('P105', 'Frank Vu', '1991-08-12', 'frank@example.com', '6677889900', '303 Cedar Street', '667788990', 'frank', 'password6', 1),
('P106', 'Grace Ly', '1989-07-07', 'grace@example.com', '7788990011', '404 Palm Drive', '778899001', 'grace', 'password7', 1),
('P107', 'Henry Do', '1987-02-02', 'henry@example.com', '8899001122', '505 Spruce Terrace', '889900112', 'henry', 'password8', 1),
('P108', 'Ivy Nguyen', '1993-10-10', 'ivy@example.com', '9900112233', '606 Cypress Court', '990011223', 'ivy', 'password9', 1),
('P109', 'Jack Le', '1984-06-06', 'jack@example.com', '0011223344', '707 Redwood Place', '001122334', 'jack', 'password10', 1),
('P110', 'NhatQuang', '1990-05-14', 'quangpnhe180573@gmail.com', '1234563490', '123 Elm Street', '12308456789', 'quang', '123', 1);

INSERT INTO Company (id, [name], [Description], sdt, email, [address]) VALUES 
('0', 'Ba Vi Apartmet', 'Provider of various services', '0911234567', 'bavi@example.com', '122 Service Street'),
('1', 'ABC Services', 'Provider of various services', '0901234567', 'abc@example.com', '123 Service Street');


INSERT INTO Staff (Id, Name, Bod, Email, Phone, Address, CCCD, Salary, Education, Bank,[status], Username, Password, roleId)
VALUES 
('S1002', 'Tran Thi B', '1985-03-22', 'tranthib@example.com', '0902233445', '456 Hai Ba Trung, Hanoi', '223456789012', 16000000, 'Master', 'Vietcombank - 1010101010', '1', 'userB', 'password456', 2),
('S1003', 'Le Van C', '1987-07-19', 'levanc@example.com', '0903234567', '789 Le Loi, Da Nang', '323456789012', 14000000, 'Bachelor', 'Techcombank - 2020202020', '1', 'userC', 'password789', 2),
('S1004', 'Pham Thi D', '1992-01-10', 'phamthid@example.com', '0904235678', '321 Tran Hung Dao, HCMC', '423456789012', 15000000, 'Bachelor', 'ACB - 3030303030', '1', 'userD', 'password101', 2),
('S1005', 'Nguyen Van E', '1994-11-05', 'nguyenvane@example.com', '0905236789', '123 Nguyen Hue, HCMC', '523456789012', 14500000, 'Bachelor', 'Sacombank - 4040404040', '1', 'userE', 'password202', 2),
('S1006', 'Do Thi F', '1988-09-30', 'dothif@example.com', '0906237890', '456 Le Loi, Hue', '623456789012', 15500000, 'Master', 'BIDV - 5050505050', '1', 'userF', 'password303', 2),
('S1007', 'Hoang Van G', '1983-06-25', 'hoangvang@example.com', '0907238901', '789 Hai Ba Trung, Hanoi', '723456789012', 17000000, 'PhD', 'Vietinbank - 6060606060', '1', 'userG', 'password404', 2),
('S1008', 'Vu Thi H', '1990-04-14', 'vuthih@example.com', '0908239012', '321 Tran Hung Dao, Da Nang', '823456789012', 16000000, 'Master', 'VPBank - 7070707070', '1', 'userH', 'password505', 2),
('S1009', 'Tran Van I', '1986-08-09', 'tranvani@example.com', '0909230123', '456 Nguyen Hue, Hue', '923456789012', 15000000, 'Bachelor', 'MBBank - 8080808080', '1', 'userI', 'password606', 2),
('S1010', 'Ngo Thi J', '1995-02-18', 'ngothij@example.com', '0910231234', '123 Le Loi, HCMC', '023456789012', 14000000, 'Bachelor', 'Eximbank - 9090909090', '1', 'userJ', 'password707', 2);

CREATE TABLE tokenForgetPassword (
    id int IDENTITY(1,1) PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    expiryTime datetime NOT NULL,
	isUsed bit NOT NULL,
	pId varchar(10) NOT NULL,
)


