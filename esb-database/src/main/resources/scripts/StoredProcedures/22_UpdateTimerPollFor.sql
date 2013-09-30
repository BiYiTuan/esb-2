DROP procedure if exists UpdateTimerPollFor ; $$
CREATE PROCEDURE UpdateTimerPollFor(lastDateTime VARCHAR(50), systemName VARCHAR(50), systemType VARCHAR(50))
BEGIN
UPDATE TimerPolls SET LastDateTime = lastDateTime WHERE Name = systemName  AND Type = systemType;
END 

$$