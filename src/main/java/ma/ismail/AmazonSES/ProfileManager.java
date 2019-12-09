package ma.ismail.AmazonSES;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("profileManager")
public class ProfileManager {
	
    @Value("${spring.profiles.active:}")
    private String activeProfiles;
 
    @Autowired
    private Environment environment;
    
    @Autowired
    private ConfigurableEnvironment env;
    
    @PostConstruct
    public void init() {
    	//env.setActiveProfiles("dev");
    }
    
    @PreDestroy
    public void goodBye() {
    	System.out.println("GoodBye Ismail...");
    }
 
    public void getActiveProfilesByEnvironment() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile in Environment - " + profileName);
        }  
    }
    
    public void getActiveProfilesByProperty () {
        for (String profileName : activeProfiles.split(",")) {
            System.out.println("Currently active profile in Property - " + profileName);
        }
    }
}
