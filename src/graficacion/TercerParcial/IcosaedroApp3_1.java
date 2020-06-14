package graficacion.TercerParcial;

import java.applet.Applet;
import java.awt.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class IcosaedroApp3_1 extends Applet
{
    // create scene graph branch group
    public class Icosaedro extends Shape3D
    {
        public Icosaedro(){
            this.setGeometry(icosaedroGeometry());
            this.setAppearance(icosaedroAppearance());
        } // end of Icosaedro constructor
        private Geometry icosaedroGeometry() {
            //Número de vertices = 12
            //Número de Cordenadas Indice = 60
            IndexedTriangleArray geometryIcosaedro = new IndexedTriangleArray(12,GeometryArray.COORDINATES | GeometryArray.COLOR_3,60);
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
    public BranchGroup createSceneGraph(SimpleUniverse su) {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup vpTrans = null;
        BoundingSphere mouseBounds = null;

        vpTrans = su.getViewingPlatform().getViewPlatformTransform();

        objRoot.addChild(new Icosaedro());
        objRoot.addChild(new Axis());

        mouseBounds = new BoundingSphere(new Point3d(), 1000.0);

        MouseRotate myMouseRotate = new MouseRotate(MouseBehavior.INVERT_INPUT);
        myMouseRotate.setTransformGroup(vpTrans);
        myMouseRotate.setSchedulingBounds(mouseBounds);
        objRoot.addChild(myMouseRotate);

        MouseTranslate myMouseTranslate = new MouseTranslate(MouseBehavior.INVERT_INPUT);
        myMouseTranslate.setTransformGroup(vpTrans);
        myMouseTranslate.setSchedulingBounds(mouseBounds);
        objRoot.addChild(myMouseTranslate);

        MouseZoom myMouseZoom = new MouseZoom(MouseBehavior.INVERT_INPUT);
        myMouseZoom.setTransformGroup(vpTrans);
        myMouseZoom.setSchedulingBounds(mouseBounds);
        objRoot.addChild(myMouseZoom);

        // Let Java 3D perform optimizations on this scene graph.
        objRoot.compile();

        return objRoot;
    } // end of CreateSceneGraph method of IcosaedroApp

    // Create a simple scene and attach it to the virtual universe
    public IcosaedroApp3_1() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        BranchGroup scene = createSceneGraph(simpleU);
        simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.addBranchGraph(scene);
    } // end of IcosaedroApp constructor

    public static void main(String[] args) {
        System.out.print("MouseNavigatorApp.java \n- a demonstration of using the mouse ");
        System.out.println("behavior utility classes to provide navigational interaction in a Java 3D scene.");
        System.out.println("Hold the mouse button while moving the mouse to move.");
        System.out.println("     left mouse button      - rotate");
        System.out.println("     right mouse button     - translate");
        System.out.println("     Alt+left mouse button  - zoom");
        System.out.println("This is a simple example progam from The Java 3D API Tutorial.");
        System.out.println("The Java 3D Tutorial is available on the web at:");
        System.out.println("http://java.sun.com/products/java-media/3D/collateral");
        Frame frame = new MainFrame(new IcosaedroApp3_1(), 1000, 600);
    } // end of main method of IcosaedroApp
} // end of class IcosaedroApp