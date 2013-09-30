DROP procedure if exists CreateAdditionalFor ; $$

CREATE PROCEDURE CreateAdditionalFor(timerPollsId INT, systemName VARCHAR(50), additionalValue VARCHAR(50), OUT outId INT)
BEGIN
INSERT INTO TimerPollsAdditional (TimerPollsId, Name, AdditionalValue) VALUES (timerPollsId , systemName, additionalValue);
SET outId = LAST_INSERT_ID();
END 
$$