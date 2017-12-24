/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 *
 * @author YonePC
 */
public class Lineas_puntos extends JFrame{
    
    static GL gl;
    static GLU glu;
    
    public Lineas_puntos(){
        setTitleSizeJFrame();
        
        GraphicListener listener = instantiateGraphicListener();
        
        GLCanvas canvas = createOpenGLCanvas();
        addListener(canvas, listener);
        transferContentFromJFrameToGLCanvas(canvas);
    }

    private void transferContentFromJFrameToGLCanvas(GLCanvas canvas) {
        getContentPane().add(canvas);
    }

    private void addListener(GLCanvas canvas, GraphicListener listener) {
        canvas.addGLEventListener(listener);
    }

    private GLCanvas createOpenGLCanvas() {
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        return canvas;
    }

    private GraphicListener instantiateGraphicListener() {
        GraphicListener listener = new GraphicListener();
        return listener;
    }

    private void setTitleSizeJFrame() {
        setTitle("Clase 2 de JOGL");
        setSize(700,700);
    }
    
    public static void main(String[] args) {
        Lineas_puntos frame = new Lineas_puntos();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public class GraphicListener implements GLEventListener{

        public void init(GLAutoDrawable arg0) {
            getGL(arg0);
            enableBlendColors();
            
            
            
        }


        public void display(GLAutoDrawable arg0) {
            getOpenGLUtility();
            getGL(arg0);
            
            specifyClearColorValuesWhenBufferYsEmpty();
            
            applyMatrixOpperationsToProjectionMatrixStack();
            setUp2DViewingRegion();
            
            setLineWidth();
            setLineColorToRed();

            gl.glColor3f(0, 1, 0);
                drawGreenY();
                drawGreenO();
                drawGreenN();
                gl.glVertex2f(180,100);
                gl.glVertex2f(200,100);
                
                gl.glVertex2f(180,100);
                gl.glVertex2f(180,75);
                
                gl.glVertex2f(180,75);
                gl.glVertex2f(200,75);
                
                gl.glVertex2f(180,75);
                gl.glVertex2f(180,50);
                
                gl.glVertex2f(180,50);
                gl.glVertex2f(200,50);
            gl.glEnd();
        }

        private void drawGreenN() {
            gl.glVertex2f(140,100);
            gl.glVertex2f(140,50);
            
            gl.glVertex2f(140,100);
            gl.glVertex2f(170,50);
            
            gl.glVertex2f(170,50);
            gl.glVertex2f(170, 100);
        }

        private void drawGreenO() {
            gl.glVertex2f(100,100);
            gl.glVertex2f(100,50);
            
            gl.glVertex2f(100,50);
            gl.glVertex2f(125,50);
            
            gl.glVertex2f(125,50);
            gl.glVertex2f(125,100);
            
            gl.glVertex2f(125,100);
            gl.glVertex2f(100,100);
        }

        private void drawGreenY() {
            gl.glBegin(gl.GL_LINES);
            gl.glVertex2f(0, 100);
            gl.glVertex2f(50, 70);
            
            gl.glVertex2f(50, 70);
            gl.glVertex2f(50, 0);
            
            gl.glVertex2f(50, 70);
            gl.glVertex2f(100, 100);
        }


        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        
        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        
        }
        private void endVertex() {
            gl.glVertex2f(25.5f,0);
        }

        private void initialVertex() {
            gl.glVertex2f(0, 0);
        }

        private void delimitEndVertices() {
            gl.glEnd();
        }

        private void delimitInitialVertices() {
            gl.glBegin(gl.GL_LINES);
        }

        private void setLineColorToRed() {
            gl.glColor3f(1, 0, 0);
        }

        private void setLineWidth() {
            gl.glLineWidth(7);
        }

        private void setUp2DViewingRegion() {
            glu.gluOrtho2D(0, 200, 0, 150);
        }

        private void applyMatrixOpperationsToProjectionMatrixStack() {
            gl.glMatrixMode(gl.GL_PROJECTION);
        }

        private void specifyClearColorValuesWhenBufferYsEmpty() {
            gl.glClearColor(0, 0, 1, 0);
        }

        private void getOpenGLUtility() {
            glu = new GLU();
        }
        
        private void enableBlendColors() {
            gl.glEnable(gl.GL_BLEND);
            gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);
        }

        private void getGL(GLAutoDrawable arg0) {
            gl = arg0.getGL();
        }
    }
}
