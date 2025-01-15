CREATE TABLE tokenForgetPassword (
    id int IDENTITY(1,1) PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    expiryTime datetime NOT NULL,
	isUsed bit NOT NULL,
	pId varchar(10) NOT NULL,
)