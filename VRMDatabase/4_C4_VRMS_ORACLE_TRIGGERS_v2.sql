CREATE OR REPLACE TRIGGER user_dtls_trigger AFTER
    INSERT OR UPDATE ON c4_user_details
    REFERENCING
        NEW AS new
    FOR EACH ROW
DECLARE
    rowcnt NUMBER;
	productType VARCHAR2(16);
BEGIN
    SELECT
        COUNT(*)
    INTO rowcnt
    FROM
        vrms_user_details
    WHERE
        c4_user_oid = :new.c4_user_oid;
	SELECT PRODUCT_ID into productType FROM C4_COMPANY_DETAILS WHERE COMPANY_OID=:new.company_oid;
	if productType = 'VRMS' THEN
		dbms_output.put_line('This record is for VRMS User');
		IF rowcnt = 0 THEN
        INSERT INTO vrms_user_details (
            c4_user_oid,
            username,
            email,
            first_name,
            middle_name,
            last_name,
            sex,
            mobile,
            mobile2,
            phone,
            city,
            state,
            country,
            zipcode,
            address_line1,
            address_line2,
            address_line3,
            created_by,
            created_date,
            last_modified_by,
            last_modified_date,
            status,
            picture,
            role_id,
            company_oid,
            document_id
        ) VALUES (
            :new.c4_user_oid,
            :new.username,
            :new.email,
            :new.first_name,
            :new.middle_name,
            :new.last_name,
            :new.sex,
            :new.mobile,
            :new.mobile2,
            :new.phone,
            :new.city,
            :new.state,
            :new.country,
            :new.zipcode,
            :new.address_line1,
            :new.address_line2,
            :new.address_line3,
            :new.created_by,
            :new.created_date,
            :new.last_modified_by,
            :new.last_modified_date,
            :new.status,
            :new.picture,
            :new.role_id,
            :new.company_oid,
            :new.document_id
        );
    ELSE
        UPDATE vrms_user_details
        SET
            c4_user_oid = :new.c4_user_oid,
            username = :new.username,
            email = :new.email,
            first_name = :new.first_name,
            middle_name = :new.middle_name,
            last_name = :new.last_name,
            sex = :new.sex,
            mobile = :new.mobile,
            mobile2 = :new.mobile2,
            phone = :new.phone,
            city = :new.city,
            state = :new.state,
            country = :new.country,
            zipcode = :new.zipcode,
            address_line1 = :new.address_line1,
            address_line2 = :new.address_line2,
            address_line3 = :new.address_line3,
            created_by = :new.created_by,
            created_date = :new.created_date,
            last_modified_by = :new.last_modified_by,
            last_modified_date = :new.last_modified_date,
            status = :new.status,
            picture = :new.picture,
            role_id = :new.role_id,
            company_oid = :new.company_oid,
            document_id = :new.document_id
        WHERE
            c4_user_oid = :new.c4_user_oid;
    END IF;
	ELSE	
		dbms_output.put_line('This record is for CDMS User');
		SELECT
			COUNT(*)
		INTO rowcnt
		FROM
			cdms_user_details
		WHERE
			c4_user_oid = :new.c4_user_oid;
		IF rowcnt = 0 THEN
			INSERT INTO cdms_user_details (
				c4_user_oid,
				username,
				email,
				first_name,
				middle_name,
				last_name,
				sex,
				mobile,
				mobile2,
				phone,
				city,
				state,
				country,
				zipcode,
				address_line1,
				address_line2,
				address_line3,
				created_by,
				created_date,
				last_modified_by,
				last_modified_date,
				status,
				picture,
				role_id,
				company_oid,
				document_id
			) VALUES (
				:new.c4_user_oid,
				:new.username,
				:new.email,
				:new.first_name,
				:new.middle_name,
				:new.last_name,
				:new.sex,
				:new.mobile,
				:new.mobile2,
				:new.phone,
				:new.city,
				:new.state,
				:new.country,
				:new.zipcode,
				:new.address_line1,
				:new.address_line2,
				:new.address_line3,
				:new.created_by,
				:new.created_date,
				:new.last_modified_by,
				:new.last_modified_date,
				:new.status,
				:new.picture,
				:new.role_id,
				:new.company_oid,
				:new.document_id
			);
		ELSE
			UPDATE cdms_user_details
			SET
				c4_user_oid = :new.c4_user_oid,
				username = :new.username,
				email = :new.email,
				first_name = :new.first_name,
				middle_name = :new.middle_name,
				last_name = :new.last_name,
				sex = :new.sex,
				mobile = :new.mobile,
				mobile2 = :new.mobile2,
				phone = :new.phone,
				city = :new.city,
				state = :new.state,
				country = :new.country,
				zipcode = :new.zipcode,
				address_line1 = :new.address_line1,
				address_line2 = :new.address_line2,
				address_line3 = :new.address_line3,
				created_by = :new.created_by,
				created_date = :new.created_date,
				last_modified_by = :new.last_modified_by,
				last_modified_date = :new.last_modified_date,
				status = :new.status,
				picture = :new.picture,
				role_id = :new.role_id,
				company_oid = :new.company_oid,
				document_id = :new.document_id
			WHERE
				c4_user_oid = :new.c4_user_oid;
		END IF;
	end if;
END;