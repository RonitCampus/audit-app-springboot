package com.audit.app;

import com.audit.app.Db.DbConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditAppSpringbootApplicationTests {

	@Test
    public void contextLoads () throws SQLException
    {

        DbConfig.getInstance();
    }

}
