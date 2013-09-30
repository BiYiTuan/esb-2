DROP procedure if exists GetAdditionalFor ; 
$$
CREATE PROCEDURE GetAdditionalFor(timerPollsId INT)
BEGIN
SELECT tpa.AdditionalValue FROM TimerPollsAdditional tpa WHERE tpa.TimerPollsId = timerPollsId;
END 
$$