package graficacion.Parcial3;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import java.applet.Applet;
import java.awt.*;

public class CuboApp32 extends Applet
{
    // create scene graph branch group
    public class Cubo extends Shape3D
    {
        // create Shape3D with geometry and appearance
        // the geometry is created in method cuboGeometry
        // the appearance is created in method cuboAppearance
        public Cubo(){
            this.setGeometry(cuboGeometry());
            this.setAppearance(cuboAppearance());
        } // end of Cubo constructor
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
            Color3f color3f = new Color3f(0.80392156f, 0.843137f, 0.2235294f);
            indexedQuadArray.setColor(0,color3f);
            return indexedQuadArray;
        } // end of method icosaedroGeometry in class Icosaedro

        // create cubo appearance
        private Appearance cuboAppearance () {
            Appearance appearance = new Appearance();
            appearance.setDuplicateOnCloneTree(false);
            LineAttributes lineAttributes = new LineAttributes(4,LineAttributes.PATTERN_SOLID,true);
            PolygonAttributes polygonAttributes = new PolygonAttributes(PolygonAttributes.POLYGON_LINE,PolygonAttributes.CULL_NONE,6.0f,true);
            appearance.setLineAttributes(lineAttributes);
            appearance.setPolygonAttributes(polygonAttributes);
            return appearance;
        } // end of method cuboAppearance of class Cubo

    } // end of class Cubo
    // create scene graph branch group
    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere();

        //Create target TransformGroup with capabilities
        TransformGroup objMove = new TransformGroup();
        objMove.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        //Create Alpha
        Alpha alpha = new Alpha(-1,Alpha.INCREASING_ENABLE+Alpha.DECREASING_ENABLE,0,0,5000,1000,1000,5000,1000,1000);

        //Specify the axis of translation
        AxisAngle4f axisOfTra = new AxisAngle4f(0.0f,1.0f,0.0f,(float)Math.PI/-2.0f);
        Transform3D axisT3D = new Transform3D();
        axisT3D.set(axisOfTra);

        //Create Position Interpolator
        PositionInterpolator posInt = new PositionInterpolator(alpha, objMove, axisT3D,0.0f,-40.0f);
        posInt.setSchedulingBounds(bounds);

        //Create DistanceLOD object
        float[] distances = {5.0f,10.0f,20.0f};
        DistanceLOD dLOD = new DistanceLOD(distances,new Point3f());
        dLOD.setSchedulingBounds(bounds);

        objRoot.addChild(objMove);
        objRoot.addChild(posInt);
        objMove.addChild(dLOD);
        objMove.addChild(new Cubo());

        objRoot.compile();
        return objRoot;
    } // end of CreateSceneGraph method of CuboApp
    // Create a simple scene and attach it to the virtual universe
    public CuboApp32() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        BranchGroup scene = createSceneGraph();
        // SimpleUniverse is a Convenience Utility class
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        // This will move the ViewPlatform back a bit so the
        // objects in the scene can be viewed.
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(scene);
    } // end of IcosaedroApp constructor

    //  The following allows this to be run as an application
    //  as well as an applet

    public static void main(String[] args) {
        Frame frame = new MainFrame(new CuboApp32(), 600, 600);
    } // end of main method of CuboApp
} // end of class CuboApp