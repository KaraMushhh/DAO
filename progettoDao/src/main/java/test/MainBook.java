package test;
import it.betacom.service.*;
import it.betacom.service.impl.*;

public class MainBook {

	public static <T> void main(String[] args) {
		
		PrintServiceImpl<T> a = new PrintServiceImpl<T>();
		a.saveListAsPdf();
	}

}
