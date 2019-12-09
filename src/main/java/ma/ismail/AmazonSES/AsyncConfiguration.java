package ma.ismail.AmazonSES;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
//@ComponentScan(basePackages = "ma.ismail.AmazonSES")
@EnableAsync
@EnableScheduling
@PropertySource("classpath:application.properties")
public class AsyncConfiguration /* implements AsyncConfigurer */ {

	@Autowired
	private StandardEnvironment environment;

	@Bean(name = "threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}
	/*
	 * @Override public Executor getAsyncExecutor() { return new
	 * SimpleAsyncTaskExecutor(); }
	 * 
	 * /*
	 * 
	 * @Override public AsyncUncaughtExceptionHandler
	 * getAsyncUncaughtExceptionHandler() { return new
	 * CustomAsyncExceptionHandler(); }
	 */
	
	@Scheduled(fixedRate = 1000)
	public void reload() throws IOException {
		MutablePropertySources propertySources = environment.getPropertySources();
		Properties properties = new Properties();
		InputStream inputStream = getClass().getResourceAsStream("/application.properties");
		properties.load(inputStream);
		inputStream.close();
		propertySources.replace("class path resource [application.properties]",
				new PropertiesPropertySource("class path resource [application.properties]", properties));
	}

	@Scheduled(cron = "${cron.expression}")
	public void scheduleTaskUsingCronExpression() {

		long now = System.currentTimeMillis() / 1000;
		System.out.println("schedule tasks using cron jobs - " + now);
	}

	@Async
	@Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
	public void asyncMethodWithVoidReturnType() {
		System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
		System.out.println(environment.getProperty("fixedRate.in.milliseconds"));
	}

	@Async("threadPoolTaskExecutor")
	public Future<String> asyncMethodWithReturnType() {
		System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			return new AsyncResult<String>("hello world !!!!");
		} catch (InterruptedException e) {
			//
		}

		return null;
	}

}
