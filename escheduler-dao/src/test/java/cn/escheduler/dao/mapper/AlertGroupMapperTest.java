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
package cn.escheduler.dao.mapper;

import cn.escheduler.common.enums.AlertType;
import cn.escheduler.dao.datasource.ConnectionFactory;
import cn.escheduler.dao.model.AlertGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

@Ignore
public class AlertGroupMapperTest {


    AlertGroupMapper alertGroupMapper;


    @Before
    public void before(){
        alertGroupMapper = ConnectionFactory.getSqlSession().getMapper(AlertGroupMapper.class);
    }


    @Test
    public void testMapper(){
        AlertGroup alertGroup = new AlertGroup();
        alertGroup.setGroupName("alert group test");
        alertGroup.setDesc("alert group test");
        alertGroup.setGroupType(AlertType.EMAIL);
        alertGroup.setUpdateTime(new Date());
        alertGroup.setCreateTime(new Date());
        alertGroupMapper.insert(alertGroup);
        Assert.assertNotEquals(alertGroup.getId(), 0);
        alertGroup.setDesc("test alert group");
        alertGroupMapper.update(alertGroup);
        alertGroup = alertGroupMapper.queryById(alertGroup.getId());
        Assert.assertEquals(alertGroup.getDesc(), "test alert group");
        int delete = alertGroupMapper.delete(alertGroup.getId());
        Assert.assertEquals(delete, 1);

    }

}
