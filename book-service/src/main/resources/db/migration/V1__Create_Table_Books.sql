﻿CREATE TABLE TB_BOOK (
  ID int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  NM_AUTHOR VARCHAR(100),
  DT_LAUNCH_DATE timestamp NOT NULL,
  VL_PRICE numeric(65,2) NOT NULL,
  NM_TITLE VARCHAR(250),
  CONSTRAINT book_pkey PRIMARY KEY (id)
);