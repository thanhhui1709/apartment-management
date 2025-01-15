
INSERT INTO Role (Id, Name, Description)
VALUES
(2, 'Staff', 'Role for staff members'),
(3, 'Employee', 'Role for employees');


INSERT INTO ServiceProvider (id, [name], [Description], sdt, email, [address]) VALUES 
('1', 'ABC Services', 'Provider of various services', '0901234567', 'abc@example.com', '123 Service Street');


INSERT INTO Employee (Id, Name, Bod, Email, Phone, Address, CCCD, Companyid, Startdate, Enddate, [status], username, [password], roleId) VALUES 
('E1001', 'John Doe', '1985-01-10', 'john@example.com', '0901234567', '456 Oak Avenue', '987654321', '1', '2023-01-01', NULL, 1, 'a', '123', '3'),
('E1002', 'Jane Smith', '1992-03-22', 'jane@example.com', '0902345678', '789 Pine Road', '123456789012', '1', '2023-02-01', NULL, 1, 'b', '123', '3'),
('E1003', 'Michael Brown', '1988-07-19', 'michael@example.com', '0903456789', '321 Maple Street', '234567890', '1', '2023-03-01', NULL, 1, 'c', '123', '3'),
('E1004', 'Emily Davis', '1995-11-30', 'emily@example.com', '0904567890', '654 Cedar Drive', '345678901', '1', '2023-04-01', NULL, 1, 'd', '123', '3'),
('E1005', 'David Wilson', '1980-09-15', 'david@example.com', '0905678901', '987 Birch Lane', '456789012', '1', '2023-05-01', NULL, 1, 'e', '123', '3');


INSERT INTO Staff (Id, [Name], Bod, Email, Phone, [Address], CCCD, Salary, Education, Bank, username, [password], roleId) VALUES 
('S1001', 'Nguyen Van A', '1990-05-15', 'nguyenvana@example.com', '0901234567', '123 Main Street, Hanoi', '123456789012', 15000000, 'Bachelor', '123456789', 'userA', 'password123', '1');
select * from Resident where username = 'quang'

INSERT INTO Resident (Id, Name, Bod, Email, Phone, Address, CCCD, username, password, roleId) VALUES 
('P110', 'NhatQuang', '1990-05-14', 'quangpnhe180573@gmail.com', '1234563490', '123 Elm Street', '12308456789', 'alice', 'password1', 1)\




