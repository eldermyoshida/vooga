package vooga.rts.gamedesign.factories;

import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Document;

public class UnitDecoder extends Decoder {

	private Factory myFactory;
	public UnitDecoder(Factory factory){
		myFactory = factory;
	}
	
	
	@Override
	public void create(Document doc) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException {
		

	}

}
