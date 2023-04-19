package org.sprint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {


    @Test
    public void testInsertNode() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(60);

        Assert.assertEquals(50, bst.root.getData());
        Assert.assertEquals(30, bst.root.left.getData());
        Assert.assertEquals(20, bst.root.left.left.getData());
        Assert.assertEquals(70, bst.root.right.getData());
        Assert.assertEquals(60, bst.root.right.left.getData());
    }

    @Test // Check the JSON representation of unformatted JSON response
    public void testGetJSONRepresentation() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(60);

        Gson gson = new Gson();
        String expectedJSON = gson.toJson(bst.root);

        String actualJSON = bst.getJSONRepresentation();
        Assert.assertEquals(expectedJSON, actualJSON);
    }
    @Test // Check the JSON representation of formatted JSON response
    public void testGetPrettyJSONRepresentation() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(60);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String expectedJSON = ((Gson) gson).toJson(bst.root);
        String actualJSON = bst.getPrettyJSONRepresentation();
        Assert.assertEquals(expectedJSON, actualJSON);
    }

    @Test
    public void testInsertNodeDuplicate() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(60);

        // Try to insert a duplicate value
        bst.insertNode(30);

        Assert.assertEquals(50, bst.root.getData());
        Assert.assertEquals(30, bst.root.left.getData());
        Assert.assertEquals(20, bst.root.left.left.getData());
        Assert.assertEquals(70, bst.root.right.getData());
        Assert.assertEquals(60, bst.root.right.left.getData());
        Assert.assertNull(bst.root.left.right); // The duplicate value should not be inserted
    }


}