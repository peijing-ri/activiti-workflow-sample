// パッケージを指定（ソースファイル場所）
package org.activiti.examples;


import java.util.List;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Pageable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

    private ProcessRuntime processRuntime;

    public DemoApplication(ProcessRuntime processRuntime) {
        this.processRuntime = processRuntime;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/process-definitions")
    public List<ProcessDefinition> getProcessDefinition(){
        return processRuntime.processDefinitions(Pageable.of(0, 100)).getContent();
    }

    @Override
    public void run(String... args) {
    }
}
