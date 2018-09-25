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
package junit.org.rapidpm.nano.jdbc.v001.dao;

import junit.org.rapidpm.nano.jdbc.v001.User;
import org.rapidpm.frp.model.Result;
import org.rapidpm.nano.jdbc.query.QueryOneValue;

import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.org.rapidpm.nano.jdbc.v001.dao.UserDAO.toUser;

public interface QueryUser extends QueryOneValue<User> {

  @Override
  default Result<User> getFirstElement(final ResultSet resultSet) throws SQLException {
    return toUser()
        .apply(resultSet);
  }
}