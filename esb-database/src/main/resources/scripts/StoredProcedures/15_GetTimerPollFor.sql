DROP procedure if exists GetTimerPollFor; 
$$
CREATE PROCEDURE GetTimerPollFor(name VARCHAR(50), systemType VARCHAR(50))
BEGIN
SELECT Id, LastDateTime FROM TimerPolls WHERE Name = name AND Type = systemType;
END 
$$