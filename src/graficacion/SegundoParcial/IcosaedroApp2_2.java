package graficacion.SegundoParcial;

import java.applet.Applet;
import java.awt.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class IcosaedroApp2_2 extends Applet {
    // create scene graph branch group
    public class Icosaedro extends Shape3D {
        // create Shape3D with geometry and appearance
        // the geometry is created in method icosaedroGeometry
        // the appearance is created in method icosaedroAppearance
        public Icosaedro(){
            this.setGeometry(icosaedroGeometry());
            this.setAppearance(icosaedroAppearance());
        } // end of Icosaedro constructor
        private Geometry icosaedroGeometry() {
            //Número de vertices = 12
            //Número de Cordenadas Indice = 60
            IndexedTriangleArray geometryIcosaedro = new IndexedTriangleArray(12,GeometryArray.COORDINATES | GeometryArray.COLOR_3,60);
            //Indices
            geometryIcosaedro.setCoordinate(0,new Point3f(0.0f,0.0f,3.84026f));//A
            geometryIcosaedro.setCoordinate(1,new Point3f(-2.0f,-2.75276f,1.73205f));//B
            geometryIcosaedro.setCoordinate(2,new Point3f(2.0f,-2.75276f,1.73205f));//C
            geometryIcosaedro.setCoordinate(3,new Point3f(-3.23359f,1.05065f,1.73205f));//D
            geometryIcosaedro.setCoordinate(4,new Point3f(3.23359f, 1.05065f,1.73205f));//E
            geometryIcosaedro.setCoordinate(5,new Point3f(0.0f,3.40260f,1.73205f));//F
            geometryIcosaedro.setCoordinate(6,new Point3f(0.0f,-3.40260f,-1.73205f));//G
            geometryIcosaedro.setCoordinate(7,new Point3f(3.23359f,-1.05065f,-1.73205f));//H
            geometryIcosaedro.setCoordinate(8,new Point3f(-3.23359f,-1.05065f,-1.73205f));//I
            geometryIcosaedro.setCoordinate(9,new Point3f(2.0f,2.75276f, -1.73205f));//J
            geometryIcosaedro.setCoordinate(10,new Point3f(-2.0f,2.75276f,-1.73205f));//K
            geometryIcosaedro.setCoordinate(11,new Point3f(0.0f,0.0f,-3.84026f));//L
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
        } // end of method icosaedroGeometry in class Icosaedro

        // create icosaedro appearance
        private Appearance icosaedroAppearance () {
            Appearance appearance = new Appearance();
            appearance.setDuplicateOnCloneTree(false);
            LineAttributes lineAttributes = new LineAttributes(4,LineAttributes.PATTERN_SOLID,true);
            PolygonAttributes polygonAttributes = new PolygonAttributes(PolygonAttributes.POLYGON_LINE,PolygonAttributes.CULL_NONE,6.0f,true);
            appearance.setLineAttributes(lineAttributes);
            appearance.setPolygonAttributes(polygonAttributes);
            return appearance;
        } // end of method IcosaedroAppearance of class Icosaedro
    } // end of class Icosaedro

    // create scene graph branch group
    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();
        Text3D text3d = new Text3D(new Font3D(new Font("MV Boli",Font.ITALIC,1),new FontExtrusion()),("Saúl Mondragón O."),new Point3f(0.0f,-4.4f,0.0f));
        text3d.setAlignment(Text3D.ALIGN_CENTER);
        Shape3D textShape3D = new Shape3D(text3d);
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objSpin.addChild(new Icosaedro());
        objSpin.addChild(textShape3D);
        Alpha rotationAlpha = new Alpha(-1,20000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);
        objRoot.addChild(objSpin);
        objRoot.compile();
        return objRoot;
    } // end of CreateSceneGraph method of IcosaedroApp

    // Create a simple scene and attach it to the virtual universe
    public IcosaedroApp2_2() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center",canvas3D);
        BranchGroup scene = createSceneGraph();
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        Transform3D move = cambiarPuntoDeVista(new Point3d(0.0,1,-21.0));
        simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(move);
        simpleU.addBranchGraph(scene);
    } // end of IcosaedroApp constructor

    public Transform3D cambiarPuntoDeVista(Point3d point) {
        Transform3D moverVista = new Transform3D();
        Vector3d desdeArriba = new Vector3d(point.x, point.y+1, point.z);
        moverVista.lookAt(point,new Point3d(0.0,0.0,0.0),desdeArriba);
        return moverVista;
    }

    public static void main(String[] args) {
        Frame frame = new MainFrame(new IcosaedroApp2_2(), 1000, 600);
    } // end of main method of IcosaedroApp
} // end of class IcosaedroApp