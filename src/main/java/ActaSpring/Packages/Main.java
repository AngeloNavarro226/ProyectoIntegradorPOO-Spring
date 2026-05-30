package ActaSpring.Packages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(Main.class, args);
	}

	// MÉTODO PARA ABRIR EL NAVEGADOR
	@EventListener({ApplicationReadyEvent.class})
	public void abrirNavegador() {
		String url = "http://localhost:9000/actas";
		System.out.println("=> El servidor está listo. Intentando abrir el navegador en: " + url);
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				Runtime runtime = Runtime.getRuntime();
				String os = System.getProperty("os.name").toLowerCase();
				if (os.contains("win")) {
					runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
				} else if (os.contains("mac")) {
					runtime.exec("open " + url);
				} else if (os.contains("nix") || os.contains("nux")) {
					runtime.exec("xdg-open " + url);
				}
			}
		} catch (Exception e) {
			System.out.println("=> No se pudo abrir el navegador automáticamente. Ingrese a: " + url);
		}
	}
}