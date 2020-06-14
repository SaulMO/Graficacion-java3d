package graficacion.CuartoParcial;
import java.applet.Applet;
import java.awt.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class IcosaedroApp4_2 extends Applet
{
    public class Icosaedro extends Shape3D
    {
        public Icosaedro(Appearance appearance){
            this.setGeometry(icosaedroGeometry());
            this.setAppearance(appearance);
        }
        private Geometry icosaedroGeometry() {
            IndexedTriangleArray geometryIcosaedro = new IndexedTriangleArray(12,GeometryArray.COORDINATES | GeometryArray.COLOR_3 | GeometryArray.TEXTURE_COORDINATE_2,60);
            //Indices
            geometryIcosaedro.setCoordinate(0,new Point3f(0.0f,0.0f,.384026f));//A
            geometryIcosaedro.setCoordinate(1,new Point3f(-.20f,-.275276f,.173205f));//B
            geometryIcosaedro.setCoordinate(2,new Point3f(.20f,-.275276f,.173205f));//C
            geometryIcosaedro.setCoordinate(3,new Point3f(-.323359f,.105065f,.173205f));//D
            geometryIcosaedro.setCoordinate(4,new Point3f(.323359f, .105065f,.173205f));//E
            geometryIcosaedro.setCoordinate(5,new Point3f(0.0f,.340260f,.173205f));//F
            geometryIcosaedro.setCoordinate(6,new Point3f(0.0f,-.340260f,-.173205f));//G
            geometryIcosaedro.setCoordinate(7,new Point3f(.323359f,-.105065f,-.173205f));//H
            geometryIcosaedro.setCoordinate(8,new Point3f(-.323359f,-.105065f,-.173205f));//I
            geometryIcosaedro.setCoordinate(9,new Point3f(.20f,.275276f, -.173205f));//J
            geometryIcosaedro.setCoordinate(10,new Point3f(-.20f,.275276f,-.173205f));//K
            geometryIcosaedro.setCoordinate(11,new Point3f(0.0f,0.0f,-.384026f));//L
            //Cara 1
            geometryIcosaedro.setCoordinateIndex(0,0);//A
            geometryIcosaedro.setCoordinateIndex(1,1);//B
            geometryIcosaedro.setCoordinateIndex(2,2);//C
            //Cara 2
            geometryIcosaedro.setCoordinateIndex(3,0);//A
            geometryIcosaedro.setCoordinateIndex(4,2);//C
            geometryIcosaedro.setCoordinateIndex(5,4);//E
            //Cara 3
            geometryIcosaedro.setCoordinateIndex(6,0);//A
            geometryIcosaedro.setCoordinateIndex(7,4);//E
            geometryIcosaedro.setCoordinateIndex(8,5);//F
            //Cara 4
            geometryIcosaedro.setCoordinateIndex(9,0);//A
            geometryIcosaedro.setCoordinateIndex(10,5);//F
            geometryIcosaedro.setCoordinateIndex(11,3);//D
            //Cara 5
            geometryIcosaedro.setCoordinateIndex(12,0);//A
            geometryIcosaedro.setCoordinateIndex(13,3);//D
            geometryIcosaedro.setCoordinateIndex(14,1);//B
            //Cara 6
            geometryIcosaedro.setCoordinateIndex(15,3);//D
            geometryIcosaedro.setCoordinateIndex(16,1);//B
            geometryIcosaedro.setCoordinateIndex(17,8);//I
            //Cara 7
            geometryIcosaedro.setCoordinateIndex(18,1);//B
            geometryIcosaedro.setCoordinateIndex(19,8);//I
            geometryIcosaedro.setCoordinateIndex(20,6);//G
            //Cara 8
            geometryIcosaedro.setCoordinateIndex(21,1);//B
            geometryIcosaedro.setCoordinateIndex(22,2);//C
            geometryIcosaedro.setCoordinateIndex(23,6);//G
            //Cara 9
            geometryIcosaedro.setCoordinateIndex(24,2);//C
            geometryIcosaedro.setCoordinateIndex(25,6);//G
            geometryIcosaedro.setCoordinateIndex(26,7);//H
            //Cara 10
            geometryIcosaedro.setCoordinateIndex(27,2);//C
            geometryIcosaedro.setCoordinateIndex(28,4);//E
            geometryIcosaedro.setCoordinateIndex(29,7);//H
            //Cara 11
            geometryIcosaedro.setCoordinateIndex(30,4);//E
            geometryIcosaedro.setCoordinateIndex(31,7);//H
            geometryIcosaedro.setCoordinateIndex(32,9);//J
            //Cara 12
            geometryIcosaedro.setCoordinateIndex(33,4);//E
            geometryIcosaedro.setCoordinateIndex(34,5);//F
            geometryIcosaedro.setCoordinateIndex(35,9);//J
            //Cara 13
            geometryIcosaedro.setCoordinateIndex(36,5);//F
            geometryIcosaedro.setCoordinateIndex(37,9);//J
            geometryIcosaedro.setCoordinateIndex(38,10);//K
            //Cara 14
            geometryIcosaedro.setCoordinateIndex(39,5);//F
            geometryIcosaedro.setCoordinateIndex(40,3);//D
            geometryIcosaedro.setCoordinateIndex(41,10);//K
            //Cara 15
            geometryIcosaedro.setCoordinateIndex(42,3);//D
            geometryIcosaedro.setCoordinateIndex(43,10);//K
            geometryIcosaedro.setCoordinateIndex(44,8);//I
            //Cara 16
            geometryIcosaedro.setCoordinateIndex(45,11);//L
            geometryIcosaedro.setCoordinateIndex(46,10);//K
            geometryIcosaedro.setCoordinateIndex(47,8);//I
            //Cara 17
            geometryIcosaedro.setCoordinateIndex(48,11);//L
            geometryIcosaedro.setCoordinateIndex(49,8);//I
            geometryIcosaedro.setCoordinateIndex(50,6);//G
            //Cara 18
            geometryIcosaedro.setCoordinateIndex(51,11);//L
            geometryIcosaedro.setCoordinateIndex(52,6);//G
            geometryIcosaedro.setCoordinateIndex(53,7);//H
            //Cara 19
            geometryIcosaedro.setCoordinateIndex(54,11);//L
            geometryIcosaedro.setCoordinateIndex(55,7);//H
            geometryIcosaedro.setCoordinateIndex(56,9);//J
            //Cara 20
            geometryIcosaedro.setCoordinateIndex(57,11);//L
            geometryIcosaedro.setCoordinateIndex(58,9);//J
            geometryIcosaedro.setCoordinateIndex(59,10);//K
            Color3f c2 = new Color3f(0.80784313f, 0.2823529f, 0.2431372f);
            geometryIcosaedro.setColor(0,c2);
            return geometryIcosaedro;
        }
    }

    private Appearance icosaedroAppearance(){
        Appearance twistAppear = new Appearance();
        PolygonAttributes polyAttrib = new PolygonAttributes();
        polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
        twistAppear.setPolygonAttributes(polyAttrib);
        TexCoordGeneration tcg = new TexCoordGeneration(TexCoordGeneration.OBJECT_LINEAR, TexCoordGeneration.TEXTURE_COORDINATE_2);
        twistAppear.setTexCoordGeneration(tcg);

        String filename = "background.jpg";
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
        objSpin.addChild(new Icosaedro(icosaedroAppearance()));
        Alpha rotationAlpha = new Alpha(-1,20000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);
        Background background = new Background();
        background.setColor(1.0f, 1.0f, 1.0f);
        objRoot.addChild(background);
        background.setApplicationBounds(new BoundingSphere());
        objRoot.compile();
        return objRoot;
    }

    public IcosaedroApp4_2() {
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
        Frame frame = new MainFrame(new IcosaedroApp4_2(), 1000, 600
        );
    }
}