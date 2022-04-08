package Util;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Log {
	private static Logger log = Logger.getLogger(Log.class.getClass());
	static {
		PropertyConfigurator.configure("./src/main/resources/log4j2.properties");
	}
	public static void warn(String message) {
		log.warn(message);
	}
	public static void info(String message) {
		log.info(message);
	}
	public static void error(String message) {
		log.error(message);
	}
	public static void fatal(String message) {
		log.fatal(message);
	}
	public static void debug(String message) {
		log.debug(message);
	}
	

}
