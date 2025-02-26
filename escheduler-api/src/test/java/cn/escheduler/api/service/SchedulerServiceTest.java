/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.escheduler.api.service;

import cn.escheduler.api.enums.Status;
import cn.escheduler.api.utils.Constants;
import cn.escheduler.common.enums.ReleaseState;
import cn.escheduler.common.enums.UserType;
import cn.escheduler.dao.model.Project;
import cn.escheduler.dao.model.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorServiceTest.class);

    @Autowired
    private SchedulerService schedulerService;

    @Test
    public void testSetScheduleState(){
        User loginUser = new User();
        loginUser.setId(27);
        loginUser.setUserType(UserType.GENERAL_USER);
        Project project = new Project();
        project.setName("project_test1");
        project.setId(21);

        Map<String, Object> map = schedulerService.setScheduleState(loginUser, project.getName(), 44, ReleaseState.ONLINE);
        Assert.assertEquals(Status.SUCCESS, map.get(Constants.STATUS));
    }

}