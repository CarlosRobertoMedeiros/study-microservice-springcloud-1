CREATE USER cambio with PASSWORD 'cambio' CREATEDB;
CREATE DATABASE cambio_service
	WITH
	OWNER = cambio
	ENCODING = 'UTF-8'
	LC_COLLATE='en_US.utf8'
	LC_CTYPE='en_US.utf8'
	TABLESPACE = pg_default
	CONNECTION LIMIT = -1
	
	