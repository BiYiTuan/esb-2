DROP procedure if exists GetStockFrontends ; 
\\

CREATE PROCEDURE GetStockFrontends()
BEGIN
	SELECT Id, Name, Type, RpcUrl, DocLitUrl, Username, Password FROM FrontendConnections WHERE IsStockUpdates = 1;
END \\