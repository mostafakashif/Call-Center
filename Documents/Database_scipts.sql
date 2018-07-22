--------------------------------------------------------
--  File created - Sunday-July-22-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence COMPLAINT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "COMPLAINT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 201 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table COMPLAINT
--------------------------------------------------------

  CREATE TABLE "COMPLAINT" 
   (	"COMPLAINT_ID" NUMBER, 
	"CUSTOMER_ID" NUMBER, 
	"SERVICE_ID" NUMBER, 
	"ENTRY_DATE" DATE DEFAULT SYSDATE, 
	"DESCRIPTION" VARCHAR2(200 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table CUSTOMERS
--------------------------------------------------------

  CREATE TABLE "CUSTOMERS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(60 BYTE), 
	"SEGMENT" NUMBER, 
	"BALANCE" NUMBER DEFAULT 0
   )  ;
--------------------------------------------------------
--  DDL for Table CUSTOMERS_SERVICES
--------------------------------------------------------

  CREATE TABLE "CUSTOMERS_SERVICES" 
   (	"CUSTOMER_ID" NUMBER, 
	"SERVICE_ID" NUMBER, 
	"USAGE" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table SEGMENTS_LK
--------------------------------------------------------

  CREATE TABLE "SEGMENTS_LK" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(15 BYTE)
   )  ;
--------------------------------------------------------
--  DDL for Table SERVICES
--------------------------------------------------------

  CREATE TABLE "SERVICES" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(60 BYTE), 
	"COST" NUMBER
   ) ;
REM INSERTING into COMPLAINT
SET DEFINE OFF;
REM INSERTING into CUSTOMERS
SET DEFINE OFF;
Insert into CUSTOMERS (ID,NAME,SEGMENT,BALANCE) values (1,'Customer_1',1,445);
Insert into CUSTOMERS (ID,NAME,SEGMENT,BALANCE) values (2,'Customer_2',2,40);
Insert into CUSTOMERS (ID,NAME,SEGMENT,BALANCE) values (3,'Customer_3',3,0);
REM INSERTING into CUSTOMERS_SERVICES
SET DEFINE OFF;
Insert into CUSTOMERS_SERVICES (CUSTOMER_ID,SERVICE_ID,USAGE) values (1,1,2);
Insert into CUSTOMERS_SERVICES (CUSTOMER_ID,SERVICE_ID,USAGE) values (1,2,5);
REM INSERTING into SEGMENTS_LK
SET DEFINE OFF;
Insert into SEGMENTS_LK (ID,NAME) values (1,'Normal');
Insert into SEGMENTS_LK (ID,NAME) values (2,'Premium');
Insert into SEGMENTS_LK (ID,NAME) values (3,'Special');
REM INSERTING into SERVICES
SET DEFINE OFF;
Insert into SERVICES (ID,NAME,COST) values (1,'Service_1',50);
Insert into SERVICES (ID,NAME,COST) values (2,'Service_2',100);
--------------------------------------------------------
--  DDL for Index CUSTOMERS_COMPLAINTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUSTOMERS_COMPLAINTS_PK" ON "COMPLAINT" ("COMPLAINT_ID") ;
--------------------------------------------------------
--  DDL for Index CUSTOMERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUSTOMERS_PK" ON "CUSTOMERS" ("ID") ;
--------------------------------------------------------
--  DDL for Index CUSTOMERS_SERVICES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUSTOMERS_SERVICES_PK" ON "CUSTOMERS_SERVICES" ("CUSTOMER_ID", "SERVICE_ID")  ;
--------------------------------------------------------
--  DDL for Index SEGMENTS_LK_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SEGMENTS_LK_PK" ON "SEGMENTS_LK" ("ID") ;
--------------------------------------------------------
--  DDL for Index SERVICES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SERVICES_PK" ON "SERVICES" ("ID")  ;
--------------------------------------------------------
--  Constraints for Table COMPLAINT
--------------------------------------------------------

  ALTER TABLE "COMPLAINT" MODIFY ("COMPLAINT_ID" NOT NULL ENABLE);
  ALTER TABLE "COMPLAINT" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "COMPLAINT" MODIFY ("SERVICE_ID" NOT NULL ENABLE);
  ALTER TABLE "COMPLAINT" MODIFY ("ENTRY_DATE" NOT NULL ENABLE);
  ALTER TABLE "COMPLAINT" MODIFY ("DESCRIPTION" NOT NULL ENABLE);
  ALTER TABLE "COMPLAINT" ADD CONSTRAINT "CUSTOMERS_COMPLAINTS_PK" PRIMARY KEY ("COMPLAINT_ID");
--------------------------------------------------------
--  Constraints for Table CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "CUSTOMERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMERS" MODIFY ("SEGMENT" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMERS" ADD CONSTRAINT "CUSTOMERS_PK" PRIMARY KEY ("ID");
  ALTER TABLE "CUSTOMERS" MODIFY ("BALANCE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CUSTOMERS_SERVICES
--------------------------------------------------------

  ALTER TABLE "CUSTOMERS_SERVICES" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMERS_SERVICES" MODIFY ("SERVICE_ID" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMERS_SERVICES" ADD CONSTRAINT "CUSTOMERS_SERVICES_PK" PRIMARY KEY ("CUSTOMER_ID", "SERVICE_ID");
  ALTER TABLE "CUSTOMERS_SERVICES" MODIFY ("USAGE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SEGMENTS_LK
--------------------------------------------------------

  ALTER TABLE "SEGMENTS_LK" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SEGMENTS_LK" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SEGMENTS_LK" ADD CONSTRAINT "SEGMENTS_LK_PK" PRIMARY KEY ("ID");
--------------------------------------------------------
--  Constraints for Table SERVICES
--------------------------------------------------------

  ALTER TABLE "SERVICES" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SERVICES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SERVICES" MODIFY ("COST" NOT NULL ENABLE);
  ALTER TABLE "SERVICES" ADD CONSTRAINT "SERVICES_PK" PRIMARY KEY ("ID");
--------------------------------------------------------
--  Ref Constraints for Table COMPLAINT
--------------------------------------------------------

  ALTER TABLE "COMPLAINT" ADD CONSTRAINT "CUSTOMERS_COMPLAINTS_FK1" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "CUSTOMERS" ("ID") ENABLE;
  ALTER TABLE "COMPLAINT" ADD CONSTRAINT "CUSTOMERS_COMPLAINTS_FK2" FOREIGN KEY ("SERVICE_ID")
	  REFERENCES "SERVICES" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CUSTOMERS
--------------------------------------------------------

  ALTER TABLE "CUSTOMERS" ADD CONSTRAINT "CUSTOMERS_FK1" FOREIGN KEY ("SEGMENT")
	  REFERENCES "SEGMENTS_LK" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CUSTOMERS_SERVICES
--------------------------------------------------------

  ALTER TABLE "CUSTOMERS_SERVICES" ADD CONSTRAINT "CUSTOMERS_SERVICES_FK1" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "CUSTOMERS" ("ID") ENABLE;
  ALTER TABLE "CUSTOMERS_SERVICES" ADD CONSTRAINT "CUSTOMERS_SERVICES_FK2" FOREIGN KEY ("SERVICE_ID")
	  REFERENCES "SERVICES" ("ID") ENABLE;
