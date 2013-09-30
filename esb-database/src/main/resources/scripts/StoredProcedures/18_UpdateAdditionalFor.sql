DROP procedure if exists UpdateAdditionalFor ; 
$$
CREATE PROCEDURE UpdateAdditionalFor(additionalValue VARCHAR(50), timerPollsId INT, systemName VARCHAR(50))
BEGIN
UPDATE TimerPollsAdditional SET AdditionalValue = additionalValue WHERE TimerPollsId = timerPollsId AND Name = systemName;
END 
$$