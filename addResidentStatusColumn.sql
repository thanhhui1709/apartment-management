ALTER TABLE resident
ADD status BIT;

update Resident
set status = 1