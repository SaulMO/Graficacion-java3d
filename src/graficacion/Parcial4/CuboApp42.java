package graficacion.Parcial4;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Point3f;
import java.applet.Applet;
import java.awt.*;

public class CuboApp42 extends Applet
{
    public class Cubo extends Shape3D
    {
        public Cubo(Appearance appearance){
            this.setGeometry(cuboGeometry());
            this.setAppearance(appearance);
        }
        private Geometry cuboGeometry() {
            IndexedQuadArray indexedQuadArray = new IndexedQuadArray(8,GeometryArray.COORDINATES | GeometryArray.COLOR_3,24);
            //Indices
            indexedQuadArray.setCoordinate(0,new Point3f(-0.5f,-0.5f,-0.5f)); //A
            indexedQuadArray.setCoordinate(1,new Point3f(-0.5f,-0.5f,0.5f)); //B
            indexedQuadArray.setCoordinate(2,new Point3f(-0.5f,0.5f,-0.5f)); //C
            indexedQuadArray.setCoordinate(3,new Point3f(-0.5f,0.5f,0.5f)); //D
            indexedQuadArray.setCoordinate(4,new Point3f(0.5f,-0.5f,-0.5f)); //E
            indexedQuadArray.setCoordinate(5,new Point3f(0.5f,-0.5f,0.5f)); //F
            indexedQuadArray.setCoordinate(6,new Point3f(0.5f,0.5f,-0.5f)); //G
            indexedQuadArray.setCoordinate(7,new Point3f(0.5f,0.5f,0.5f)); //H
            //Cara 1
            indexedQuadArray.setCoordinateIndex(0,0);//A
            indexedQuadArray.setCoordinateIndex(1,1);//B
            indexedQuadArray.setCoordinateIndex(2,3);//D
            indexedQuadArray.setCoordinateIndex(3,2);//C
            //Cara 2
            indexedQuadArray.setCoordinateIndex(4,0);//A
            indexedQuadArray.setCoordinateIndex(5,1);//B
            indexedQuadArray.setCoordinateIndex(6,5);//F
            indexedQuadArray.setCoordinateIndex(7,4);//E
            //Cara 3
            indexedQuadArray.setCoordinateIndex(8,1);//B
            indexedQuadArray.setCoordinateIndex(9,3);//D
            indexedQuadArray.setCoordinateIndex(10,7);//H
            indexedQuadArray.setCoordinateIndex(11,5);//F
            //Cara 4
            indexedQuadArray.setCoordinateIndex(12,2);//C
            indexedQuadArray.setCoordinateIndex(13,3);//D
            indexedQuadArray.setCoordinateIndex(14,7);//H
            indexedQuadArray.setCoordinateIndex(15,6);//G
            //Cara 5
            indexedQuadArray.setCoordinateIndex(16,0);//A
            indexedQuadArray.setCoordinateIndex(17,2);//C
            indexedQuadArray.setCoordinateIndex(18,6);//G
            indexedQuadArray.setCoordinateIndex(19,4);//E
            //Cara 6
            indexedQuadArray.setCoordinateIndex(20,4);//E
            indexedQuadArray.setCoordinateIndex(21,5);//F
            indexedQuadArray.setCoordinateIndex(22,7);//H
            indexedQuadArray.setCoordinateIndex(23,6);//G
            return indexedQuadArray;
        }
    }

    private Appearance cuboAppearance(){
        Appearance twistAppear = new Appearance();
        PolygonAttributes polyAttrib = new PolygonAttributes();
        polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
        twistAppear.setPolygonAttributes(polyAttrib);
        TexCoordGeneration tcg = new TexCoordGeneration(TexCoordGeneration.OBJECT_LINEAR, TexCoordGeneration.TEXTURE_COORDINATE_2);
        twistAppear.setTexCoordGeneration(tcg);

        String filename = "flores.jpg";
        System.out.println("attempt to load texture from file: "+filename);
        TextureLoader loader = new TextureLoader(filename, this);
        ImageComponent2D image = loader.getImage();

        if(image == null)
            System.out.println("load failed for texture: "+filename);

        Texture2D texture = new Texture2D(Texture.BASE_LEVEL, Texture.RGBA, image.getWidth(), image.getHeight());
        texture.setImage(0, image);
        texture.setEnable(true);
        twistAppear.setTexture(texture);

        return twistAppear;
    }

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRoot.addChild(objSpin);
        objSpin.addChild(new Cubo(cuboAppearance()));

        Alpha rotationAlpha = new Alpha(-1, 15000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);

        Background background = new Background(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);
        objRoot.compile();

        return objRoot;
    }

    public CuboApp42() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        BranchGroup scene = createSceneGraph();
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(scene);
    }

    public static void main(String[] args) {
        Frame frame = new MainFrame(new CuboApp42(), 600, 600);
    }
}