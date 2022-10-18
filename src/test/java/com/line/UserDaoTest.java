package com.line;

import com.line.dao.LocalConnectionMaker;
import com.line.dao.UserDao;
import com.line.domain.User;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest extends TestCase {

    @Test
    public void testAdd() throws SQLException {
        UserDao repository = new UserDao(new LocalConnectionMaker());
        String id = "13";
        repository.add(new User(id, "Mina", "123123"));
        User findUser = repository.findById(id);
        Assertions.assertThat(findUser.getId()).isEqualTo(id);
    }
}
