package graficacion.CuartoParcial;

import java.applet.Applet;
import java.awt.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class IcosaedroApp4_1 extends Applet
{
    public class Icosaedro extends Shape3D
    {
        public Icosaedro(Appearance apariencia){
            this.setGeometry(icosaedroGeometry());
            this.setAppearance(apariencia);
        }
        private Geometry icosaedroGeometry() {
            IndexedTriangleArray geometryIcosaedro = new IndexedTriangleArray(12,GeometryArray.COORDINATES | GeometryArray.NORMALS,60);
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

            Vector3f norm = new Vector3f(-0.7f,0.0f,0.7f);
            geometryIcosaedro.setNormal(0, norm);
            geometryIcosaedro.setNormal(1, norm);
            geometryIcosaedro.setNormal(2, norm);
            norm.set(0.7f,0.0f,0.7f);
            geometryIcosaedro.setNormal(3, norm);
            geometryIcosaedro.setNormal(4, norm);
            geometryIcosaedro.setNormal(5, norm);
            norm.set(0.7f,0.0f,-0.7f);
            geometryIcosaedro.setNormal(6, norm);
            geometryIcosaedro.setNormal(7, norm);
            geometryIcosaedro.setNormal(8, norm);
            norm.set(-0.7f,0.0f,-0.7f);
            geometryIcosaedro.setNormal(9, norm);
            geometryIcosaedro.setNormal(10, norm);
            geometryIcosaedro.setNormal(11, norm);
            return geometryIcosaedro;
        }
    }

    private Appearance aparienciaIcosaedro() {
        Appearance appear = new Appearance();
        Material material = new Material();
        material.setDiffuseColor(0.29803921f,0.207843f,0,466666f);
        material.setShininess(20.0f);
        appear.setMaterial(material);
        PolygonAttributes polygonAttributes = new PolygonAttributes(PolygonAttributes.POLYGON_FILL,PolygonAttributes.CULL_NONE,6.0f,true);
        appear.setPolygonAttributes(polygonAttributes);
        return appear;
    }
    //Luz           0.2666666 , 0.1529411 , 0.643137
    //Material      0.29803921568627450980392156862745 , 0.2078431372549019607843137254902 , 0,466666666666

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup transformGroupIcosaedro = new TransformGroup();

        Transform3D rotate=new Transform3D();
        Transform3D tempRotate=new Transform3D();
        rotate.rotX(Math.PI/4.0d);
        tempRotate.rotY(Math.PI/5.0d);
        rotate.mul(tempRotate);
        TransformGroup transformG = new TransformGroup(rotate);
        objRoot.addChild(transformG);

        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        Alpha rotationAlpha = new Alpha(-1, 10000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        rotator.setSchedulingBounds(bounds);

        Vector3f transVector = new Vector3f();
        Transform3D transTransform = new Transform3D();
        transVector.set(0.0f, 0.0f, 0.0f);
        transTransform.setTranslation(transVector);
        transformG.setTransform(transTransform);

        Icosaedro cubo = new Icosaedro(aparienciaIcosaedro());

        transformG.addChild(transformGroupIcosaedro);
        transformG.addChild(objSpin);
        objSpin.addChild(rotator);
        objSpin.addChild(cubo);

        DirectionalLight lightD1 = new DirectionalLight();
        lightD1.setInfluencingBounds(new BoundingSphere());
        lightD1.setColor(new Color3f(0.2666666f,0.1529411f,0.643137f));
        Vector3f lightDir = new Vector3f(1.0f, 0.5f, -0.1f);
        lightDir.normalize();
        lightD1.setDirection(lightDir);
        objRoot.addChild(lightD1);

        AmbientLight lightA = new AmbientLight();
        lightA.setInfluencingBounds(new BoundingSphere());
        lightA.setColor(new Color3f(0.2666666f,0.1529411f,0.643137f));
        objRoot.addChild(lightA);

        PointLight lampLight = new PointLight();
        lampLight.setPosition(0.1f, 0.5f, -0.1f);
        lampLight.setInfluencingBounds(new BoundingSphere());
        lampLight.setColor(new Color3f(0.2666666f,0.1529411f,0.643137f));
        transformGroupIcosaedro.addChild(lampLight);

        Background background = new Background(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return  objRoot;
    }

    public IcosaedroApp4_1() {
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
        Frame frame = new MainFrame(new IcosaedroApp4_1(), 1000, 600
        );
    }
}