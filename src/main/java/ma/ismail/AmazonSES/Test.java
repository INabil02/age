package ma.ismail.AmazonSES;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@DependsOn("profileManager")
@ComponentScan(basePackages = "ma.ismail.AmazonSES")
//@Profile("dev")
public class Test {
	
	private static final Log logger = LogFactory.getLog(Test.class);
	
	@Autowired(required = true)
	ProfileManager profil;
	
	@PostConstruct
	public void init() {
		profil.getActiveProfilesByEnvironment();
	}
	
    private void start() {
        System.out.println("Message: " + profil.toString());
    }
    
	public void compareEqualsWithOperator() {
		String personalLoan = new String("cheap personal loans");
		String homeLoan = new String("cheap personal loans");
		     
		//since two strings are different object result should be false
		boolean result = personalLoan == homeLoan;
		System.out.println("Comparing two strings with == operator: " + result);
		     
		//since strings contains same content , equals() should return true
		result = personalLoan.equals(homeLoan);
		System.out.println("Comparing two Strings with same content using equals method: " + result);
		     
		homeLoan = personalLoan;
		//since both homeLoan and personalLoand reference variable are pointing to same object
		//"==" should return true
		result = (personalLoan == homeLoan);
		System.out.println("Comparing two reference pointing to same String with == operator: " + result);
	}
	
	@SuppressWarnings("restriction")
	public String decryptage(String str) throws Exception{
        SecretKey key = new SecretKeySpec("P@ssroot$/240204".getBytes(), "AES");
		Cipher dcipher = Cipher.getInstance("AES");
		dcipher.init(Cipher.DECRYPT_MODE, key);
		byte[] dec= new sun.misc.BASE64Decoder().decodeBuffer(str);
        byte[] utf8 = dcipher.doFinal(dec);
        return new String(utf8, "UTF-8");
	}
	
	@SuppressWarnings("restriction")
	public String cryptage(String str) throws Exception{
        SecretKey key = new SecretKeySpec("P@ssroot$/240204".getBytes(), "AES");
		Cipher ecipher = Cipher.getInstance("AES");
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		 byte[] utf8 = str.getBytes("UTF-8");
         byte[] enc = ecipher.doFinal(utf8);
         return new sun.misc.BASE64Encoder().encode(enc);
	}
	

	public static void main(String[] args) {
				
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
		try {
			ProfileManager app = null;
			Test main = null;
        for (String beanName : context.getBeanDefinitionNames()) {
        	if(beanName.equals("profileManager")) {
        		app = (ProfileManager)context.getBean(beanName);
        	}
        	if(beanName.equals("test")) {
        		main = (Test)context.getBean(beanName);
        	}
            System.out.println(beanName);
        }
		
        //Test app = context.getBean(Test.class);
        app.getActiveProfilesByProperty();
        app.getActiveProfilesByEnvironment();
        
        //main.profil.getActiveProfilesByProperty();

		//	System.out.println(app.decryptage("ohH75ouRJZU9K+9mqh4o5u7+radU40gkUfcccVvc920="));
		//	System.out.println(app.cryptage("Ag3nFAxZ+S/gwfIqm8jneYCI2MM/Br/WpvGgDm7MnbLB"));
		//	System.out.println(app.decryptage("QOlse3H4ofiYdHlLOJrO46FqHcBCdBKV/IwLPdJpC5j8vUNVvJDoE1npEGchDmfi"));
			
		} catch(Exception e){
			logger.info("context", e);
		}
		
		context.close();
	}

}
