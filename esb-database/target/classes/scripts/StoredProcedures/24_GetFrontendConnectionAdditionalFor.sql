DROP procedure if exists GetFrontendConnectionAdditionalFor ; 
\\
CREATE PROCEDURE GetFrontendConnectionAdditionalFor(frontendConnectionId INT)
BEGIN
SELECT fca.AdditionalValue FROM FrontendConnectionsAdditional fca WHERE fca.FrontendConnectionId = frontendConnectionId;
END 
\\