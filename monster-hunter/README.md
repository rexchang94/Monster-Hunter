# Monster-Hunter
Monster-Hunter API

Monsters-Hunter DATABASE Setup

--Create User
1. CREATE ROLE "SapphireStar" WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'md50b9e8af0de6c48b0711c1268feb506e4';

COMMENT ON ROLE "SapphireStar" IS 'The Sapphire Star''s Guidance';

--Create DATABASE
2. CREATE DATABASE monster_hunter
    WITH
    OWNER = "SapphireStar"
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE monster_hunter
    IS 'monster-hunter database';
