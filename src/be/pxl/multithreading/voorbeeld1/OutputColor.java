package be.pxl.multithreading.voorbeeld1;
/**
 * Om de regels in de console verschillende kleuren te geven, kan
 * je het volgende installeren.
 * https://marketplace.eclipse.org/content/ansi-escape-console#group-external-install-button
 * Als je op de "Install" knop klikt, kan je deze naar de eclipse workspace
 * draggen en droppen. 
 */
public enum OutputColor {
	BLACK("\033[0m"),
	RED("\033[31m"),
	GREEN("\033[32m"),
	BLUE("\033[34m"),
	MAGENTA("\033[35m"),
	CYAN("\033[36m");
	
	
	public String colorCode;
	
	private OutputColor(String colorCode) {
		this.colorCode = colorCode;
	}
	
	public String getColorCode() {
		return colorCode;
	}
}
