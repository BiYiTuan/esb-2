DROP procedure if exists GetOrderFrontends ; 
\\
CREATE PROCEDURE GetOrderFrontends()
BEGIN
SELECT Id, Name, Type, RpcUrl, DocLitUrl, Username, Password FROM FrontendConnections WHERE IsOrderRetrieval = 1;
END 

\\