/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package io.shardingjdbc.example.orchestration.spring.boot.jpa;

import io.shardingjdbc.example.orchestration.spring.boot.jpa.service.DemoService;
import io.shardingjdbc.orchestration.api.util.OrchestrationDataSourceCloseableUtil;
import io.shardingjdbc.orchestration.internal.OrchestrationShardingDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrchestrationSpringBootDataJpaMain {
    
    // CHECKSTYLE:OFF
    public static void main(final String[] args) {
    // CHECKSTYLE:ON
        ApplicationContext applicationContext = SpringApplication.run(OrchestrationSpringBootDataJpaMain.class, args);
        applicationContext.getBean(DemoService.class).demo();
        OrchestrationDataSourceCloseableUtil.closeQuietly(applicationContext.getBean(OrchestrationShardingDataSource.class));
        //OrchestrationDataSourceCloseableUtil.closeQuietly(applicationContext.getBean(OrchestrationMasterSlaveDataSource.class));
    }
}
