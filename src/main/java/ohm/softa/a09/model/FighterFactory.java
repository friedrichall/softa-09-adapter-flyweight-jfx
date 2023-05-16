package ohm.softa.a09.model;

import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
	private final ResourceLoader<Image> imageResourceLoader;

	private final Map<String, Image> imageMap = new HashMap<>();

	private Image loadImage(String path){
		if (!imageMap.containsKey(path))
			imageMap.put(path, imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "path"));
		return imageMap.get(path);

	}
	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		imageResourceLoader = new ResourceLoader<>(Image::new);
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() {
		switch (random.nextInt(NumberOfKnownFighterTypes)) {
			case 0:
				if(!imageMap.containsKey("fighter/awing.jpg"))
					imageMap.put("fighter/awing.jpg", imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/awing.jpg"));
				return new AWing(nameGenerator.generateName(), imageMap.get("fighter/awing.jpg"));
			case 1:
				if(!imageMap.containsKey("fighter/xwing.jpg"))
					imageMap.put("fighter/xwing.jpg", imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/xwing.jpg"));
				return new AWing(nameGenerator.generateName(), imageMap.get("fighter/xwing.jpg"));
			case 2:
				if(!imageMap.containsKey("fighter/ywing.jpg"))
					imageMap.put("fighter/ywing.jpg", imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/ywing.jpg"));
				return new AWing(nameGenerator.generateName(), imageMap.get("fighter/ywing.jpg"));
			case 3:
				if(!imageMap.containsKey("fighter/tiebomber.jpg"))
					imageMap.put("fighter/tiebomber.jpg", imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/tiebomber.jpg"));
				return new AWing(nameGenerator.generateName(), imageMap.get("fighter/tiebomber.jpg"));
			case 4:
				if(!imageMap.containsKey("fighter/tiefighter.jpg"))
					imageMap.put("fighter/tiefighter.jpg", imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/tiefighter.jpg"));
				return new AWing(nameGenerator.generateName(), imageMap.get("fighter/tiefighter.jpg"));
			default:
				return new TieInterceptor(nameGenerator.generateName(), imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), "fighter/tieinterceptor.jpg"));
		}
	}
}
