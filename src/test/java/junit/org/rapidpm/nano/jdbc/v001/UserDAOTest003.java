/**
 * Copyright © 2013 Sven Ruppert (sven.ruppert@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package junit.org.rapidpm.nano.jdbc.v001;

import junit.org.rapidpm.nano.jdbc.v001.dao.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rapidpm.frp.model.Result;
import org.rapidpm.nano.jdbc.JDBCConnectionPool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserDAOTest003 extends UserDAOBaseTest {

  @Test
  public void test001() throws Exception {
    final Result<JDBCConnectionPool> connectionPoolOptional = pools().getPool(poolname());
    final JDBCConnectionPool         connectionPool         = connectionPoolOptional.get();

    final UserDAO userDAO = new UserDAO()
        .workOnPool(connectionPool);

    userDAO
        .readAllUsers().
        ifFailed(Assertions::fail)
        .ifAbsent(() -> Assertions.fail("no data found"))
        .ifPresent(result -> {
          assertFalse(result.isEmpty());
          assertEquals(5, result.size());
        })
    .get()
    .forEach(e -> logger().info(e.toString()));


  }
}
