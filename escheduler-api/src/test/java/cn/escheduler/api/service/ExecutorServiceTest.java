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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutorServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorServiceTest.class);

    @Autowired
    private ExecutorService executorService;

    @Test
    public void startCheckByProcessDefinedId(){
        Map<String, Object> map = executorService.startCheckByProcessDefinedId(214);
        Assert.assertEquals(Status.SUCCESS, map.get(Constants.STATUS));

    }
    @Test
    public void putMsgWithParamsTest() {

        Map<String,Object> map = new HashMap<>(5);
        putMsgWithParams(map, Status.PROJECT_ALREADY_EXISTS);

        logger.info(map.toString());
    }


    void putMsgWithParams(Map<String, Object> result, Status status,Object ... statusParams) {
        result.put(Constants.STATUS, status);
        if(statusParams != null && statusParams.length > 0){
            result.put(Constants.MSG, MessageFormat.format(status.getMsg(), statusParams));
        }else {
            result.put(Constants.MSG, status.getMsg());
        }
    }
}