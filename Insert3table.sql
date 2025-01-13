INSERT INTO Role (Id, Name, Description)
VALUES
(1, 'Resident', 'Role for residents'),
(2, 'Accountant', 'Role for accountants');
INSERT INTO Person (Id, Fullname, Bod, Email, Sđt, Address, CCCD)
VALUES
('P001', 'Nguyen Van A', '1990-01-01', 'nguyenvana@example.com', '0123456789', '123 Street, Hanoi', '123456789'),
('P002', 'Tran Thi B', '1995-05-10', 'tranthib@example.com', '0987654321', '456 Avenue, HCMC', '987654321'),
('P003', 'Le Van C', '1988-03-15', 'levanc@example.com', '0345678901', '789 Road, Danang', '456123789'),
('P004', 'Pham Thi D', '1993-07-22', 'phamthid@example.com', '0567890123', '101 Block, Hue', '789456123'),
('P005', 'Hoang Van E', '1990-12-30', 'hoangvane@example.com', '0765432109', '202 Village, Hanoi', '321654987'),
('P006', 'Nguyen Thi F', '1997-11-09', 'nguyenthif@example.com', '0981234567', '303 Alley, HCMC', '654789123'),
('P007', 'Tran Van G', '1991-04-18', 'tranvang@example.com', '0432109876', '404 Lane, Hanoi', '147258369'),
('P008', 'Ngo Thi H', '1995-06-06', 'ngothih@example.com', '0564321098', '505 Street, Dalat', '963852741'),
('P009', 'Bui Van I', '1989-10-02', 'buivani@example.com', '0986543210', '606 Area, Can Tho', '852963741'),
('P010', 'Pham Thi J', '1994-09-19', 'phamthij@example.com', '0657890123', '707 Village, Haiphong', '741963852');
INSERT INTO Account (username, password, pId, Role)
VALUES
('user1', 'resident123', 'P001', 1),  -- Resident
('user2', 'accountant123', 'P002', 2),  -- Accountant
('user3', 'resident123', 'P003', 1),  -- Resident
('user4', 'accountant123', 'P004', 2),  -- Accountant
('user5', 'resident123', 'P005', 1),  -- Resident
('user6', 'accountant123', 'P006', 2),  -- Accountant
('user7', 'resident123', 'P007', 1),  -- Resident
('user8', 'accountant123', 'P008', 2),  -- Accountant
('user9', 'resident123', 'P009', 1),  -- Resident
('user10', 'accountant123', 'P010', 2);  -- Accountant