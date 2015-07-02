--------------------------------------------------------
--  File created - Thursday-July-02-2015
--------------------------------------------------------
DROP TABLE "JARSPEM"."ACCOUNT_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."DATA_LOOKUPS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."DESIGNATION_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."PROJECT_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."RESOURCE_ALLOCATION_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."RESOURCE_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."SPRINT_DETAILS" CASCADE CONSTRAINTS;
DROP TABLE "JARSPEM"."SPRINT_TASK_DETAILS" CASCADE CONSTRAINTS;
--------------------------------------------------------
--  DDL for Table ACCOUNT_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."ACCOUNT_DETAILS"
  (
    "AID"        NUMBER(10,0),
    "ACC_CODE"   VARCHAR2(10),
    "ACC_NAME"   VARCHAR2(10),
    "START_DATE" DATE,
    "END_DATE"   DATE,
    "STATUS"     VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table DATA_LOOKUPS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."DATA_LOOKUPS"
  (
    "LOOKUP_KEY" VARCHAR2(10),
    "DATA_CODE"  VARCHAR2(10),
    "DATA_NAME"  VARCHAR2(1000),
    "DATA_VALUE" VARCHAR2(1000),
    "STATUS"     VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table DESIGNATION_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."DESIGNATION_DETAILS"
  (
    "DESIG_ID"     NUMBER(10,0),
    "DESIG_CODE"   VARCHAR2(10),
    "DESIG_NAME"   VARCHAR2(10),
    "TIER_CODE"    VARCHAR2(10),
    "COST_PR_PM"   NUMBER(10,2),
    "COST_TO_CUST" NUMBER(10,2),
    "STATUS"       VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table PROJECT_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."PROJECT_DETAILS"
  (
    "PID"        NUMBER(10,0),
    "AID"        NUMBER(10,0),
    "PROJ_CODE"  VARCHAR2(10),
    "PROJ_NAME"  VARCHAR2(10),
    "PROJ_TYPE"  VARCHAR2(10),
    "START_DATE" DATE,
    "END_DATE"   DATE,
    "STATUS"     VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table RESOURCE_ALLOCATION_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."RESOURCE_ALLOCATION_DETAILS"
  (
    "RID"        NUMBER(10,0),
    "TASK_ID"    NUMBER(10,0),
    "ALLOC_PERC" NUMBER(10,2),
    "START_DATE" DATE,
    "END_DATE"   DATE,
    "STATUS"     VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table RESOURCE_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."RESOURCE_DETAILS"
  (
    "RID"           NUMBER(10,0),
    "RESOURCE_CODE" VARCHAR2(10),
    "RESOURCE_NAME" VARCHAR2(10),
    "DESIG_ID"      NUMBER(10,0),
    "ALLOC_PERC"    NUMBER(10,2),
    "RESOURCE_TYPE" VARCHAR2(10),
    "START_DATE"    DATE,
    "END_DATE"      DATE,
    "STATUS"        VARCHAR2(1)
  ) ;
--------------------------------------------------------
--  DDL for Table RESOURCE_SKILL_MAPPING
--------------------------------------------------------
CREATE TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING"
  (
    "RID"                NUMBER(10,0),
    "SKILL_CODE"         VARCHAR2(10),
    "SKILL_LEVEL"        NUMBER(5,2),
    "PRODUCTIVITY_LEVEL" NUMBER(5,2)
  ) ;
--------------------------------------------------------
--  DDL for Table SPRINT_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."SPRINT_DETAILS"
  (
    "SPRINT_ID"       NUMBER(10,0),
    "SPRINT_CODE"     VARCHAR2(10),
    "SPRINT_NAME"     VARCHAR2(10),
    "SCRUM_MASTER"    NUMBER(10,0),
    "PRODUCT_MANAGER" NUMBER(10,0),
    "START_DATE"      DATE,
    "END_DATE"        DATE,
    "STATUS"          VARCHAR2(1),
    "PROJ_ID"         NUMBER(10,0)
  ) ;
--------------------------------------------------------
--  DDL for Table SPRINT_TASK_DETAILS
--------------------------------------------------------
CREATE TABLE "JARSPEM"."SPRINT_TASK_DETAILS"
  (
    "SPRINT_ID"        NUMBER(10,0),
    "TASK_ID"          NUMBER(10,0),
    "TASK_CODE"        VARCHAR2(10),
    "TASK_NAME"        VARCHAR2(10),
    "FUNCTION_POINTS"  NUMBER(10,0),
    "COMPLEXITY_LEVEL" VARCHAR2(10),
    "RELEASE_DATE"     DATE,
    "START_DATE"       DATE,
    "END_DATE"         DATE,
    "STATUS"           VARCHAR2(1)
  ) ;
REM INSERTING into JARSPEM.ACCOUNT_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.DATA_LOOKUPS
SET DEFINE OFF;
REM INSERTING into JARSPEM.DESIGNATION_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.PROJECT_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.RESOURCE_ALLOCATION_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.RESOURCE_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.RESOURCE_SKILL_MAPPING
SET DEFINE OFF;
REM INSERTING into JARSPEM.SPRINT_DETAILS
SET DEFINE OFF;
REM INSERTING into JARSPEM.SPRINT_TASK_DETAILS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SPRINT_TASK_DETAILS_UK1
--------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."SPRINT_TASK_DETAILS_UK1" ON "JARSPEM"."SPRINT_TASK_DETAILS"
  (
    "SPRINT_ID", "TASK_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index SPRINT_TASK_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."SPRINT_TASK_DETAILS_PK" ON "JARSPEM"."SPRINT_TASK_DETAILS"
  (
    "TASK_ID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index RESOURCE_DETAILS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."RESOURCE_DETAILS_UK1" ON "JARSPEM"."RESOURCE_DETAILS"
  (
    "RESOURCE_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index SPRINT_DETAILS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."SPRINT_DETAILS_UK1" ON "JARSPEM"."SPRINT_DETAILS"
  (
    "SPRINT_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index SPRINT_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."SPRINT_DETAILS_PK" ON "JARSPEM"."SPRINT_DETAILS"
  (
    "SPRINT_ID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index RESOURCE_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."RESOURCE_DETAILS_PK" ON "JARSPEM"."RESOURCE_DETAILS"
  (
    "RID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index ACCOUNT_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."ACCOUNT_DETAILS_PK" ON "JARSPEM"."ACCOUNT_DETAILS"
  (
    "AID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index ACCOUNT_DETAILS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."ACCOUNT_DETAILS_UK1" ON "JARSPEM"."ACCOUNT_DETAILS"
  (
    "ACC_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index RESOURCE_SKILL_MAPPING_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."RESOURCE_SKILL_MAPPING_PK" ON "JARSPEM"."RESOURCE_SKILL_MAPPING"
  (
    "RID", "SKILL_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index DATA_LOOKUPS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."DATA_LOOKUPS_PK" ON "JARSPEM"."DATA_LOOKUPS"
  (
    "LOOKUP_KEY", "DATA_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index DESIGNATION_DETAILS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."DESIGNATION_DETAILS_UK1" ON "JARSPEM"."DESIGNATION_DETAILS"
  (
    "DESIG_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index PROJECT_DETAILS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."PROJECT_DETAILS_UK1" ON "JARSPEM"."PROJECT_DETAILS"
  (
    "PROJ_CODE"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index DESIGNATION_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."DESIGNATION_DETAILS_PK" ON "JARSPEM"."DESIGNATION_DETAILS"
  (
    "DESIG_ID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index PROJECT_DETAILS_PK
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."PROJECT_DETAILS_PK" ON "JARSPEM"."PROJECT_DETAILS"
  (
    "PID"
  )
  ;
  --------------------------------------------------------
  --  DDL for Index DATA_LOOKUPS_UK1
  --------------------------------------------------------
CREATE UNIQUE INDEX "JARSPEM"."DATA_LOOKUPS_UK1" ON "JARSPEM"."DATA_LOOKUPS"
  (
    "DATA_CODE", "DATA_NAME"
  )
  ;
  --------------------------------------------------------
  --  Constraints for Table RESOURCE_SKILL_MAPPING
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING" ADD CONSTRAINT "RESOURCE_SKILL_MAPPING_PK" PRIMARY KEY ("RID", "SKILL_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING" MODIFY ("RID" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING" MODIFY ("SKILL_CODE" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table PROJECT_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" ADD CONSTRAINT "PROJECT_DETAILS_PK" PRIMARY KEY ("PID") ENABLE;
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" ADD CONSTRAINT "PROJECT_DETAILS_UK1" UNIQUE ("PROJ_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("PID" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("AID" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("PROJ_CODE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("PROJ_NAME" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("PROJ_TYPE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" MODIFY ("STATUS" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table SPRINT_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" ADD CONSTRAINT "SPRINT_DETAILS_PK" PRIMARY KEY ("SPRINT_ID") ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" ADD CONSTRAINT "SPRINT_DETAILS_UK1" UNIQUE ("SPRINT_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" MODIFY ("SPRINT_ID" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table SPRINT_TASK_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."SPRINT_TASK_DETAILS" ADD CONSTRAINT "SPRINT_TASK_DETAILS_PK" PRIMARY KEY ("TASK_ID") ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_TASK_DETAILS" ADD CONSTRAINT "SPRINT_TASK_DETAILS_UK1" UNIQUE ("SPRINT_ID", "TASK_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_TASK_DETAILS" MODIFY ("TASK_ID" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table DATA_LOOKUPS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" ADD CONSTRAINT "DATA_LOOKUPS_PK" PRIMARY KEY ("LOOKUP_KEY", "DATA_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" ADD CONSTRAINT "DATA_LOOKUPS_UK1" UNIQUE ("DATA_CODE", "DATA_NAME") ENABLE;
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" MODIFY ("LOOKUP_KEY" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" MODIFY ("DATA_CODE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" MODIFY ("DATA_NAME" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DATA_LOOKUPS" MODIFY ("STATUS" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table DESIGNATION_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" ADD CONSTRAINT "DESIGNATION_DETAILS_PK" PRIMARY KEY ("DESIG_ID") ENABLE;
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" ADD CONSTRAINT "DESIGNATION_DETAILS_UK1" UNIQUE ("DESIG_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("DESIG_ID" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("DESIG_CODE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("DESIG_NAME" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("TIER_CODE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("COST_PR_PM" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."DESIGNATION_DETAILS" MODIFY ("STATUS" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table ACCOUNT_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" ADD CONSTRAINT "ACCOUNT_DETAILS_PK" PRIMARY KEY ("AID") ENABLE;
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" ADD CONSTRAINT "ACCOUNT_DETAILS_UK1" UNIQUE ("ACC_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" MODIFY ("AID" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" MODIFY ("ACC_CODE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" MODIFY ("ACC_NAME" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "JARSPEM"."ACCOUNT_DETAILS" MODIFY ("STATUS" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Constraints for Table RESOURCE_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."RESOURCE_DETAILS" ADD CONSTRAINT "RESOURCE_DETAILS_PK" PRIMARY KEY ("RID") ENABLE;
  ALTER TABLE "JARSPEM"."RESOURCE_DETAILS" ADD CONSTRAINT "RESOURCE_DETAILS_UK1" UNIQUE ("RESOURCE_CODE") ENABLE;
  ALTER TABLE "JARSPEM"."RESOURCE_DETAILS" MODIFY ("RID" NOT NULL ENABLE);
  --------------------------------------------------------
  --  Ref Constraints for Table PROJECT_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."PROJECT_DETAILS" ADD CONSTRAINT "PROJECT_DETAILS_FK1" FOREIGN KEY ("AID") REFERENCES "JARSPEM"."ACCOUNT_DETAILS" ("AID") ON
  DELETE CASCADE ENABLE;
  --------------------------------------------------------
  --  Ref Constraints for Table RESOURCE_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."RESOURCE_DETAILS" ADD CONSTRAINT "RESOURCE_DETAILS_FK1" FOREIGN KEY ("DESIG_ID") REFERENCES "JARSPEM"."DESIGNATION_DETAILS" ("DESIG_ID") ENABLE;
  --------------------------------------------------------
  --  Ref Constraints for Table RESOURCE_SKILL_MAPPING
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."RESOURCE_SKILL_MAPPING" ADD CONSTRAINT "RESOURCE_SKILL_MAPPING_FK1" FOREIGN KEY ("RID") REFERENCES "JARSPEM"."RESOURCE_DETAILS" ("RID") ON
  DELETE CASCADE ENABLE;
  --------------------------------------------------------
  --  Ref Constraints for Table SPRINT_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" ADD CONSTRAINT "SPRINT_DETAILS_FK1" FOREIGN KEY ("PROJ_ID") REFERENCES "JARSPEM"."PROJECT_DETAILS" ("PID") ON
  DELETE CASCADE ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" ADD CONSTRAINT "SPRINT_DETAILS_FK2" FOREIGN KEY ("SCRUM_MASTER") REFERENCES "JARSPEM"."RESOURCE_DETAILS" ("RID") ENABLE;
  ALTER TABLE "JARSPEM"."SPRINT_DETAILS" ADD CONSTRAINT "SPRINT_DETAILS_FK3" FOREIGN KEY ("PRODUCT_MANAGER") REFERENCES "JARSPEM"."RESOURCE_DETAILS" ("RID") ENABLE;
  --------------------------------------------------------
  --  Ref Constraints for Table SPRINT_TASK_DETAILS
  --------------------------------------------------------
  ALTER TABLE "JARSPEM"."SPRINT_TASK_DETAILS" ADD CONSTRAINT "SPRINT_TASK_DETAILS_FK1" FOREIGN KEY ("SPRINT_ID") REFERENCES "JARSPEM"."SPRINT_DETAILS" ("SPRINT_ID") ON
  DELETE CASCADE ENABLE;
