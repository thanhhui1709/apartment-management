INSERT INTO Role (Id, Name, Description)
VALUES
(1, 'Resident', 'Role for residents');
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
('P109', 'Jack Le', '1984-06-06', 'jack@example.com', '0011223344', '707 Redwood Place', '001122334', 'jack', 'password10', 1);


