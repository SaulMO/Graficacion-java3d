package graficacion.Parcial2;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import java.applet.Applet;
import java.awt.*;

public class CuboApp22 extends Applet
{
    public class Cubo extends Shape3D
    {
        public Cubo(){
            this.setGeometry(cuboGeometry());
            this.setAppearance(cuboAppearance());
        } // end of Cubo constructor
        private Geometry cuboGeometry() {
            IndexedQuadArray indexedQuadArray = new IndexedQuadArray(8,GeometryArray.COORDINATES | GeometryArray.COLOR_3,24);
            //Indices
            indexedQuadArray.setCoordinate(0,new Point3f(-2f,-2f,-2f)); //A
            indexedQuadArray.setCoordinate(1,new Point3f(-2f,-2f,2f)); //B
            indexedQuadArray.setCoordinate(2,new Point3f(-2f,2f,-2f)); //C
            indexedQuadArray.setCoordinate(3,new Point3f(-2f,2f,2f)); //D
            indexedQuadArray.setCoordinate(4,new Point3f(2f,-2f,-2f)); //E
            indexedQuadArray.setCoordinate(5,new Point3f(2f,-2f,2f)); //F
            indexedQuadArray.setCoordinate(6,new Point3f(2f,2f,-2f)); //G
            indexedQuadArray.setCoordinate(7,new Point3f(2f,2f,2f)); //H
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
        Text3D nombreTexto3d = new Text3D(new Font3D(new Font("Consolas",Font.ITALIC,1),new FontExtrusion()),("Miriam Andrea R.L."),new Point3f(0.0f,-3.5f,0.0f));
        nombreTexto3d.setAlignment(Text3D.ALIGN_CENTER);
        Shape3D textShape3D = new Shape3D(nombreTexto3d);
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objSpin.addChild(new Cubo());
        objSpin.addChild(textShape3D);
        Alpha rotationAlpha = new Alpha(-1, 15000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);
        objRoot.addChild(objSpin);
        objRoot.compile();
        return objRoot;
    } // end of CreateSceneGraph method of CuboApp
    // Create a simple scene and attach it to the virtual universe
    public CuboApp22() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        BranchGroup scene = createSceneGraph();
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        Transform3D alejarUniverse = lookTowardsOriginFrom(new Point3d(0.0,0,-12));
        simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(alejarUniverse);
        simpleU.addBranchGraph(scene);
    } // end of IcosaedroApp constructor

    public Transform3D lookTowardsOriginFrom(Point3d point) {
        Transform3D move = new Transform3D();
        Vector3d up = new Vector3d(point.x, point.y+1, point.z);
        move.lookAt(point, new Point3d(0.0,0.0,0.0), up);
        return move;
    }

    public static void main(String[] args) {
        Frame frame = new MainFrame(new CuboApp22(), 600, 600);
    } // end of main method of CuboApp
} // end of class CuboApp