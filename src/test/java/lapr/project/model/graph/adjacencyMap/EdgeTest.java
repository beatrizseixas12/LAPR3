/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.graph.adjacencyMap;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author frodrigues
 */
 class EdgeTest {
    
    Edge<String, String> instance = new Edge<>() ;
    
    public EdgeTest() {
    }
    
    /**
     * Test of getElement method, of class Edge.
     */
    @Test
     void testGetElement() {
        System.out.println("getElement");

        String expResult = null;
        assertEquals(expResult, instance.getElement());

        Edge<String, String> instance1 = new Edge<>("edge1",1.0,null,null);
        expResult = "edge1";
        assertEquals(expResult, instance1.getElement());
    }

    /**
     * Test of setElement method, of class Edge.
     */
    @Test
     void testSetElement() {
        System.out.println("setElement");
        
        String eInf = "edge1";
        instance.setElement(eInf);
    
        assertEquals("edge1", instance.getElement());
    }

    /**
     * Test of getWeight method, of class Edge.
     */
    @Test
     void testGetWeight() {
        System.out.println("getWeight");
   
        double expResult = 0.0;
        assertEquals(expResult, instance.getWeight(), 0.0);
    }

    /**
     * Test of setWeight method, of class Edge.
     */
    @Test
     void testSetWeight() {
        System.out.println("setWeight");
        double ew = 2.0;
        instance.setWeight(ew);
        
        double expResult = 2.0;
        assertEquals(expResult, instance.getWeight(), 2.0);
    }

    /**
     * Test of getVOrig method, of class Edge.
     */
    @Test
     void testGetVOrig() {
        System.out.println("getVOrig");
   
        Object expResult = null;
        assertEquals(expResult, instance.getVOrig());
 
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
        assertEquals(vertex1.getElement(), otherEdge.getVOrig());
    }

    /**
     * Test of setVOrig method, of class Edge.
     */
    @Test
     void testSetVOrig() {
        System.out.println("setVOrig");
        
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        assertEquals(vertex1.getElement(), instance.getVOrig());
    }

    /**
     * Test of getVDest method, of class Edge.
     */
    @Test
     void testGetVDest() {
        System.out.println("getVDest");

        Object expResult = null;
        assertEquals(expResult, instance.getVDest());
        
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
        assertEquals(vertex1.getElement(), otherEdge.getVDest());
    }

    /**
     * Test of setVDest method, of class Edge.
     */
    @Test
     void testSetVDest() {
        System.out.println("setVDest");

        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVDest(vertex1);
        assertEquals(vertex1.getElement(), instance.getVDest());
    }

    /**
     * Test of getEndpoints method, of class Edge.
     */
    @Test
     void testGetEndpoints() {
        System.out.println("getEndpoints");
  
        String[] expResult = null;
        String[] result = instance.getEndpoints();
        assertArrayEquals(expResult, result);
  
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        instance.setVDest(vertex1);
        
        String[] expResult1 = {"Vertex1","Vertex1"};
        assertArrayEquals(expResult1, instance.getEndpoints());
    }

    /**
     * Test of equals method, of class Edge.
     */
    @Test
     void testEquals() {
        System.out.println("equals");

        assertNotEquals( null, instance,"should not be equal to null");

        assertEquals(instance, instance, "should be equal to itself");

        assertEquals(new Edge<> (instance), instance, "should be equal to a clone");
        
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);

        assertNotEquals(vertex1, instance);
        assertNotEquals(otherEdge, instance, "should not be equal to otherEdge");

        //Null vOrig
       Edge<String, String> edge = new Edge<>("edge", 2.0, null, vertex1);
       assertNotEquals(edge, otherEdge);
       assertNotEquals(otherEdge, edge);

       //Null vDest
       Edge<String, String> edge1 = new Edge<>("edge", 2.0,  vertex1, null);
       assertNotEquals(edge1, otherEdge);
       assertNotEquals(otherEdge, edge1);

       //Not null, different values
       assertNotEquals(otherEdge, edge);
       assertNotEquals(otherEdge, edge1);
    }

    /**
     * Test of compareTo method, of class Edge.
     */
    @Test
     void testCompareTo() {
        System.out.println("compareTo");
        
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
    
        int expResult = -1;
        int result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);
        
        otherEdge.setWeight(0.0);
        expResult = 0;
        result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);
        
        instance.setWeight(2.0);
        expResult = 1;
        result = instance.compareTo(otherEdge);
        assertEquals(expResult, result);
    }

    /**
     * Test of clone method, of class Edge.
     */
//    @Test
//     void testClone() {
//        System.out.println("clone");
//
//        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
//        Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);
//
//        Edge instClone = otherEdge.clone();
//
//        assertSame(otherEdge.getElement(), instClone.getElement(), "element should be equal");
//        assertEquals(instClone.getWeight(), otherEdge.getWeight(), "weight should be equal");
//
// 	String[] expResult = otherEdge.getEndpoints();
//        assertArrayEquals(expResult, instClone.getEndpoints());
//    }

   @Test
   void testCopyConstructor() {
      System.out.println("CopyConstructor");

      Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
      Edge<String, String> otherEdge = new Edge<>("edge1",1.0,vertex1,vertex1);

      Edge instClone = new Edge (otherEdge);

      assertSame(otherEdge.getElement(), instClone.getElement(), "element should be equal");
      assertEquals(instClone.getWeight(), otherEdge.getWeight(), "weight should be equal");

      String[] expResult = otherEdge.getEndpoints();
      assertArrayEquals(expResult, instClone.getEndpoints());
   }

    /**
     * Test of toString method, of class Edge.
     */
    @Test
     void testToString() {
        System.out.println("toString");
        
        instance.setElement("edge1");
        instance.setWeight(1.0);
        Vertex<String, String> vertex1 = new Vertex<>(1,"Vertex1");
        instance.setVOrig(vertex1);
        instance.setVDest(vertex1);
        
        String expResult = "(edge1) - 1.0 - Vertex1";
        String result = instance.toString().trim();
        assertEquals(expResult, result);
        
        System.out.println(instance);
    }

    @Test
   void testHashCode(){
       int expected = Objects.hash( instance.getElement(), instance.getWeight(), instance.getVOrig(), instance.getVDest());
       assertEquals(expected, instance.hashCode());
    }
    
}
