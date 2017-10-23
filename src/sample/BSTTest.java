package sample;

import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by SAimon22 on 10/22/2017.
 */
public class BSTTest {
    BST tree=new BST();
    ArrayList list= new ArrayList();
    //IntegerList list= new IntegerList();

    @org.junit.Test

    public void search() throws Exception {
        for(int i=0;i<100;i++){
            Assert.assertFalse(tree.search(i));
            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }
        for(int i=0;i<100;i++){
            Assert.assertFalse(tree.search(i));
            tree.insert(i);

            Assert.assertTrue(tree.search(i));
            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }


    }

    @org.junit.Test
    public void insert() throws Exception {

        for(int i=0;i<100;i++){
            Assert.assertFalse(tree.search(i));
            tree.insert(i);

            Assert.assertTrue(tree.search(i));
            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }
    }

    @org.junit.Test
    public void inorder() throws Exception {
    }

    @org.junit.Test
    public void postorder() throws Exception {
    }

    @org.junit.Test
    public void preorder() throws Exception {
    }

    @org.junit.Test
    public void getSize() throws Exception {

        for(int i=0;i<100;i++){
            Assert.assertFalse(tree.search(i));
            Assert.assertTrue(i==tree.getSize());
            tree.insert(i);


            Assert.assertTrue(tree.search(i));
            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }
    }

    @org.junit.Test
    public void delete() throws Exception {
        for(int i=0;i<100;i++){
            tree.insert(i);

            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }
        for(int i=0;i<100;i++){
            tree.delete(i);
            Assert.assertTrue(!tree.search(i));

            //Assert.assertArrayt("",assertTrue(true),assertTrue(true));
        }
    }

}