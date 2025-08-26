-- V2: migrations to add the column 'rank' in the TB_Ninja_Registry
ALTER TABLE TB_Ninja_Registry
ADD COLUMN rank VARCHAR(255);