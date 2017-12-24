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
        setTitle("Clase 2 de JOGL");
        setSize(700,700);
        
        GraphicListener listener = new GraphicListener();
        
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    }
    
    public static void main(String[] args) {
        Lineas_puntos frame = new Lineas_puntos();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public class GraphicListener implements GLEventListener{

        public void init(GLAutoDrawable arg0) {
            gl = arg0.getGL();
            gl.glEnable(gl.GL_BLEND);
            gl.glBlendFunc(gl.GL_SRC_ALPHA, gl.GL_ONE_MINUS_SRC_ALPHA);
            
            
        }

        public void display(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            
            gl.glClearColor(0, 0, 1, 0);
            
            gl.glMatrixMode(gl.GL_PROJECTION);
            glu.gluOrtho2D(0, 200, 0, 150);
            
            gl.glLineWidth(7);
            gl.glColor3f(1, 0, 0);
            
            gl.glBegin(gl.GL_LINES);
                gl.glVertex2f(0, 0);
                gl.glVertex2f(5,0);
            gl.glEnd();
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        
        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        
        }
        
    }
}
