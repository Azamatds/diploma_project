-- select * from ontology_table_final where "Data_property_name" = 'university';

CREATE TEMPORARY TABLE temp_count AS SELECT COUNT(*) AS count FROM ontology_table_final;

SELECT count FROM temp_count;

CREATE SEQUENCE my_seq START WITH 495;



