


IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'lookup_table') AND type IN (N'U'))
  BEGIN
  CREATE TABLE lookup_table
    (
    id                  BIGINT                  IDENTITY (1, 1) PRIMARY KEY,
    field               VARCHAR(200),
    description           VARCHAR(230)
    )

        PRINT 'lookup_table Table created successfully'

  END

  ELSE
    BEGIN
      PRINT 'lookup_table table already exist....'
    END
GO



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'get_look_up_values') AND type IN (N'P', N'PC'))
  DROP PROCEDURE get_look_up_values
GO


CREATE PROCEDURE get_look_up_values

AS

	 SELECT *
	 FROM lookup_table (nolock)

	RETURN @@Error

GO


