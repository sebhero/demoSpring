package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import sample.component.MainLayout;


@Lazy
@SpringBootApplication
public class SpringFxApplication extends Application {


	private ConfigurableApplicationContext applicationContext;

	@Autowired
	private MainLayout mainLayout;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.show();
	}

	@Override
	public void init() throws Exception {
		SpringApplication app = new SpringApplication(SpringFxApplication.class);
		app.setWebEnvironment(false);
		applicationContext = app.run();
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		applicationContext.close();
	}

}
