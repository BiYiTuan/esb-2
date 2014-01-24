DROP procedure if exists CreateTimerPollFor ; 
\\
CREATE PROCEDURE CreateTimerPollFor(systemType VARCHAR(50), systemName VARCHAR(50), lastDateTime VARCHAR(50), OUT outId INT)
BEGIN
INSERT INTO TimerPolls (Type, Name, LastDateTime) VALUES (systemType, systemName, lastDateTime);
SET outId = LAST_INSERT_ID();
END 
\\