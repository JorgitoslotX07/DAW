package m03.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import m03.view.Ventana;

@SpringBootApplication
public class Application {
        private static final Logger logger = LogManager.getLogger(Application.class);

        public static void main(String[] args) {
                /*
                 * Esta comentado ya que no se porque no me funciona
                 */

                SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
                builder.headless(false);
                ConfigurableApplicationContext context = builder.run(args);
                logger.info("Inicio Aplicacion");

                Ventana ventana = new Ventana();
                ventana.setVisible(true);
        }
}
