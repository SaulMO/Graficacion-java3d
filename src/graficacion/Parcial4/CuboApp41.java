package graficacion.Parcial4;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;

public class CuboApp41 extends Applet
{
    public class Cubo extends Shape3D
    {
        public Cubo(Appearance appearance){
            this.setGeometry(cuboGeometry());
            this.setAppearance(appearance);
        }
        private Geometry cuboGeometry() {
            IndexedQuadArray indexedQuadArray = new IndexedQuadArray(8,GeometryArray.COORDINATES | GeometryArray.NORMALS,24);
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

            Vector3f norm = new Vector3f(-0.7f, 0.0f, 0.7f);
            indexedQuadArray.setNormal(0, norm);
            indexedQuadArray.setNormal(1, norm);
            norm.set(0.7f, 0.0f, 0.7f);
            indexedQuadArray.setNormal(2, norm);
            indexedQuadArray.setNormal(3, norm);
            norm.set(0.7f, 0.0f, -0.7f);
            indexedQuadArray.setNormal(4, norm);
            indexedQuadArray.setNormal(5, norm);
            norm.set(-0.7f, 0.0f, -0.7f);
            indexedQuadArray.setNormal(6, norm);
            indexedQuadArray.setNormal(7, norm);

            return indexedQuadArray;
        }
    }
    private Appearance appearanceCubo() {
        Appearance appear = new Appearance();
        Material material = new Material();
        material.setDiffuseColor(0.3490196f,0.8f,0.356862f);
        material.setShininess(50.0f);
        appear.setMaterial(material);
        PolygonAttributes polygonAttributes = new PolygonAttributes(PolygonAttributes.POLYGON_FILL,PolygonAttributes.CULL_NONE,6.0f,true);
        appear.setPolygonAttributes(polygonAttributes);
        return appear;
    }

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup transformGroupCubo = new TransformGroup();

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

        Cubo cubo = new Cubo(appearanceCubo());

        transformG.addChild(transformGroupCubo);
        transformG.addChild(objSpin);
        objSpin.addChild(rotator);
        objSpin.addChild(cubo);

        DirectionalLight lightD1 = new DirectionalLight();
        lightD1.setInfluencingBounds(new BoundingSphere());
        lightD1.setColor(new Color3f(0.2f, 0.6509803f, 0.431372f));
        Vector3f lightDir = new Vector3f(1.0f, 0.5f, -0.1f);
        lightDir.normalize();
        lightD1.setDirection(lightDir);
        objRoot.addChild(lightD1);

        //  Material   0.34901960784313725490196078431373 , 0.8 , 0.35686274509803

        AmbientLight lightA = new AmbientLight();
        lightA.setInfluencingBounds(new BoundingSphere());
        lightA.setColor(new Color3f(0.2f, 0.6509803f, 0.431372f));
        objRoot.addChild(lightA);

        PointLight lampLight = new PointLight();
        lampLight.setPosition(0.1f, 0.5f, -0.1f);
        lampLight.setInfluencingBounds(new BoundingSphere());
        lampLight.setColor(new Color3f(0.2f, 0.6509803f, 0.431372f));
        transformGroupCubo.addChild(lampLight);

        Background background = new Background(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(bounds);
        objRoot.addChild(background);

        return  objRoot;
    }

    public CuboApp41() {
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
        Frame frame = new MainFrame(new CuboApp41(), 600, 600);
    }
}