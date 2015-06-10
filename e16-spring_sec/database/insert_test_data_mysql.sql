-- MUISTA! console encoding latin1

INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	

INSERT INTO
	webuser2
VALUES
	(1,'matti','1b320d1d4fca16462b0052e2b465c56d1111f6153670c73409e1d0b7b1f7867ff97fa12c1d465f35',1,'Matti','Meikkis'),
	(2,'aada','7fc74013565cfcf10dd379f964215c866627cdfcf2606ade05323d1273456f6915c2d73cde88e24b',1,'Aada','Admini');
	
	
INSERT INTO
	webuser2_authority
VALUES
	(1,1,1),
	(2,2,1),
	(3,2,2);