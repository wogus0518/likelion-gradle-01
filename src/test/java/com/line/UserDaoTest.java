package com.line;

import com.line.dao.LocalUserDaoImpl;
import com.line.domain.User;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest extends TestCase {

    @Test
    public void testAdd() throws SQLException {
        LocalUserDaoImpl repository = new LocalUserDaoImpl();
        String id = "12";
        repository.add(new User(id, "Mina", "123123"));
        User findUser = repository.findById(id);
        Assertions.assertThat(findUser.getId()).isEqualTo(id);
    }
}
