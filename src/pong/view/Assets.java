package pong.view;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;


/*
   Defining all assets used by application
   Common assets and asset handling (for all themes) here
   For specific handling see classes in theme/

   *** Nothing to do here ***

*/

public abstract class Assets {

    private final String IMAGE_DIR = "file:assets/img/";
    private final String SOUND_DIR = "file:assets/sound/";

    // A Map to store which image belongs to which object
    private final Map<Object, Image> objectImage = new HashMap<>();

    // ------------ Handling Colors and Images ------------------------
    public final Color colorFgText = Color.WHITE;
    public final Image splash = getImage("pong.png");

    public final Image leftPaddle = getImage("coolbluepaddle.png");
    public final Image rightPaddle = getImage("coolredpaddle.png");
    public final Image ball = getImage("coolBall.png");


    {
        // bind common, for all themes, objects/classes  (none right now)
    }

    public abstract Image getBackground();  // Implemented by subclasses


    // -------------- Audio handling -----------------------------

    public AudioClip ballHitPaddle = getSound("ballhitpaddle.wav");

    // -------------- Methods binding objects/classes to assets -----------------

    // This will bind an object to an image to be used in GUI
    public <T> void bind(T object, Image image) {
        objectImage.put(object, image);
    }

    public <T> void bind(T object, String imageFileName) {
        Image i = getImage(imageFileName);
        if (i != null) {
            objectImage.put(object, getImage(imageFileName));
        } else {
            throw new IllegalArgumentException("Missing image: " + IMAGE_DIR + imageFileName);
        }
    }

    // This will bind a class to an image to be used in GUI
    public void bind(Class<?> clazz, Image image) {
        objectImage.put(clazz, image);
    }

    // Get image to render
    public <T> Image get(T object) {
        Image i = objectImage.get(object);  // Try to find bound object
        if (i == null) {
            return get(object.getClass());  // .. if fail, check if class bound
        }
        return i;   // possible null, will throw exception, OK!
    }

    public Image get(Class<?> clazz) {
        return objectImage.get(clazz);
    }


    // ---------- Helpers ------------------------
    // protected means sub classes can access
    protected Image getImage(String fileName) {
        return new Image(IMAGE_DIR + fileName);
    }

    protected AudioClip getSound(String fileName) {
        return new AudioClip(SOUND_DIR + fileName);
    }
}
