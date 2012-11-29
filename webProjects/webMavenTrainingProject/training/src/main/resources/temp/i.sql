SELECT
ba.ManufacturerClientID,
c.Name as `Client Name`, 
ba.Cluster,
ba.Name as `Destination Name`,
(
    SELECT 
        count(*) 
    FROM `BrandAnswersRetailerClient` AS `bba`
    WHERE bba.ManufacturerClientID = c.ID
) as `CustomCount`

FROM BrandAnswersRetailerClient AS `ba` 
LEFT JOIN Client AS `c` ON ba.ManufacturerClientID = c.ID
ORDER BY c.Name ASC
LIMIT 0, 1000;

/*  */

--------------------

SELECT
ba.ManufacturerClientID,
c.Name as `Client Name`, 
ba.Cluster,
ba.Name as `Destination Name`,
(
    SELECT 
        count(*) 
    FROM `ManufacturerClientID` AS `bba`
    WHERE bba.ManufacturerClientID = c.ID
) as `CustomCount`

FROM BrandAnswersRetailerClient AS `ba` 
LEFT JOIN Client AS `c` ON ba.ManufacturerClientID = c.ID
ORDER BY ba.Name ASC
LIMIT 0, 1000;
