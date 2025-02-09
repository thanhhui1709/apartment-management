alter table Feedback
alter column detail nvarchar(4000) not null
alter table Floor
alter column usagetype nvarchar(255) not null
alter table Floor
alter column note nvarchar(4000) null 
alter table News
alter column category nvarchar(255) null
alter table Request
alter column detail nvarchar(4000) not null
alter table [Role]
alter column [Name] nvarchar(255) not null
alter table [Role]
alter column [Description] nvarchar(4000) not null
alter table ServiceCategory
alter column Detail nvarchar(4000) not null
alter table Staff
alter column Education nvarchar(255) not null

alter table Resident
add [image] nvarchar(255)
alter table Staff
add [image] nvarchar(255)

update Resident set image='images/avatar/kuru.png' where id = 'P101'
update Resident set image='images/avatar/anh.jpg' where id <> 'P101'
update Staff set image='images/avatar/thaybach.png' where id = 'S1002'
update Staff set image='images/avatar/anh.jpg' where id <> 'S1002'