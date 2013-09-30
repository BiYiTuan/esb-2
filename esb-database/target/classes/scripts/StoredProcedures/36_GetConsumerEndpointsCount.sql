DROP procedure if exists GetConsumerEndpointsCount; $$
CREATE PROCEDURE GetConsumerEndpointsCount(IN routeName VARCHAR(50))
BEGIN
SELECT cc.NumberOfConsumers FROM ConsumerCount cc WHERE cc.Route = routeName;
END 
$$