CREATE TABLE authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE webuser2 (
  id integer NOT NULL auto_increment PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  firstname varchar(255) default NULL,
  lastname varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE webuser2_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  webuser2_id integer NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (webuser2_id) REFERENCES webuser2(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;