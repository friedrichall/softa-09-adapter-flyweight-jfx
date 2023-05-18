package ohm.softa.a09.adapter;

import javafx.scene.image.Image;
import ohm.softa.a09.resource.ResourceLoader;

public class FxImageLoaderAdapter {
	private final ResourceLoader<Image> imageResourceLoader;
	public FxImageLoaderAdapter(){
		imageResourceLoader = new ResourceLoader<>(Image::new);
	}
	public Image loadImage(String resourcePath){
		return imageResourceLoader.loadResource(ClassLoader.getSystemClassLoader(), resourcePath);
	}
	public Image loadImage(ClassLoader resourceContext, String resourcePath){
		return imageResourceLoader.loadResource(resourceContext, resourcePath);
	}
}
