package sample;

/**
 * Created by SAimon22 on 10/22/2017.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BSTAnimation extends Application {
    ArrayList preorderList= new ArrayList();
    ArrayList orderList= new ArrayList();
    public String Sortlist(){
        Collections.sort(orderList);
        return orderList.toString();

    }
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BST<Integer> tree = new BST<>(); // Create a tree

        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree); // Create a BTView
        pane.setCenter(view);
        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btInorder = new Button("Show Inorder");
        Button btPreorder = new Button("Show Preorder");
        Button btPostorder = new Button("Show Postorder");
        HBox hBox = new HBox(5);

        hBox.getChildren().addAll(new Label("Enter a key: "),
                tfKey, btInsert, btDelete,btInorder,btPreorder,btPostorder);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) {
                // key is in the tree already
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            } else {
                tree.insert(key); // Insert a new key
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
                preorderList.add(key);
                orderList.add(key);
            }
        });
        btPostorder.setOnAction(e ->{
            view.setPostOrderView(" PostOrder List: "+Sortlist()+" ");
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) { // key is not in the tree
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            } else {
                tree.delete(key); // Delete a key
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
                for(int i=0;i<orderList.size();i++){
                    if(orderList.get(i).equals(key)){
                        preorderList.remove(i);
                        orderList.remove(i);
                    }
                }

            }
        });
        btInorder.setOnAction(e ->{

            view.setInorderView("Inorder List =  "+Sortlist()+" ");
        });
        btPreorder.setOnAction(e ->{
            //view.setPreorderView("Preorder List =  "+ preorderList.toString()+" ");
            view.setPreorderView("Preorder List =  "+ preorderList.toString()+" ");
        });

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 750, 250);
        primaryStage.setTitle("BSTAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

}

